package server;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.LinkedList;
import java.util.List;

import tools.Logger;
import tools.Statistic;

import com.sun.org.apache.xerces.internal.impl.dv.util.HexBin;

import data.ByteRow;

/**

 */
public class WorkerRunnable implements Runnable{

    protected Socket clientSocket = null;
    protected String serverText   = null;
    protected Statistic stat;
    public Logger logger;

    public WorkerRunnable(Socket clientSocket, String serverText, Statistic stat) {
        this.clientSocket = clientSocket;
        this.stat   = stat;
        Logger logger = new Logger();
        logger.setType("stat");
        this.logger = logger;
    }

    public void run() {
        try {

        	this.stat.upperCountThread();
        	
        	for (int i=0;; i++)
	        {
        		
		         
	            InputStream input  = clientSocket.getInputStream();
	            OutputStream output = clientSocket.getOutputStream();
	            //long time = System.currentTimeMillis();
	            //output.write(("HTTP/1.1 200 OK\n\nWorkerRunnable: " + this.serverText + " - " + time + "").getBytes());
	
				String messageString = new String();
		        byte[] messageByte = new byte[1000];
				int bytesRead;
				byte[] tempBuffer;
				boolean end = false;
				List<byte[]> received = new LinkedList<byte[]>();
	            int numberReceived;
	            
				//try 
				//{
					while(!end)
					{
		            	logger.debug("[WorkerRunnable][while] sin.available() = " + input.available());
						logger.debug("[WorkerRunnable][while] end = " + end);
						if (clientSocket.isConnected())
						{
							logger.debug("[WorkerRunnable][while] socket.isConnected() = " + clientSocket.isConnected());
							
	
							bytesRead = input.read(messageByte);
				            this.stat.upperCountRequests();
				            
				            //logger.debug("[WorkerRunnable] Request processed: " + time);
							logger.debug("[WorkerRunnable][while] bytesRead = " + bytesRead);
							if (bytesRead > 0)
							{
								messageString += new String(messageByte, 0, bytesRead);
								logger.debug("[while] messageByte = " + bytes2string(messageByte));
								logger.debug("[while] messageString = " + messageString);
						        if (messageString.length() > 5)
						        {
									logger.debug("[WorkerRunnable][while] messageString.length() = " + messageString.length());
						            end = true;
						        }	
							}
							else
							{
								end = true;
								return;
							}
						}
						else
						{
							logger.debug("[WorkerRunnable][while] socket.isConnected() = " + clientSocket.isConnected());
							logger.debug("[WorkerRunnable][while] exiting");
							return;
						}
	
				    }	
					int index = 0;
		            //String response = "40.007.091F02B0.020.00001000.0355A067313100.;01..1---------------- .(1 . 0355 01.10.14   . 18:09:31 ...... ........:  500,00  .....     676280389963783811 0..RESP_TERM: 990007.RESP_AUTH: 673100 00000.... ...........: 673100....... ..........: 111011927746...... RRN: 427467824379...F89";
					logger.debug("[WorkerRunnable][main] Client sent : " + messageString);
			    	String Luno = messageString.substring(3, 6);
			    	logger.debug("[WorkerRunnable][main] Luno: " + Luno);
			    	index += 8;
			    	String Time = messageString.substring(index, index+8);
			    	logger.debug("[WorkerRunnable][main] Time: " + Time);
			    	index += 13;
			    	String card_number = messageString.substring(index, index+18);
			    	logger.debug("[WorkerRunnable][main] card_number: " + card_number);
			    	ByteRow b = new ByteRow();
			    	String response = b.buildResponse(Luno,Time,card_number);
			    	logger.debug("[WorkerRunnable][main] response = " + response);
					byte[] bytes = response.getBytes();
					//String hexbytes = HexBin.encode( bytes );
					logger.debug("[WorkerRunnable][main] response.getBytes = " + response);
					   
					output.write(bytes); // отсылаем клиенту обратно ту самую строку текста.            
		            output.flush();
		        /*   
				} catch (Exception e) {
					end = true;
					input.close();
					output.close();
					clientSocket.close();
				    e.printStackTrace();
				}
				*/
	        }
          
        } catch (IOException e) {
            //report exception somewhere.
			//clientSocket.close();
			//this.stat.downCountThread();
        	logger.debug("[WorkerRunnable][main] catch e: " + e);
            e.printStackTrace();
        }
        finally{
        	logger.debug("[WorkerRunnable][main] finally");
        	//clientSocket.close();
			this.stat.downCountThread();
        }
    }

	   public static String bytes2string(byte[] _bytes)
	   {
	       String file_string = "";

	       for(int i = 0; i < _bytes.length; i++)
	       {
	           file_string += (char)_bytes[i];
	       }

	       return file_string;    
	   }    
}