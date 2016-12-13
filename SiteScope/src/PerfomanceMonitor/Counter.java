package PerfomanceMonitor;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;

public class Counter {
	
    private String url;
    private String regexp;
    private String value;
    private String counterName;
    private String counterDesc;
    private final String USER_AGENT = "Mozilla/5.0";
    
	public Counter(String name_, String desc_) {
		// TODO Auto-generated constructor stub
		counterName = name_;
		counterDesc = desc_;
	}
	public String toString ()
	{
		StringBuilder sb = new StringBuilder();
		try {
			String res = sendGet(url);
			//System.out.println("res: " + res);
			sb.append("<counter quality=\"1\" val=\""+ res + "\" name=\"" + counterName + "\"  desc=\"" + counterDesc + "\"/>");

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sb.toString();
	}

	public String sendGet(String url_) throws Exception {
		 
		//String url = "http://www.google.com/search?q=mkyong";
 
		URL obj = new URL(url_);
		//System.out.println("url_: " + url_);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
 
		// optional default is GET
		con.setRequestMethod("GET");
		//add request header
		//con.setRequestProperty("User-Agent", USER_AGENT);
 
		int responseCode = con.getResponseCode();
		//System.out.println("\nSending 'GET' request to URL : " + url);
		//System.out.println("Response Code : " + responseCode);
 
		BufferedReader in = new BufferedReader(
		        new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();
 
		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();
 
		//print result
		return response.toString();
 
	}
	
	public void set(String url_, String regexp_) {
		// TODO Auto-generated method stub
		url = url_;
        regexp = regexp_;
	}
}
