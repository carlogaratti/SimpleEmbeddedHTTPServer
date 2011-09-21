package it.easyserver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
 
import java.io.IOException;
 
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.handler.AbstractHandler;
 
public class MyEasyServer extends AbstractHandler
{
	private Server server;
	
    public void handle(String target,
                       Request baseRequest,
                       HttpServletRequest request,
                       HttpServletResponse response) 
        throws IOException, ServletException
    {
        response.setContentType("text/html;charset=utf-8");
        response.setStatus(HttpServletResponse.SC_OK);
        baseRequest.setHandled(true);
        
    }
 
    public void start(int port) throws Exception
    {
        server = new Server(port);
        server.setHandler(new MyEasyServer());
        server.start();
    }
    
    public void stopServer() throws Exception{
    	server.stop();
    }
}
