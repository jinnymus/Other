package http;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
//import java.util.stream.Stream;


import tools.Logger;
import tools.Statistic;

public class HttpServer implements Runnable {

	protected Statistic stat;
    public Logger logger;
	
    public HttpServer(Statistic stat) {
        this.stat   = stat;
        Logger logger = new Logger();
        logger.setType("stat");
        this.logger = logger;
   }
    
    public void run() {

        try {
	        ServerSocket ss = new ServerSocket(8085);
            logger.debug("[HttpServer] started");	
	        while (true) 
	        {
	            Socket s = ss.accept();
	            logger.debug("[HttpServer] Client accepted");	
				new Thread(new SocketProcessor(s, stat)).start();
	        }
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
	private static class SocketProcessor implements Runnable {
	 	
		protected Statistic stat;
    	private Socket s;
        private InputStream is;
        private OutputStream os;
		 
	        private SocketProcessor(Socket s, Statistic stat) throws Throwable {
	        	this.stat = stat;
	            this.s = s;
	            this.is = s.getInputStream();
	            this.os = s.getOutputStream();
	        }

	        public void run() {
	 	       Logger logger = new Logger();
		       logger.setType("stat");
		       //Statistic stat = new Statistic();
		       
	            try {
	                //readInputHeaders();
	            	String path = getPathHeaders();
	            	
	            	if (path.equals("/CountRequests"))
	            	{
	            		writeResponse(stat.getCountRequestsByString());
	            	}
	            	else if (path.equals("/CountThread"))
	            	{
	            		writeResponse(stat.getCountThreadByString());
	            	}
	            	else
	            	{
	            		//writeResponse("<html><body><h1>Hello from Habrahabr</h1></body></html>");
	            		writeResponse("getCountRequests: " + stat.getCountRequests() +
	            					  "<br>getCountThread: " + stat.getCountThread());
	            	}
	            	
	            } catch (Throwable t) {
	                /*do nothing*/
	            } finally {
	                try {
	                    s.close();
	                } catch (Throwable t) {
	                    /*do nothing*/
	                }
	            }
	            logger.debug("Client processing finished");
	        }

	        private void writeResponse(String s) throws Throwable {
	            String response = "HTTP/1.1 200 OK\r\n" +
	                    "Server: YarServer/2009-09-09\r\n" +
	                    "Content-Type: text/html\r\n" +
	                    "Content-Length: " + s.length() + "\r\n" +
	                    "Connection: close\r\n\r\n";
	            String result = response + s;
	            os.write(result.getBytes());
	            os.flush();
	        }
	        
	        private String getPathHeaders() throws Throwable {
	            BufferedReader br = new BufferedReader(new InputStreamReader(is));
	 	        Logger logger = new Logger();
		        logger.setType("stat");
		        //Stream<String> str = br.lines();
		        
	            while(true) {
	                String s = br.readLine();
	                if(s == null || s.trim().length() == 0) {
	                    break;
	                }
	                String[] line = s.split(" ");
	                if (line[0].equals("GET"))
	                {
		                logger.debug("[getPathHeaders] Path: " + line[1]);
	                	return line[1];
	                }
	            }
				return null;
	        }
	        
	        private void readInputHeaders() throws Throwable {
	            BufferedReader br = new BufferedReader(new InputStreamReader(is));
	 	        Logger logger = new Logger();
		        logger.setType("none");
		        //Stream<String> str = br.lines();
		        
	            while(true) {
	                String s = br.readLine();
	                if(s == null || s.trim().length() == 0) {
	                    break;
	                }
	                logger.debug("[readInputHeaders] s: " + s);
	            }
	        }
	    }
	}

