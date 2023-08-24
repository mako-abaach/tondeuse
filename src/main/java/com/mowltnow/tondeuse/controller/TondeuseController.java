package com.mowltnow.tondeuse.controller;


import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mowltnow.tondeuse.model.Resultat;
import com.mowltnow.tondeuse.model.Tondeuse;
import com.mowltnow.tondeuse.service.ICalculPosition;
import com.mowltnow.tondeuse.service.IReadFile;


@RestController
public class TondeuseController {
	
	
	@Autowired
	ICalculPosition calculPosition;
	
	@Autowired
	IReadFile readFile;
	
	
	
	@GetMapping("tondeuse/positionfinal")
	public ResponseEntity<Resultat>  getPositionFinalTondeuses(@RequestParam("pathFile") String pathFile) throws IOException {
		
		
		
		List<Tondeuse> tondeuses = readFile.readFile(pathFile);
		
		String position = calculPosition.recupPositionFinal(tondeuses);
		
		Resultat resultat = new Resultat(position);
			
        return ResponseEntity.ok(resultat) ;
			
	}
	


}
