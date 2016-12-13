package load;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class connection {

	public Object password;
	public Object userName;
	public String dbms;
	public String portNumber;
	public String serverName;
	public String URL;
	public String dbName = new String();
	
	public connection()
	{
		this.userName = "system";
		this.password = "123";
		this.serverName = "localhost";
		this.portNumber = "1521";
		this.dbName = "main";
		this.dbms = "oracle";
		this.URL = "jdbc:oracle:thin:@amrood:1521:EMP";

	}

	
	public Connection getConnection() throws SQLException {

	    Connection conn = null;
	    Properties connectionProps = new Properties();
	    connectionProps.put("user", this.userName);
	    connectionProps.put("password", this.password);

	    conn = DriverManager.getConnection(
	                   "jdbc:" + this.dbms + ":thin:@" +
	                   this.serverName +
	                   ":" + this.portNumber + ":ORCL",
	                   connectionProps);
	    System.out.println("Connected to database");
	    return conn;
	}
}
