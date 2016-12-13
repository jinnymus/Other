package test;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.sql.Connection;
import java.util.ArrayList;

import data.ByteRow;
import data.ByteRows;
import data.Data;
import tools.Logger;

public class Client_LoadRunner {

	protected String server = null;
    protected int port   = 0;
    public Logger logger;
	    
    public Client_LoadRunner(String server, int port) {
        this.server = server;
        this.port = port;
        Logger logger = new Logger();
        logger.setType("debug");
        this.logger = logger;
    }
    
    public void start() {
    	
        //int serverPort = 6666; // здесь об€зательно нужно указать порт к которому прив€зываетс€ сервер.
        //String address = "127.0.0.1"; // это IP-адрес компьютера, где исполн€етс€ наша серверна€ программа. 
                                      // «десь указан адрес того самого компьютера где будет исполн€тьс€ и клиент.
        byte[] messageByte = new byte[1000];
        boolean end = false;
        String dataString = "";
        //Statistic stat = new Statistic();  
	    Logger logger = new Logger();
	    logger.setType("debug");

        try {
        	//stat.upperCountThread();
            InetAddress ipAddress = InetAddress.getByName(this.server); // создаем объект который отображает вышеописанный IP-адрес.
            logger.debug("[Client] create socket " + this.server + ":" + this.port);
            Socket socket = new Socket(ipAddress, this.port); // создаем сокет использу€ IP-адрес и порт сервера.
            int localport = socket.getLocalPort();
            
            // Ѕерем входной и выходной потоки сокета, теперь можем получать и отсылать данные клиентом. 
            InputStream sin = socket.getInputStream();
            OutputStream sout = socket.getOutputStream();

            //  онвертируем потоки в другой тип, чтоб легче обрабатывать текстовые сообщени€.
            DataInputStream in = new DataInputStream(sin);
            DataOutputStream out = new DataOutputStream(sout);

            // —оздаем поток дл€ чтени€ с клавиатуры.
            //BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
            //String line = null;

    		Data data = new Data();
    		Connection con = data.getConnection();
    		ArrayList<ByteRows> rows = data.select(con,"100000");

            for (int i=0;i<=1000000000;i++)
            {
            	//String some = keyboard.readLine();  // ожидаем пока клиент пришлет строку текста.
        		for (ByteRows byteRows : rows) 
        		{
        			end = false;
                	ByteRow b = new ByteRow();
        			byte[] sendBytes = b.buildRequest(byteRows.getOperation(), byteRows.getThread(), byteRows.getLuno(), byteRows.getCard_number(), byteRows.getCard_date(), byteRows.getSumma(), byteRows.getLast_id());
	                sout.write(sendBytes);
	                //stat.upperCountRequests();
	                sout.flush(); // заставл€ем поток закончить передачу данных.
	                logger.debug("[Client] Sending string: " + new String(sendBytes));
	                logger.debug("[Client] Sending hex: " + new String(sendBytes));
	            	String messageString = new String();
	                while(!end)
	                {
	                    int bytesRead = sin.read(messageByte);
	                    messageString += new String(messageByte, 0, bytesRead);
	                    if (messageString.length() > 5)
	                    {
	                        end = true;
	                    }
	                }
	                //verifyResponse(sendBytes,messageString);
	                logger.debug("[Client] server return: " + messageString);
        		}
            }
            logger.debug("[Client] in.close()");
            //in.close();
            logger.debug("[Client] out.close()");
            //out.close();
            logger.debug("[Client] sin.close()");
            sin.close();
            logger.debug("[Client] sout.close()");
            sout.close();
            logger.debug("[Client] socket.close()");
            socket.close();
            //stat.downCountThread();
        } catch (Exception x) {
        	
            x.printStackTrace();
        }
    }	
	
}
