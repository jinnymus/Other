package server;

import tools.Logger;
import tools.Statistic;


public class server_start {
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Statistic stat = new Statistic();
		MultiThreadedServer server = new MultiThreadedServer(6666, stat);
		
	    Logger logger = new Logger();
	    logger.setType("info");

		
	    logger.info("[Starter Server] Start Server");
		new Thread(server).start();

		try {
			logger.debug("[Starter Server] Sleep");
			for (int i=0;i<=20000000;i++)
			{
				
				logger.stat("[Server] getCountRequests:   " + stat.getCountRequests());
				stat.clearCountRequests();
				logger.stat("[Server] getCountThread:     " + stat.getCountThread());
				Thread.sleep(1000);
			}
		    //Thread.sleep(200 * 1000);
		} catch (InterruptedException e) {
		    e.printStackTrace();
		}
		logger.debug("===================");
		logger.info("[Starter Server] Stopping Server");
		server.stop();
	}

}
