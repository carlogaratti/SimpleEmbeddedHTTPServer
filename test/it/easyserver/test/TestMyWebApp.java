package it.easyserver.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.easyserver.MyEasyServer;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.WebResponse;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

public class TestMyWebApp{
 
	@Test
	public void junitOK() {
		assertEquals(true, true);
	}

	
	@Test
	public void serverOK() throws Exception {
		MyEasyServer myEasyServer = new MyEasyServer();
		myEasyServer.start(8090);
	    WebClient webClient = new WebClient();
	    HtmlPage page = webClient.getPage("http://localhost:8090");
	    assertEquals(200, page.getWebResponse().getStatusCode());
	    myEasyServer.stopServer();
	}
}
