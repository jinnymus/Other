package up;

import PerfomanceMonitor.Counter;
import PerfomanceMonitor.Group;
import PerfomanceMonitor.Monitor;
import PerfomanceMonitor.PerfomanceMonitor;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
        PerfomanceMonitor p = new PerfomanceMonitor();
        Group gr = p.addGroup("SmartVista", "For SmartVista Testing");
        Monitor mon = gr.addMonitor("SmartVista", "For SmartVista Testing","PDHMonitor");
        Counter cn = mon.addCounter("SmartVista Counters", "SmartVista Metrics");
        cn.set("localhost:8080/CountRequests","(.*)");
        System.out.print("xml = " + p.toString());
        */
        Counter cn = new Counter("CountRequests", "Count Request");

        cn.set("http://127.0.0.1:8085/CountRequests","(.*)");
        System.out.println(cn.toString());

        
		
	}

}
