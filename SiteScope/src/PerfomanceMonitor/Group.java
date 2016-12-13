package PerfomanceMonitor;

import java.util.ArrayList;
import java.util.Iterator;

public class Group {
	
    private String groupName;
    private String groupDesc;
    private ArrayList monitors;
    
    public Group(String name_, String desc_){
    	groupName = name_;
    	groupDesc = desc_;
        monitors = new ArrayList();
    }
    
	public Monitor addMonitor(String name_, String desc_, String type_) {
		// TODO Auto-generated method stub
		Monitor mon = new Monitor(name_, desc_, type_);
        //out.print("<object class=\"group\" name=\"" + name + "\" desc=\"" + desc + "\">");
        //out.print("</object>");
		monitors.add(mon);
		return mon;
	}

	public String toString ()
	{
		StringBuilder sb = new StringBuilder();
		sb.append("<object class=\"group\" name=\"" + groupName + "\" desc=\"" + groupDesc + "\">");
	   Iterator iter = monitors.iterator();
	   for(int i = 0; iter.hasNext(); i++) {
		   sb.append(iter.next().toString());
	   }
		sb.append("</object>");
		return sb.toString();
	}
	
}
