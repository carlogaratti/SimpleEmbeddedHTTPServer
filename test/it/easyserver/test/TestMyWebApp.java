package it.easyserver.test;

import static org.junit.Assert.*;

import java.io.IOException;
import java.net.MalformedURLException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.omg.CORBA.INITIALIZE;

import it.easyserver.BasicFormScreen;
import it.easyserver.MyApp;

import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.WebResponse;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

public class TestMyWebApp{
 
	private int port = 8090;
	private MyApp myApp;
	

	
	@Test
	public void serverOK() throws Exception{
		myApp = new MyApp(port, new  WhiteScreen());
	    WebClient webClient = new WebClient();
	    HtmlPage page = webClient.getPage("http://localhost:"+port);
	    assertEquals(200, page.getWebResponse().getStatusCode());
	    
	}
	
	@Test
	public void screenBlank() throws Exception{
		myApp = new MyApp(port, new  WhiteScreen());
	    WebClient webClient = new WebClient();
	    HtmlPage page = webClient.getPage("http://localhost:"+port);
	    assertEquals("<html><body></body></html>", page.getWebResponse().getContentAsString().trim());
	    
	}
	
	@Test
	public void screenWelcome() throws Exception{
		myApp = new MyApp(port, new  BasicFormScreen());
	    WebClient webClient = new WebClient();
	    HtmlPage page = webClient.getPage("http://localhost:"+port);
	    assertEquals("<html><body>ciao!</body></html>", page.getWebResponse().getContentAsString().trim());
	    
	}
	/*
	@After
	public void after() throws Exception{
		myApp.stop();
		
	}
	*/
}
