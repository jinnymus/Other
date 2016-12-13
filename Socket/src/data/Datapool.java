package data;

import java.sql.Connection;
import java.util.ArrayList;

public class Datapool {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Data data = new Data();
		Connection con = data.getConnection();
		ArrayList<ByteRows> rows = data.select(con,"10");
		
		for (ByteRows byteRows : rows) {
			System.out.println("[Datapool] Operation: " + byteRows.getOperation() +
					" Thread: " + byteRows.getThread() +
					" Luno: " + byteRows.getLuno() +
					" Card_number: " + byteRows.getCard_number() +
					" Card_date: " + byteRows.getCard_date() +
					" Summa: " + byteRows.getSumma() +
					" Last_id: " + byteRows.getLast_id());					
		}
		
	}	

}

