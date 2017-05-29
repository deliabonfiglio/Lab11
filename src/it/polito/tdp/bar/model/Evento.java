package it.polito.tdp.bar.model;

public class Evento implements Comparable<Evento>{

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return gruppo + ", time:" + time + ", tipo:" + tipo + "\n";
	}


	public enum EventType{IN , OUT};
	
	private GruppoClienti gruppo;
	private int time;				//istante di tempo in cui si verifica l'evento
	private EventType tipo;
	
	public Evento(GruppoClienti gruppo, int time, EventType tipo) {
		super();
		this.gruppo = gruppo;
		this.time = time;
		this.tipo = tipo;
	}

	/**
	 * @return the gruppo
	 */
	public GruppoClienti getGruppo() {
		return gruppo;
	}

	/**
	 * @param gruppo the gruppo to set
	 */
	public void setGruppo(GruppoClienti gruppo) {
		this.gruppo = gruppo;
	}

	/**
	 * @return the time
	 */
	public int getTime() {
		return time;
	}


	/**
	 * @param time the time to set
	 */
	public void setTime(int time) {
		this.time = time;
	}


	/**
	 * @return the tipo
	 */
	public EventType getTipo() {
		return tipo;
	}


	/**
	 * @param tipo the tipo to set
	 */
	public void setTipo(EventType tipo) {
		this.tipo = tipo;
	}


	@Override
	public int compareTo(Evento altro) {
		return this.time-altro.time;
	}

}
