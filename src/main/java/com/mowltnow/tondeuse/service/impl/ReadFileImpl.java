package com.mowltnow.tondeuse.service.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;

import com.mowltnow.tondeuse.model.Gazon;
import com.mowltnow.tondeuse.model.Orientation;
import com.mowltnow.tondeuse.model.Tondeuse;
import com.mowltnow.tondeuse.service.IReadFile;



/**
 * cette class a pour objectif de convertir le fichier text en liste des tondeuse
 */
@Service
public class ReadFileImpl implements IReadFile {

	@Override
	public List<Tondeuse> readFile(String path) throws IOException {
		
	       File file = new File(path);
	       String[] dataFile = null;
	        
	        if (file.exists()) {
	            FileInputStream inputStream = new FileInputStream(file);
	            byte[] bytes = FileCopyUtils.copyToByteArray(inputStream);
	             dataFile = new String(bytes).split("\r\n");
	             
	            inputStream.close();
	        }	
		return prepareListTondeuse(dataFile);
	}
	
	
	public List<Tondeuse> prepareListTondeuse(String[] dataFile) throws NumberFormatException {
		
		List<Tondeuse> listTondeuse = new ArrayList<Tondeuse>();

        String[] fildes = dataFile[0].split(" ");
        long x = Long.parseLong(fildes[0]);
        long y = Long.parseLong(fildes[1]);
	    Gazon g = new Gazon(x, y);


	
	     for(int i=1; i<dataFile.length; i+=2) {
		
				Tondeuse tondeuse = new Tondeuse();
				tondeuse.setId(i);
				tondeuse.setGazon(g);
				
				// line 1 
				String[] coordonne = dataFile[i].split(" ");
				tondeuse.setX(Long.parseLong(coordonne[0]));
				tondeuse.setY(Long.parseLong(coordonne[1]));	
				tondeuse.setOrientation(Orientation.valueOf(coordonne[2]));
				
				// line 2
				tondeuse.setMouvement(dataFile[i+1].split(""));	
				
				listTondeuse.add(tondeuse);
				
	     }
	   return listTondeuse;
	}
	

	

}
