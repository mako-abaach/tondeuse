package com.mowltnow.tondeuse.model;

public class Tondeuse extends Coordonne {
	
	
	private long id;
	
	private Orientation orientation;
	
	private String[] mouvement;
	
	private Gazon gazon;
	

	public Tondeuse() {
		super();
	}

	public Tondeuse(long id, long x, long y, Orientation orientation, String[] mouvement, Gazon gazon) {
		super(x,y);
		this.id = id;
		this.orientation = orientation;
		this.mouvement = mouvement;
		this.gazon = gazon;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}



	public Orientation getOrientation() {
		return orientation;
	}

	public void setOrientation(Orientation orientation) {
		this.orientation = orientation;
	}

	public String[] getMouvement() {
		return mouvement;
	}

	public void setMouvement(String[] mouvement) {
		this.mouvement = mouvement;
	}

	public Gazon getGazon() {
		return gazon;
	}

	public void setGazon(Gazon gazon) {
		this.gazon = gazon;
	}
	
	
	
	
	
	

}
