package it.polito.tdp.bar.model;

public class Tavolo {
	
	private int numPosti;
	private boolean occupato;
	
	public Tavolo(int numPosti) {
		super();
		this.numPosti = numPosti;
		this.occupato = false;
	}

	/**
	 * @return the numPosti
	 */
	public int getNumPosti() {
		return numPosti;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Tavolo con numPosti=" + numPosti + "\n";
	}

	/**
	 * @param numPosti the numPosti to set
	 */
	public void setNumPosti(int numPosti) {
		this.numPosti = numPosti;
	}

	/**
	 * @return the occupato
	 */
	public boolean isOccupato() {
		return occupato;
	}

	/**
	 * @param occupato the occupato to set
	 */
	public void setOccupato(boolean occupato) {
		this.occupato = occupato;
	}
	
	
}
