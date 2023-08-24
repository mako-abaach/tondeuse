/**
 * 
 */
package com.mowltnow.tondeuse.service.impl;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mowltnow.tondeuse.model.Constantes;
import com.mowltnow.tondeuse.model.Gazon;
import com.mowltnow.tondeuse.model.Orientation;
import com.mowltnow.tondeuse.model.Tondeuse;
import com.mowltnow.tondeuse.service.ICalculPosition;

/**
 * 
 */
@SpringBootTest
class CalculPositionImplTest {
	
	@Autowired
	ICalculPosition calculPosition;

	
	@Test
	void testCalculPositionSuivante() {
		Tondeuse tondeuse = new Tondeuse();
		Gazon gazon = new Gazon(5, 5);
		tondeuse.setGazon(gazon);
		tondeuse.setOrientation(Orientation.S);
		tondeuse.setX(5);
		tondeuse.setY(5);
		calculPosition.calculPositionSuivante(tondeuse);
		assertEquals(4, tondeuse.getY());
	}
	
	@Test
	void testValiderPosition() {
		Gazon gazon = new Gazon(5, 5);
		assertEquals(true, calculPosition.validerPosition(gazon, 4, 4));
		assertEquals(false, calculPosition.validerPosition(gazon, 6, 4)); ;

	}

	@Test
	void testMajOrientation() {
		Tondeuse tondeuse = new Tondeuse();
		tondeuse.setOrientation(Orientation.E);
		calculPosition.majOrientation(tondeuse, Constantes.Droite);
		
		assertEquals(Orientation.S, tondeuse.getOrientation());
	}


	@Test
	void testRecupPositionFinal() {
		List<Tondeuse> tondeuses = new ArrayList<Tondeuse>();
		Gazon gazon = new Gazon(5, 5);
		String[] mouvement = {"G","A","G","A","G","A","G","A","A"};
		Tondeuse tondeuse = new Tondeuse(1, 1, 2, Orientation.N, mouvement, gazon);			
	    String[] mouvement2 = {"A", "A","D","A","A","D","A","D","D","A"};
		Tondeuse tondeuse2 = new Tondeuse(1, 3, 3, Orientation.E, mouvement2, gazon);

		tondeuses.add(tondeuse);
		tondeuses.add(tondeuse2);
		assertEquals(Constantes.result, calculPosition.recupPositionFinal(tondeuses));
	}

}
