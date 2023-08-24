package com.mowltnow.tondeuse.service;

import java.io.IOException;
import java.util.List;

import com.mowltnow.tondeuse.model.Tondeuse;

public interface IReadFile {
	
	public List<Tondeuse> readFile(String path)  throws IOException;

}
