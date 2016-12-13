package data;

import javax.xml.bind.DatatypeConverter;

import com.sun.org.apache.xerces.internal.impl.dv.util.HexBin;

public class ByteRow {


	public byte[] buildWAYRequest()
    {
		StringBuilder sb = new StringBuilder();
		//String cardnum = "343330333631373836313538393930303634";
		//String cardnum = "34323732323930363435383239383035"; //visa
		
		
		String cardnum = "34323732323930323135373437363530"; //visa
		String cardnum_str = "4272290215747650";
		String cvv = "0000009"; //009
		String date = "31363039";// 009
		//String date = "31353034";// 009
		
		/*
		String req = "0200722406802080800316";
		sb.append(req);
		sb.append(cardnum_str);
		//sb.append("00000000000000010003061534400000031504005100010037");
		sb.append("000000000000000100030615344");
		sb.append("0000003");
		sb.append("1609"); //1609
		sb.append("005100010037");
		sb.append(cardnum);
		sb.append("3d");
		sb.append(date);
		sb.append("32303131383135303030303030343135323231393530353406430017303039535630343032303035504332303033a72f74");
		*/
		
		//sb.append("0210723800000a80800316427229064582980500000000000000010003061534400000031653540312353037313133333130323131393632323139353035340643000930303636365649534108bb18c7");
		//sb.append("0200722406802080800316427229064582980500000000000000010003061534400000031504005100010037343237323239303634353832393830353d3135303432303131383135303030303030343135323231393530353406430017303036535630343032303035504332303033a72f74");
		//String cardnum = "35353433383630303131373834333630"; //mc
		
		
		//30313030723C4681A8E09A001654693800113983683000000000000000001030145337786158175337103015126011005100015906111199061111993705469380011398368D1512201060060000052020203939393939393939393939392020204F5342203739383220303031312020202020202020202020204D4F53434F57202020202020205255064374B2FEFD645FF38A980101000000000001205F2A020643820238008407A0000000041010950580000400009A031410309C01309F02060000000000009F090200029F10120210A00003220000000000000000000000FF9F1A0206439F2608A6D6745F34B5DEE69F2701809F33036040209F34034201009F3501149F3602005C9F37047C2F8C449F53015A
		
		
		sb.append("30313030723C4681A8E09A001654693800113983683000000000000000001030145337786158175337103015126011005100015906111199061111993705469380011398368D15122010600600000520");
		sb.append(cardnum);
		sb.append("20203939393939393939393939392020204F534220");
		sb.append("31333831");
		sb.append("20303031312020202020202020202020204D4F53434F57202020202020205255064374B2FEFD645FF38A980101000000000001205F2A020643820238008407A0000000041010950580000400009A031410309C01309F02060000000000009F090200029F10120210A00003220000000000000000000000FF9F1A0206439F2608A6D6745F34B5DEE69F2701809F33036040209F34034201009F3501149F3602005C9F37047C2F8C449F53015A");
		
		
		//sb.append(req);
		int lenght = sb.length()/2;
		//System.out.println("[ByteRow][buildRequest] sb length: " + lenght);
		if (lenght % 2 == 0)
		{
			sb.insert(0, "00" + Integer.toHexString(lenght));		
		}
		else
		{
			sb.insert(0, "0" + Integer.toHexString(lenght));
		}
		//sb.insert(0, "0" + Integer.toHexString(lenght));
		//sb.insert(0, "00" + Integer.toHexString(lenght));
		//System.out.println("[ByteRow][buildRequest] sb length: " + Integer.toHexString(lenght));
		//System.out.println("[ByteRow][buildRequest] sb: " + sb.toString());
		//System.out.println("[ByteRow][buildRequest] convertHexToString sb: " + convertHexToString(sb.toString()));
		byte[] b = toByteArray(sb.toString());
		//byte[] b = toByteArray(req);
 		return b;
    }
	
	public byte[] buildRequest( String operation,
    String thread,
    String luno,
    String card_number,
    String card_date,
    String summa,
    String last_id)
    {
		StringBuilder sb = new StringBuilder();
		sb.append("31311C");
		sb.append(HexBin.encode(luno.getBytes()));
		sb.append("1C1C30393146303242301C313B1C3B");
		sb.append(HexBin.encode(card_number.getBytes()));
		sb.append("3D");
		sb.append(HexBin.encode(card_date.getBytes()));
		sb.append("313031303034323530323134333F1C1C41492020412043421C");
		sb.append(HexBin.encode(summa.getBytes()));
		sb.append("1C33373F3A313032343B3D3F3C3A3234331C1C1C1C32");
		sb.append(HexBin.encode(last_id.getBytes()));
		sb.append("3030303030303030303030303030303030303030301C4544323433373838");
		int lenght = sb.length()/2;
		sb.insert(0, "00" + Integer.toHexString(lenght));
		//System.out.println("[ByteRow][buildRequest] sb length: " + Integer.toHexString(lenght));
		//System.out.println("[ByteRow][buildRequest] sb: " + sb.toString());
		//System.out.println("[ByteRow][buildRequest] convertHexToString sb: " + convertHexToString(sb.toString()));
		byte[] b = toByteArray(sb.toString());
 		return b;
    }
	
	public static byte[] toByteArray(String s) {
	    return DatatypeConverter.parseHexBinary(s);
	}
	
	  private static String convertStringToHex(String str){
		  
		  char[] chars = str.toCharArray();
	 
		  StringBuffer hex = new StringBuffer();
		  for(int i = 0; i < chars.length; i++){
		    hex.append(Integer.toHexString((int)chars[i]));
		  }
	 
		  return hex.toString();
	  }
	  
	  private static String convertHexToString(String hex){
		  
		  StringBuilder sb = new StringBuilder();
		  StringBuilder temp = new StringBuilder();
	 
		  //49204c6f7665204a617661 split into two characters 49, 20, 4c...
		  for( int i=0; i<hex.length()-1; i+=2 ){
	 
		      //grab the hex in pairs
		      String output = hex.substring(i, (i + 2));
		      //convert hex to decimal
		      int decimal = Integer.parseInt(output, 16);
		      //convert the decimal to character
		      sb.append((char)decimal);
	 
		      temp.append(decimal);
		  }
		  //System.out.println("Decimal : " + temp.toString());
	 
		  return sb.toString();
	  }
	public String buildResponse(
		    String luno,
		    String time	,
		    String card_number)
		    {
				StringBuilder sb = new StringBuilder();
				sb.append("40.");
				sb.append(luno);
				sb.append(".");
				sb.append(time);
				sb.append(".020.00001000.0355A067313100.;01..1---------------- .(1 . 0355 01.10.14   . 18:09:31 ...... ........:  500,00  .....     ");
				sb.append(card_number);
				sb.append(" 0..RESP_TERM: 990007.RESP_AUTH: 673100 00000.... ...........: 673100....... ..........: 111011927746...... RRN: 427467824379...F89");
				return sb.toString();
		    }
	
}
