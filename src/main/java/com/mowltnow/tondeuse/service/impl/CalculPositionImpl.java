package com.mowltnow.tondeuse.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mowltnow.tondeuse.model.Constantes;
import com.mowltnow.tondeuse.model.Gazon;
import com.mowltnow.tondeuse.model.Orientation;
import com.mowltnow.tondeuse.model.Tondeuse;
import com.mowltnow.tondeuse.service.ICalculPosition;



/**
 * Cette classe englobe les actions de la tondeuse
 */
@Service
public class CalculPositionImpl implements ICalculPosition {

	/**
	 * cette methode permet de calculer la position suivante de la tondeuse
	 */
	@Override
	public void calculPositionSuivante(Tondeuse tondeuse) {
		
		long newX = tondeuse.getX();
		long newY = tondeuse.getY();


	        switch (tondeuse.getOrientation()) {
	            case N:
	                newY = tondeuse.getY() + 1;
	                break;
	            case W:
	                newX = tondeuse.getX() - 1;
	                break;
	            case S:
	            	newY = tondeuse.getY() - 1;
	                break;
	            case E:
	               newX = tondeuse.getX() + 1;
	                break;
	            default:
	                break;
	        }
	        
	        if (validerPosition(tondeuse.getGazon(), newX, newY)) {
	        	tondeuse.setX(newX);
	        	tondeuse.setY(newY);
	        }
	}

	/**
	 * cette methode verifie si la tondeuse se trouve en dehors du terrain
	 */
	@Override
	public boolean validerPosition(Gazon gazon, long x, long y) {
		
	      if ( x <= gazon.getX() && x >= 0 && y <= gazon.getX() && y >= 0)
	         return true;
	      
	   return false;

	}


	/**
	 * cette methode permet de mettre a jour l'orientation de la tondeuse
	 */
	@Override
	public void majOrientation(Tondeuse tondeuse, String action) {
		
		Orientation or = tondeuse.getOrientation();

        if (action.equals(Constantes.Droite)) {
            if (or == Orientation.E){
                or =  Orientation.S;}
            else if (or == Orientation.N){
                or = Orientation.E;}
            else if (or == Orientation.W){
                or = Orientation.N;}
            else if (or == Orientation.S){
                or = Orientation.W;}
        } else if (action.equals(Constantes.Gauche)) {
            if (or == Orientation.E){
                or = Orientation.N;}
            else if (or == Orientation.N){
                or = Orientation.W;}
            else if (or == Orientation.W){
                or =  Orientation.S;}
            else if (or == Orientation.S){
                or = Orientation.E;}
        }
        
        tondeuse.setOrientation(or);

	}

	@Override
	public String recupPositionFinal(List<Tondeuse> tondeuses) {
		
		StringBuilder stringBuilder = new StringBuilder();
		

		for (Tondeuse tondeuse : tondeuses) {
			
		    for (String action : tondeuse.getMouvement()) {
		    	
		    	if (action.equals(Constantes.Avancer) ) {
		    		
		    	     calculPositionSuivante(tondeuse);	    		
		    		
		    	} else {
		    		majOrientation(tondeuse, action);
		    	}
				
			}
		    
		    stringBuilder.append(String.valueOf(tondeuse.getX()))
		                 .append(" ")
		                 .append(String.valueOf(tondeuse.getY()))
		                 .append(" ")
		                 .append(tondeuse.getOrientation().toString())
		                 .append(" ");
		}
		
		return stringBuilder.toString();
	}
	
	


}
