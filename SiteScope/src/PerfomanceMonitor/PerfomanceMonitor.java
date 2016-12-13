package PerfomanceMonitor;

import java.util.ArrayList;
import java.util.Iterator;

public class PerfomanceMonitor {
	
	private ArrayList groups;
	
	public PerfomanceMonitor() {
		// TODO Auto-generated constructor stub
		groups = new ArrayList();
	}	
	
	public Group addGroup (String name, String desc)
	{
		Group gr = new Group(name, desc);
        //out.print("<object class=\"group\" name=\"" + name + "\" desc=\"" + desc + "\">");
        //out.print("</object>");
		groups.add(gr);
		return gr;
	}
	//
	public String toString ()
	{
		StringBuilder sb = new StringBuilder();
		sb.append("<?xml version=\"1.0\"?>");
		sb.append("<PerformanceMonitor>");
	   Iterator iter = groups.iterator();
	   for(int i = 0; iter.hasNext(); i++) {
		   sb.append(iter.next().toString());
	   }
		sb.append("</PerformanceMonitor>");
		return sb.toString();
	}

	
}
