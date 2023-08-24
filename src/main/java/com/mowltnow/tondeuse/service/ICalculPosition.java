package com.mowltnow.tondeuse.service;

import java.util.List;

import com.mowltnow.tondeuse.model.Gazon;
import com.mowltnow.tondeuse.model.Tondeuse;

public interface ICalculPosition {
	
	public void calculPositionSuivante(Tondeuse tondeuse);
	
	public boolean validerPosition(Gazon gazon, long x, long y);
	
	public void majOrientation(Tondeuse tondeuse, String action);
	
	public String recupPositionFinal(List<Tondeuse> tondeuses);
	

}
