package load;

import java.lang.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Runner implements Runnable { 
                  
	 	protected int id;
	 
		public Runner(int id)
		{
			this.id = id;
		}
		
        public void run() {              
        	System.out.println("Thread Start id: " + id);  
        	
        	 String query = "select sysdate from dual";
     	    String query2 = "DECLARE  "
     	    		+ "		varr varchar2(100);"
     	    		+ "		begin"
     	    		+ "		  select sysdate into varr from dual;"
     	    		+ "		  dbms_output.put_line(a => 'datesa" + id + " ' || varr); "
     	    		+ "		end;";
     	    		//+ "		/ ";
             System.out.println("sql: " + query2);

     		connection conn = new connection();
     		Connection connection;
			try {
				connection = conn.getConnection();
	     		Statement stmt = connection.createStatement();
	     		Statement stmt2 = connection.prepareCall(query2);
	     		
	             DbmsOutput dbmsOutput = new DbmsOutput( connection );

	             dbmsOutput.enable( 1000000 );

	             stmt.execute
	             ( query2);
	             stmt.close();

	             dbmsOutput.show();
	             
	     		
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

     	   // boolean rs = stmt2.execute(query2);
            // System.out.println("result: " + rs);
             

        	
        	
        }
}