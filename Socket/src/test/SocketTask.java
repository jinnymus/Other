package test;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class SocketTask implements Runnable {
    private int port;
    private String host;
    private static final ThreadLocal<Socket> threadLocal = 
           new ThreadLocal<Socket>(){
    	private int port;
		private String host;

		@Override
        protected Socket initialValue(){
            try {
            	InetAddress ipAddress = InetAddress.getByName(this.host);
            	System.out.println("[initialValue] this.host = " + this.host);
            	System.out.println("[initialValue] this.port = " + this.port);
            	System.out.println("[initialValue] ipAddress = " + ipAddress);
				return new Socket(ipAddress,this.port);
			} catch (UnknownHostException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
        }           
    };

    public SocketTask(String st_host, int st_port){              
        this.host = st_host;
        this.port = st_port;
    }

    public void run(){      
        Socket socket = getSocket(); //gets from threadlocal
        //send data on socket based on workDetails, etc.
        
        byte[] messageByte = new byte[1000];
        boolean end = false;
        String dataString = "";
        
        System.out.println("Yes! I just got hold of the program.");

        // Ѕерем входной и выходной потоки сокета, теперь можем получать и отсылать данные клиентом. 
        InputStream sin;
        OutputStream sout;
		try {
			sin = socket.getInputStream();
			sout = socket.getOutputStream();
		
	        //  онвертируем потоки в другой тип, чтоб легче обрабатывать текстовые сообщени€.
	        DataInputStream in = new DataInputStream(sin);
	        DataOutputStream out = new DataOutputStream(sout);
	
	        // —оздаем поток дл€ чтени€ с клавиатуры.
	        BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
	        String line = null;
	        System.out.println("Type in something and press enter. Will send it to the server and tell ya what it thinks.");
	        System.out.println();
	
	        for (int i=0;i<=2;i++)
	        {
	        	String some = keyboard.readLine();  // ожидаем пока клиент пришлет строку текста.
	        	
	            line = ("test_" + i).toString(); // ждем пока пользователь введет что-то и нажмет кнопку Enter.
	            System.out.println("Sending this line to the server...");
	            sout.write(line.getBytes());
	            sout.flush(); // заставл€ем поток закончить передачу данных.
	            System.out.println("Sending this line to the server...");
	            System.out.println("Sending string = " + line);
	        	String messageString = new String();
	            while(!end)
	            {
	                int bytesRead = sin.read(messageByte);
	                System.out.println("Create messageString");
	                messageString += new String(messageByte, 0, bytesRead);
	                System.out.println("MESSAGE: messageString " + messageString);
	                if (messageString.length() > 5)
	                {
	                    end = true;
	                }
	            }
	            System.out.println("MESSAGE: " + messageString);                
	            
	            System.out.println("The server was very polite. It sent me this : " + line);
	            System.out.println("Looks like the server is pleased with us. Go ahead and enter more lines.");
	            System.out.println();
	        }
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}    
        
    }

    public static Socket getSocket(){
        return threadLocal.get();
    }
}
