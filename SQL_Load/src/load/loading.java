package load;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import oracle.jdbc.driver.DBConversion;

public class loading {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
	    System.out.println("Start");
	    
	    String query = "select sysdate from dual";
	    String query2 = "DECLARE  "
	    		+ "		varr varchar2(100);"
	    		+ "		begin"
	    		+ "		  select sysdate into varr from dual;"
	    		+ "		  dbms_output.put_line(a => 'datesa ' || varr); "
	    		+ "		end;";
	    		//+ "		/ ";
        System.out.println("sql: " + query2);

		connection conn = new connection();
		Connection connection = conn.getConnection();
		Statement stmt = connection.createStatement();
		Statement stmt2 = connection.prepareCall(query2);
	   // boolean rs = stmt2.execute(query2);
       // System.out.println("result: " + rs);
        
        DbmsOutput dbmsOutput = new DbmsOutput( connection );

        dbmsOutput.enable( 1000000 );

        stmt.execute
        ( query2);
        stmt.close();

        dbmsOutput.show();
        
        
/*
        while (rs.next()) {
            String res = rs.getString(1);

            System.out.println("result: " + res);
        }
        */
	}

	
}
