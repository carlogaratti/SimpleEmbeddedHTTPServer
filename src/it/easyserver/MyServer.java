package it.easyserver;

import it.easyserver.test.WhiteScreen;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.AbstractHandler;

public class MyServer extends AbstractHandler{
	
	private Screen screen;

	public MyServer(Screen screen) {
		this.screen = screen;
	}
	
	public void handle(String target, Request baseRequest, HttpServletRequest request, HttpServletResponse response) 
			throws IOException, ServletException{
		
				//response.setContentType("text/html;charset=utf-8");
				response.setStatus(HttpServletResponse.SC_OK);
				baseRequest.setHandled(true);
				String out = screen.view();
				response.getWriter().println(out);
	}
	



}
