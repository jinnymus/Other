package test;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Connection;

import data.Data;

public class TestData {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Data data = new Data();
		Connection con = data.getConnection();
		long card_number = 676280389963783811l;
		//BigInteger card_number = BigInteger.probablePrime(676280389963783811,1);
		for (int i = 1; i < 100000000; i++) {
			//System.out.println("card_number 1 = " + card_number);
			card_number = card_number + 1;
			
			//System.out.println("card_number = " + Long.toString(card_number));
			data.bulker(con,Integer.toString(i),"cash", "1", "007", Long.toString(card_number), "1601", "000000000500", Integer.toString(i-1));
			
		}
	}

}
