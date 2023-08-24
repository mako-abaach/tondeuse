package com.mowltnow.tondeuse.controller;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.mowltnow.tondeuse.model.Constantes;
import com.mowltnow.tondeuse.model.Tondeuse;
import com.mowltnow.tondeuse.service.ICalculPosition;
import com.mowltnow.tondeuse.service.IReadFile;

@WebMvcTest(TondeuseController.class)
class TondeuseControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	ICalculPosition position;
	
	@MockBean
	IReadFile readFile;

	


	@Test
	void testGetPositionFinalTondeuses() throws Exception {
		
		String path = "src/main/resources/tondeuse.txt";
		
		
		List<Tondeuse> mockTondeuses = new ArrayList<Tondeuse>();
        when(readFile.readFile(path)).thenReturn(mockTondeuses);
        when(position.recupPositionFinal(mockTondeuses)).thenReturn(Constantes.result);

        ResultActions result = mockMvc.perform(MockMvcRequestBuilders.get("/tondeuse/positionfinal?pathFile="+path)
                .accept(MediaType.APPLICATION_JSON));
        result.andExpect(MockMvcResultMatchers.status().isOk())
              .andExpect(MockMvcResultMatchers.jsonPath("$.position").value(Constantes.result));
		
	}
	

}
