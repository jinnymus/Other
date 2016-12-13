package client;
import java.net.*;
import java.util.ArrayList;
import java.io.*;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.sun.org.apache.xerces.internal.impl.dv.util.HexBin;

import data.ByteRow;
import data.ByteRows;
import data.Data;
import tools.Logger;
import tools.Statistic;

public class Client implements Runnable {

    protected String server = null;
    protected int port   = 0;
    protected Statistic stat;
    public Logger logger;
    
    public Client(String server, int port, Statistic stat) {
        this.server = server;
        this.port = port;
        this.stat   = stat;
        Logger logger = new Logger();
        logger.setType("stat");
        this.logger = logger;
    }
    
    public void run() {
    	
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
        	stat.upperCountThread();
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
    		//Connection con = data.getConnection();
    		//ArrayList<ByteRows> rows = data.select(con,"1");
    		int i=0;
            for (i=0;i<1;i++)
            {
            	//String some = keyboard.readLine();  // ожидаем пока клиент пришлет строку текста.
                //logger.info("[Client] i: " + i);

        		//for (ByteRows byteRows : rows) 
        		//{
        			end = false;
                	ByteRow b = new ByteRow();
        			byte[] sendBytes = b.buildWAYRequest();        			
	                sout.write(sendBytes);
	                stat.upperCountRequests();
	                sout.flush(); // заставл€ем поток закончить передачу данных.
	                logger.debug("[Client] Sending string: " + new String(sendBytes));
	                logger.debug("[Client] Sending hex: " + HexBin.encode(sendBytes));
	            	String messageString = new String();
	                while(!end)
	                {
	                    int bytesRead = sin.read(messageByte);
	                    messageString += new String(messageByte);
	                    if (messageString.length() > 5)
	                    {
	                        end = true;
	                    }
	                }
	                //verifyResponse(sendBytes,messageString);
	                logger.debug("[Client] server return string: " + messageString);
	                logger.debug("[Client] server return hex: " + HexBin.encode(messageString.getBytes()));
	                //Thread.sleep(1);
        		//}
            }
            logger.info("[Client] i: " + i);
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
            stat.downCountThread();
        } catch (Exception x) {
        	
            x.printStackTrace();
        }
    }
    
	 
    
    public static void verifyResponse(String req, String res)
    {
    	int index = 0;
	    Logger logger = new Logger();
	    logger.setType("stat");
	    logger.debug("[Client][verifyResponse] res: " + res);
	    
    	String MessageClass = res.substring(0, 1);
    	String MessageSubClass = res.substring(1, 2);
    	index += 2;
    	String Luno = res.substring(3, res.indexOf(".",3));
    	index += Luno.length();
    	index += 2;
    	String Time = res.substring(index, index+8);
    	index += 9;
    	String ReceptFlag = res.substring(index, index+1);
    	index += 1;
    	String MessageCoNumber = res.substring(index, index+1);
    	
    	logger.debug("[Client][verifyResponse] MessageClass: " + MessageClass);
    	logger.debug("[Client][verifyResponse] MessageSubClass: " + MessageSubClass);
    	logger.debug("[Client][verifyResponse] Luno: " + Luno);
    	logger.debug("[Client][verifyResponse] Time: " + Time);
    	logger.debug("[Client][verifyResponse] ReceptFlag: " + ReceptFlag);
    	logger.debug("[Client][verifyResponse] MessageCoNumber: " + MessageCoNumber);    	
    	
    	index=0;
    	logger.debug("[Client][verifyResponse] request: " + req); 
       	String MessageClassResp = req.substring(0, 1);
    	logger.debug("[Client][verifyResponse] MessageClassResp: " + MessageClassResp);
    	String LunoResp = req.substring(3, 6);
    	logger.debug("[Client][verifyResponse] LunoResp: " + LunoResp);
    	index += 8;
    	String TimeResp = req.substring(index, index+8);
    	logger.debug("[Client][verifyResponse] TimeResp: " + TimeResp);
    	index += 13;
    	String card_numberResp = req.substring(index, index+18);
    	
    	if (MessageClass.equals("4"))
    	{
    		logger.debug("[Client][verifyResponse] MessageClass verify success");
    	}    
    	else
    	{
    		logger.error("[Client][verifyResponse] MessageClass verify error");
    	}
    	if (TimeResp.equals(Time))
    	{
    		logger.debug("[Client][verifyResponse] TimeResp verify success");
    	}
    	else
    	{
    		logger.error("[Client][verifyResponse] TimeResp verify error");
    	}
    	if (LunoResp.equals(Luno))
    	{
    		logger.debug("[Client][verifyResponse] LunoResp verify success");
    	}
    	else
    	{
    		logger.error("[Client][verifyResponse] LunoResp verify error");
    	}

    }

}
