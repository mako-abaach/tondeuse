package com.mowltnow.tondeuse.model;

public abstract class Coordonne {
	
	
	private long x;
	private long y;
	
	
	
	public Coordonne() {
		super();
	}
	public Coordonne(long x, long y) {
		super();
		this.x = x;
		this.y = y;
	}
	public long getX() {
		return x;
	}
	public void setX(long x) {
		this.x = x;
	}
	public long getY() {
		return y;
	}
	public void setY(long y) {
		this.y = y;
	}
	
	

}
