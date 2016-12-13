package data;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Data {

    private static String url = "jdbc:mysql://localhost:3306/smartvista";
    private static String user = "root";
    private static String password = "";
	
    public static Connection getConnection()
    {
    	Connection con = null;
    	  try {
			Class.forName("com.mysql.jdbc.Driver");
			 try {
	              con = DriverManager.getConnection(url, user, password);
	              return con;
	           } catch (SQLException ex) {
	              Logger lgr = Logger.getLogger(Data.class.getName());
	              lgr.log(Level.SEVERE, ex.getMessage(), ex);
	              return null;
	           }
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
            
    }
    
	public static ArrayList<ByteRows> select(Connection con, String countRows) {
		// TODO Auto-generated method stub
		//Connection con = null;
        Statement st = null;
        ResultSet rs = null;
        String[][] rows = new String[1000][6];
        ArrayList<ByteRows> rows2 = new ArrayList<ByteRows>();
        
        try
        {
	        con = getConnection();
	        st = con.createStatement();
	        if (countRows.equals("all"))
	        {
	        	rs = st.executeQuery("SELECT operation,thread,luno,card_number,card_date,summa,last_id FROM bytes");
	        }
	        else
	        {		
	        	rs = st.executeQuery("SELECT operation,thread,luno,card_number,card_date,summa,last_id FROM bytes LIMIT " + countRows);
	        }

	        int i = 0;

	        while (rs.next()) 
	        {
	        	String operation = rs.getString(1);
	        	String thread = rs.getString(2);
	        	String luno = rs.getString(3);
	        	String card_number = rs.getString(4);
	        	String card_date = rs.getString(5);
	        	String summa = rs.getString(6);
	        	String last_id = rs.getString(7);
	        	ByteRows b = new ByteRows();
	        	b.setOperation(operation);
	        	b.setThread(thread);
	        	b.setLuno(luno);
	        	b.setCard_number(card_number);
	        	b.setCard_date(card_date);
	        	b.setSumma(summa);
	        	b.setLast_id(last_id);
	        	rows2.add(b);
				i += 1;
	            //System.out.println("operation: " + operation + " thread: " + thread + " luno: " + luno + " card_number: " + card_number + " card_date: " + card_date + " summa: " + summa + " last_id: " + last_id);
	        }
	        return rows2;
        } catch (SQLException ex) {
            Logger lgr = Logger.getLogger(Data.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
            return null;

        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (st != null) {
                    st.close();
                }
                if (con != null) {
                    con.close();
                }

            } catch (SQLException ex) {
                Logger lgr = Logger.getLogger(Data.class.getName());
                lgr.log(Level.WARNING, ex.getMessage(), ex);
            }
        }

	}
	

	
    public void bulker (Connection con,
    		String id, 
    		String operation, 
    		String thread, 
			String luno, 
			String card_number,
			String card_date,
			String summa,
			String last_id)
	{
    	//Connection con = null;
        Statement st = null;
        int rs = 0;
        //String[][] rows = new String[1000000000][6];
        
        try
        {
	        //con = getConnection();
	        st = con.createStatement();
	        String query = "INSERT INTO bytes (`id`,`operation`,`thread`,`luno`,`card_number`,`card_date`,`summa`,`last_id`)"
	        		+ " VALUES ("
	        		+ id
	        		+ ",'" 
	        		+ operation
	        		+ "'," 
	        		+ thread
	        		+ ",'"
	        		+ luno
	        		+ "','"
	        		+ card_number
	        		+ "','"
	        		+ card_date
	        		+ "','"
	        		+ summa
	        		+ "',"
	        		+ last_id
	        		+ ");";
            //System.out.println("query: " + query);
	        rs = st.executeUpdate(query);
	        int i = 0;


        } catch (SQLException ex) {
            Logger lgr = Logger.getLogger(Data.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);

        } finally {
            try {
                if (st != null) {
                    st.close();
                }

            } catch (SQLException ex) {
                Logger lgr = Logger.getLogger(Data.class.getName());
                lgr.log(Level.WARNING, ex.getMessage(), ex);
            }
        }
	}
	
}
