package com.flightnetwork.resourse;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.ResultActions;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.flightNetWork.model.FlightInfo;
import com.flightNetWork.service.FlightService;
import com.flightnetwork.basetest.SpringBaseTest;

public class FlightNetWorkApplicationTests extends SpringBaseTest{

	@MockBean
	private FlightService flightService;
	
	private HashSet<FlightInfo> flightInfo;
	
	String origin="pune";
	String destination="us";
	
	@Before
	public void Initialize() throws JsonParseException, JsonMappingException,IOException{
		
	ObjectMapper mapper=new ObjectMapper();
	flightInfo=mapper.readValue(ClassLoader.getSystemResourceAsStream("FLIGHTNETWORK.json"), mapper.getTypeFactory().constructParametricType(Set.class, FlightInfo.class));
	}

	@Test
	public void testGetFlight()throws Exception{
		when(flightService.getFlightInfo(origin, destination)).thenReturn(flightInfo);
		ResultActions result=getMockMvc().perform(get("/searchflight/"+origin+"/"+destination)).andDo(print()).andExpect(status().isOk())	;
		
	}
	
}
