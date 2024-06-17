package com.auspost.datedifferencecalculator.test;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.auspost.datedifferencecalculator.model.DateOutput;
import com.auspost.datedifferencecalculator.service.DateService;


@SpringBootTest
@AutoConfigureMockMvc
public class DateControllerIntegrationTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private DateService dateService;
	
	@Test
	void testCalculateDateDifferenceWithInvalidDate() throws Exception{
		mockMvc.perform(post("/api/dates/calculate")
			.contentType(MediaType.APPLICATION_JSON)
			.content("[{\"date1\": \"12 12 2010\", \"date2\": \"15 15 2000\"}]"))
			.andExpect(status().isBadRequest());
		
	}
	
	  @Test
	    void testCalculateDateDifference() throws Exception {
	      
	        when(dateService.calculateDateDifference(any())).thenReturn(new DateOutput("20 04 1995", "09 04 2003", 2911));
	        mockMvc.perform(post("/api/dates/calculate")
	                .contentType(MediaType.APPLICATION_JSON)
	                .content("{\"date1\": \"20 04 1995\", \"date2\": \"09 04 2003\"}"))
	                .andExpect(status().isOk())
	                .andExpect(jsonPath("$.date1").value("20 04 1995"))
	                .andExpect(jsonPath("$.date2").value("09 04 2003"))
	                .andExpect(jsonPath("$.difference").value(2911));
	    }
	
	

}
