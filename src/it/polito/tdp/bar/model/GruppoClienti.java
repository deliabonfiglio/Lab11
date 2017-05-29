package it.polito.tdp.bar.model;

public class GruppoClienti implements Comparable<GruppoClienti>{
	
	private int num;
	private int queuetime;
	private String id;
	private int durata;
	private float tolleranza;
	private Tavolo tavolo;

	public GruppoClienti(String id, int queuetime,int num, int durata, float tolleranza) {
		super();
		this.num = num;
		this.queuetime = queuetime;
		this.id = id;
		this.durata = durata;
		this.tolleranza = tolleranza;
	}

	/**
	 * @return the num
	 */
	public int getNum() {
		return num;
	}

	/**
	 * @param num the num to set
	 */
	public void setNum(int num) {
		this.num = num;
	}

	/**
	 * @return the queuetime
	 */
	public int getQueuetime() {
		return queuetime;
	}

	/**
	 * @param queuetime the queuetime to set
	 */
	public void setQueuetime(int queuetime) {
		this.queuetime = queuetime;
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the durata
	 */
	public int getDurata() {
		return durata;
	}

	/**
	 * @param durata the durata to set
	 */
	public void setDurata(int durata) {
		this.durata = durata;
	}

	/**
	 * @return the tolleranza
	 */
	public float getTolleranza() {
		return tolleranza;
	}

	/**
	 * @param tolleranza the tolleranza to set
	 */
	public void setTolleranza(float tolleranza) {
		this.tolleranza = tolleranza;
	}

	/**
	 * @return the tavolo
	 */
	public Tavolo getTavolo() {
		return tavolo;
	}

	/**
	 * @param tavolo the tavolo to set
	 */
	public void setTavolo(Tavolo tavolo) {
		this.tavolo = tavolo;
	}

	@Override
	public int compareTo(GruppoClienti altro) {
		return this.queuetime-altro.queuetime;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "GruppoClienti:" +id+ " numero persone: "+ num + ", queuetime: " + queuetime + ", durata: " + durata
				+ ", tolleranza: " + tolleranza + ", tavolo: " + tavolo + "\n";
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		GruppoClienti other = (GruppoClienti) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

		
	
}