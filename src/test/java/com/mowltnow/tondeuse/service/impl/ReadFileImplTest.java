package com.mowltnow.tondeuse.service.impl;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mowltnow.tondeuse.model.Tondeuse;
import com.mowltnow.tondeuse.service.IReadFile;

@SpringBootTest
class ReadFileImplTest {
	
	@Autowired
	IReadFile readFile;

	@Test
	void testReadFile() throws IOException {
	List<Tondeuse> tondeuses =	readFile.readFile("src/main/resources/tondeuse.txt");
	
	assertEquals(1, tondeuses.get(0).getId());
	}
}
