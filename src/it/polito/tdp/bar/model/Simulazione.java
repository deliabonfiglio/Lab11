package it.polito.tdp.bar.model;

import java.util.*;
import java.util.PriorityQueue;
import it.polito.tdp.bar.model.Evento.EventType;

public class Simulazione {
	//parametri simulazione	
	
	//modello del mondo
	private PriorityQueue<GruppoClienti> codaClienti;
	private List<Tavolo> listaTavoli;
	private int tavolioccupati;
	
	//misure di interesse
	private int clientisoddisfatti=0;
	private int clientiinsoddisfatti=0;
	private int totclienti=0;
	
	// Event queue
	private PriorityQueue<Evento> queue;	

	public Simulazione() {
		super();
		codaClienti= new PriorityQueue<>();
		queue = new PriorityQueue<>();
		listaTavoli= new ArrayList<Tavolo>();
	}
	
	public void avvia() {
		this.aggiungiGruppi();
    	this.aggiungiTavoli();
    	this.run();
	}

	public void aggiungiGruppi(){
		int tarrivo= 0;
		
		for(int i=0; i<2000; i++){
			tarrivo += (int)(1 + Math.random()*10);
			int durata = (int)(60 + (Math.random()*60+1));
			
			float tolleranza =(float) (Math.random());
				if(tolleranza > 0.9)
					tolleranza = (float) 0.9; 
			
			GruppoClienti g = new GruppoClienti("Gruppo"+i, tarrivo, (int)(1+Math.random()*10), durata, tolleranza);
			codaClienti.add(g);
			
			Evento e = new Evento(g, tarrivo, EventType.IN);
			queue.add(e);
		}
		//System.out.println(codaClienti.toString());
	}
	
	public void aggiungiTavoli(){
		listaTavoli.add( new Tavolo(10));
		listaTavoli.add( new Tavolo(10));
		 
		listaTavoli.add( new Tavolo(4));
		listaTavoli.add( new Tavolo(4));
		listaTavoli.add( new Tavolo(4));
		listaTavoli.add( new Tavolo(4));
		listaTavoli.add( new Tavolo(4));
		
		listaTavoli.add( new Tavolo(8));
		listaTavoli.add( new Tavolo(8));
		listaTavoli.add( new Tavolo(8));
		listaTavoli.add( new Tavolo(8));

		listaTavoli.add( new Tavolo(6));
		listaTavoli.add( new Tavolo(6));
		listaTavoli.add( new Tavolo(6));
		listaTavoli.add( new Tavolo(6));

		class ComparatoreTavoli<T> implements Comparator<Tavolo>{

			@Override
			public int compare(Tavolo t1, Tavolo t2) {
				return t1.getNumPosti()-t2.getNumPosti();
			}
		}
		
		Collections.sort(listaTavoli , new ComparatoreTavoli<Tavolo>());
		//System.out.println(listaTavoli.toString());
	}
	
	public void run() {
		while (!queue.isEmpty()) {
			Evento e = queue.poll();
			System.out.println(e);

			switch (e.getTipo()) {
			case IN:
				processInEvent(e);
				break;
			case OUT:
				processOutEvent(e);
				break;
			
			}
		}
	}
	
	private void processInEvent(Evento e) {
			GruppoClienti g = e.getGruppo();
			boolean seduti= false;
			
			for(Tavolo t : listaTavoli){
				if (!seduti && 50*t.getNumPosti()/100<=e.getGruppo().getNum() && g.getNum()<= t.getNumPosti() && t.isOccupato()==false){
						g.setTavolo(t);
						this.clientisoddisfatti += g.getNum();
						this.totclienti += g.getNum();
						seduti = true;
						
						//devo rimuovere il gruppo dalla coda dei gruppi?
						Evento eventoout = new Evento(g, e.getTime()+g.getDurata(), EventType.OUT);
						queue.add(eventoout);		
				} 
			}
			if(seduti == false){
				//funzione di probabilità di andare al banco
				disponibilitaAndareAlBanco(e.getGruppo());
			}
	}
		
	private void disponibilitaAndareAlBanco(GruppoClienti gruppoClienti) {
		float prob = (float) Math.random();
		
		if(gruppoClienti.getTolleranza() >= prob){
			this.clientisoddisfatti += gruppoClienti.getNum();	
			this.totclienti += gruppoClienti.getNum();
		} else  {
			this.clientiinsoddisfatti += gruppoClienti.getNum();
			this.totclienti += gruppoClienti.getNum();
		}

	}

	private void processOutEvent(Evento e) {
		//se si verifica l'evento di uscita allora il tavolo si libera e posso far sedere qualcun altro
		e.getGruppo().getTavolo().setOccupato(false);
	}

	public int getNumTotClienti() {
		return this.totclienti;
	}

	public int getNumClientiSod() {
		return this.clientisoddisfatti;
	}

	public int getNumClientiInsod() {
		return this.clientiinsoddisfatti;
	}
}