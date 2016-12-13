package server;

import java.net.ServerSocket;
import java.net.Socket;
import java.io.IOException;

import tools.Logger;
import tools.Statistic;

public class MultiThreadedServer implements Runnable{

    protected int          serverPort   	= 8080;
    protected ServerSocket serverSocket 	= null;
    protected boolean      isStopped    	= false;
    protected Thread       runningThread	= null;
    public Statistic	   stat;
    public Logger logger;

    public MultiThreadedServer(int port, Statistic stat){
        this.serverPort = port;
        this.stat = stat;
        this.stat.countRequests=0;
        this.stat.countThread=0;
        Logger logger = new Logger();
        logger.setType("stat");
        this.logger = logger;
    }

    public void run()
    {
        synchronized(this)
        {
        	logger.debug("[MultiThreadedServer] Thread.currentThread") ;
            this.runningThread = Thread.currentThread();
        }
        
        logger.debug("[MultiThreadedServer] openServerSocket") ;
        openServerSocket();
        
        while(!isStopped()){
            Socket clientSocket = null;
            logger.debug("[MultiThreadedServer] init serverSocket") ;
            try 
            {
            	logger.debug("[MultiThreadedServer] serverSocket.accept") ;
                clientSocket = this.serverSocket.accept();
            } 
            catch (IOException e) 
            {
                if(isStopped()) 
                {
                    logger.debug("[MultiThreadedServer] Server Stopped.") ;
                    return;
                }
                throw new RuntimeException("Error accepting client connection", e);
            }
            logger.debug("[MultiThreadedServer] New Thread ClientPort " + clientSocket.getPort() ) ;
            //countThread += 1;
            
            new Thread(new WorkerRunnable(clientSocket, "Multithreaded Server",this.stat)).start();
            
            logger.debug("[MultiThreadedServer] end") ;
            
        }
        logger.debug("[MultiThreadedServer] Server Stopped.") ;
    }


    private synchronized boolean isStopped() {
        return this.isStopped;
    }

    public synchronized void stop(){
        this.isStopped = true;
        try {
            this.serverSocket.close();
        } catch (IOException e) {
            throw new RuntimeException("[MultiThreadedServer] Error closing server", e);
        }
    }

    private void openServerSocket() {
        try {
            this.serverSocket = new ServerSocket(this.serverPort);
        } catch (IOException e) {
            throw new RuntimeException("[MultiThreadedServer] Cannot open port 8080", e);
        }
    }

}
