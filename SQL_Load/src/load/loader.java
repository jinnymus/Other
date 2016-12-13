package load;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import oracle.jdbc.driver.DBConversion;

public class loader {

	public Object password;
	public Object userName;
	public String dbms;
	public String portNumber;
	public String serverName;
	public String dbName = new String();

	
	public  void main(String[] args) {
		// TODO Auto-generated method stub
		
	    System.out.println("Start");

		/*
		try {
			this.userName = "system";
			this.password = "123";
			this.serverName = "localhost";
			this.portNumber = "1521";
			this.dbName = "main";
			this.dbms = "oracle";
			Connection c = getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
	}
/*
	public void loader()
	{
		this.userName = "system";
		this.password = "123";
		this.serverName = "localhost";
		this.portNumber = "1521";
		this.dbName = "main";
		this.dbms = "oracle";
	}
*/
	public Connection getConnection() throws SQLException {

	    Connection conn = null;
	    Properties connectionProps = new Properties();
	    connectionProps.put("user", this.userName);
	    connectionProps.put("password", this.password);

	    if (this.dbms.equals("oracle")) {
	        conn = DriverManager.getConnection(
	                   "jdbc:" + this.dbms + "://" +
	                   this.serverName +
	                   ":" + this.portNumber + "/",
	                   connectionProps);
		    System.out.println("if to database");

	    } else if (this.dbms.equals("derby")) {
	        conn = DriverManager.getConnection(
	                   "jdbc:" + this.dbms + ":" +
	                   this.dbName +
	                   ";create=true",
	                   connectionProps);
		    System.out.println("else to database");

	    }
	    System.out.println("Connected to database");
	    return conn;
	}
	
}
