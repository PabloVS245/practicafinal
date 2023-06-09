package com.atsistemas.proyectofinal.proyectofinal.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import org.springframework.web.context.WebApplicationContext;
@SpringBootTest
@AutoConfigureMockMvc
public class AvailabilitiesControllerTest {
	
			
		@Autowired
		protected MockMvc mockMvc;

		/** Contexto de la aplicación */
		@Autowired
		protected WebApplicationContext wac;

		@BeforeEach
		public void setUp() {
	//		this.mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
		}


		@Test
		public void testListarAvailabilities() throws Exception {
			mockMvc.perform(MockMvcRequestBuilders.get("/availabilities").accept(MediaType.APPLICATION_JSON))
					.andDo(MockMvcResultHandlers.print()).andExpect(MockMvcResultMatchers.status().isOk());

		}





		


	}



