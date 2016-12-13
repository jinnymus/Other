package PerfomanceMonitor;

import java.util.ArrayList;
import java.util.Iterator;

public class Monitor {

    private String name;
    private String desc;
    private String type;
    private String monitorName;
    private String monitorDesc;
    private String monitorType;
    private ArrayList counters;
    
	public Monitor(String name_, String desc_, String type_) {
		// TODO Auto-generated constructor stub
		monitorName = name_;
		monitorDesc = desc_;
		monitorType = type_;
        counters = new ArrayList();
	}

	public Counter addCounter(String name_, String desc_) {
		// TODO Auto-generated method stub
		Counter cn = new Counter(name_, desc_);
        //out.print("<object class=\"group\" name=\"" + name + "\" desc=\"" + desc + "\">");
        //out.print("</object>");
		counters.add(cn);
		return cn;
	}

	public String toString ()
	{
		StringBuilder sb = new StringBuilder();
		sb.append("<object class=\"monitor\" name=\"" + monitorName + "\" desc=\"" + monitorDesc + "\" type=\"" + monitorType + "\">");
	   Iterator iter = counters.iterator();
	   for(int i = 0; iter.hasNext(); i++) {
		   sb.append(iter.next().toString());
	   }
		sb.append("</object>");
		return sb.toString();
	}
	
}
