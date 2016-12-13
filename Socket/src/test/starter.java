package test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class starter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ExecutorService threadPool = 
			    Executors.newFixedThreadPool(5, Executors.defaultThreadFactory());

			    int tasks = 2;  
			    for( int i = 1; i <= tasks; i++){
			        threadPool.execute(new SocketTask("127.0.0.1",6666));
			    }   
	}

}
