package com.smatoo.app;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.stereotype.Service;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.smatoo.app.controller.AcceptController;
import com.smatoo.app.tracker.UniqueTracker;

@WebMvcTest(AcceptController.class)
@MockBean(UniqueTracker.class)
class ControllerTest {
	@Autowired
	private MockMvc mvc;
	
	@Test
	void validCall() throws Exception
	{
		mvc.perform(MockMvcRequestBuilders.get("/api/smaato/accept?id=10"))
		   .andExpect(MockMvcResultMatchers.status().isOk());
	}
	@Test
	void withoutId() throws Exception
	{
		mvc.perform(MockMvcRequestBuilders.get("/api/smaato/accept?"))
		   .andExpect(MockMvcResultMatchers.status().is4xxClientError());
	}
	@Test
	void withoutIdWithendpoint() throws Exception
	{
		mvc.perform(MockMvcRequestBuilders.get("/api/smaato/accept?endpoint=GET"))
		   .andExpect(MockMvcResultMatchers.status().is4xxClientError());
	}

}