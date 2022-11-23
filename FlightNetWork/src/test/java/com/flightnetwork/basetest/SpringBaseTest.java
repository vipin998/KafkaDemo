package com.flightnetwork.basetest;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.flightNetWork.FlightNetWorkApplication;

/**
 * This class is inherited by class that require the spring web context to be
 * loaded.
 * 
 * @author vipin
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = FlightNetWorkApplication.class)
@WebAppConfiguration
@DirtiesContext

public class SpringBaseTest extends BaseTest {

	@Autowired

	private WebApplicationContext wac;
	private MockMvc mockMvc;

	/**
	 * set the genrices component before any test case run
	 * 
	 * @throws Exception
	 */
	@Before
	public void setUpInSpringBaseTest() throws Exception {

		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();

	}

	/**
	 * get the spring webapplication context
	 * 
	 * @return
	 */
	public WebApplicationContext getwac() {

		return wac;

	}

	/**
	 * get the spring mock object
	 * 
	 * @return
	 */
	public MockMvc getMockMvc() {
		return mockMvc;
	}
}
