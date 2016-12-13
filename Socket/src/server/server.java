package server;

import java.net.*;
import java.nio.ByteBuffer;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.*;

import com.sun.org.apache.xerces.internal.impl.dv.util.HexBin;

public class server {

	
	   private static Logger log = Logger.getLogger(server.class.getName());
	
	   public static void main(String[] ar)    {
		     int port = 6666; // случайный порт (может быть любое число от 1025 до 65535)
		        boolean end = false;
		        boolean ended = false;
		        String dataString = "";
		        log.setLevel(Level.INFO);
		        
		       try {
				         ServerSocket ss = new ServerSocket(port); // создаем сокет сервера и привязываем его к вышеуказанному порту
				         System.out.println("[main] Waiting for a client...");
				         
				         ss.setSoTimeout(200000);
				         Socket socket = ss.accept(); // заставляем сервер ждать подключений и выводим сообщение когда кто-то связался с сервером
				         System.out.println("[main] Got a client");
				         System.out.println();
				         int localport = socket.getLocalPort();
				        		 
				        		
				 // Берем входной и выходной потоки сокета, теперь можем получать и отсылать данные клиенту. 
				         //InputStream sin = socket.getInputStream();
				         
		
				 // Конвертируем потоки в другой тип, чтоб легче обрабатывать текстовые сообщения.
				         //DataInputStream in = new DataInputStream(sin);
				         //DataOutputStream out = new DataOutputStream(sout);
		
				         String line = null;
				         System.out.println("[main] Start listen");
				         //while(ended = true) {
				         for (int i=0;; i++)
				         {
				        	 		InputStream sin = socket.getInputStream();
				        	 		OutputStream sout = socket.getOutputStream();
									String messageString = new String();
							        byte[] messageByte = new byte[1000];
									int bytesRead;
									byte[] tempBuffer;
									List<byte[]> received = new LinkedList<byte[]>();
					                int numberReceived;
					                
									while(!end)
									{
					                
					                	System.out.println("[while] sin.available() = " + sin.available());
										System.out.println("[while] end = " + end);
										if (socket.isConnected())
										{
											System.out.println("[while] socket.isConnected() = " + socket.isConnected());
											bytesRead = sin.read(messageByte);											
											
										}
										else
										{
											System.out.println("[while] socket.isConnected() = " + socket.isConnected());
											System.out.println("[while] exiting");
											return;
										}
										System.out.println("[while] bytesRead = " + bytesRead);
										messageString += new String(messageByte, 0, bytesRead);
										System.out.println("[while] messageByte = " + bytes2string(messageByte));
										System.out.println("[while] messageString = " + messageString);
								        if (messageString.length() > 5)
								        {
											System.out.println("[while] messageString.length() = " + messageString.length());
								            end = true;
								        }
								    }	
								
								   String response = "40.007.091F02B0.020.00001000.0355A067313100.;01..1---------------- .(1 . 0355 01.10.14   . 18:09:31 ...... ........:  500,00  .....     676280389963783811 0..RESP_TERM: 990007.RESP_AUTH: 673100 00000.... ...........: 673100....... ..........: 111011927746...... RRN: 427467824379...F89";
								   System.out.println("[main] Client sent : " + messageString);
								   System.out.println("[main] response = " + response);
								   
								   byte[] bytes = response.getBytes();
								   String hexbytes = HexBin.encode( bytes );
								   System.out.println("[main] response.getBytes = " + response);
								   
								   sout.write(bytes); // отсылаем клиенту обратно ту самую строку текста.
								   sout.flush(); // заставляем поток закончить передачу данных.
								   System.out.println("[main] Waiting for the next line...");
								   System.out.println("[main] =====================================");
								   end = false;
			         		}
				      } catch(Exception x) { x.printStackTrace(); 
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
