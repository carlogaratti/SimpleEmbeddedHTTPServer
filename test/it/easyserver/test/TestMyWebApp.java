package it.easyserver.test;

import static org.junit.Assert.*;

import java.io.IOException;
import java.net.MalformedURLException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.omg.CORBA.INITIALIZE;

import it.easyserver.MyApp;

import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.WebResponse;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

public class TestMyWebApp{
 
	private int port = 8090;
	MyApp myApp;

	@Before
	public void before() throws Exception{
		myApp = new MyApp(port);
		
	}
	
	@Test
	public void serverOK() throws Exception{
	    WebClient webClient = new WebClient();
	    HtmlPage page = webClient.getPage("http://localhost:"+port);
	    assertEquals(200, page.getWebResponse().getStatusCode());
	    
	}
	
	@After
	public void after() throws Exception{
		myApp.stopServer();
		
	}
}
