package client;

import http.HttpServer;
import tools.Logger;
import tools.Statistic;

public class client_start {
	
	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		Statistic stat = new Statistic();
		Client client = new Client("127.0.0.1", 8888, stat);
		
	    Logger logger = new Logger();
	    logger.setType("debug");

		
	    logger.debug("[client_start] Start Client");
		//new Thread(new ClientStatistic(stat)).start();
		//new Thread(new HttpServer(stat)).start();
		
		for (int i = 0; i < 1; i++) {
			logger.debug("[client_start] Start Client");
			new Thread(client).start();
		}
	}

	private static class ClientStatistic implements Runnable {
 	
		private Statistic stat;
		 
	    private ClientStatistic(Statistic stat) throws Throwable {
	        this.stat = stat;
	    }
	
	    public void run() {
	
		    Logger logger = new Logger();
		    logger.setType("stat");
			try {
		    	for (int i=0;i<=200;i++)
				{
					
					logger.stat("[ClientStatistic] getCountRequests:   " + stat.getCountRequests());
					stat.clearCountRequests();
					logger.stat("[ClientStatistic] getCountThread:     " + stat.getCountThread());
					Thread.sleep(1000);
				}
			} catch (InterruptedException e) {
			    e.printStackTrace();
			}
	    }
	}
}
