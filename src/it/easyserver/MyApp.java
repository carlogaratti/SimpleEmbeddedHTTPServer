package it.easyserver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
 
import java.io.IOException;
 
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.handler.AbstractHandler;
 
public class MyApp 
{
	private Server server;
	
    public MyApp(int port) throws Exception {
    	server = new Server(port);
        server.setHandler(new MyServer());
        server.start();
	}
    public void stopServer() throws Exception{
    	server.stop();                        
    }                                         

}
