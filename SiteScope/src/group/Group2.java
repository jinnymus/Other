/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package group;

/**
 *
 * @author LT_tester11
 */
public class Group2 extends Node{
    public enum Type {GROUP, MONITOR};
    
    Type type;

    @Override
    protected float getValue(String path) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Group2(String name_, String desc_, Type type_) {
        super(name_, desc_);
        type = type_;
    }

    @Override
    protected void setValue(String path, float val) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String toString(boolean getValue) {
        StringBuilder str = new StringBuilder();
        str.append("<object class=\"");
        if (type==Type.GROUP) {
            str.append("group");
        } else {
            str.append("monitor");
        }
        str.append("\" name=\"").append(this.getName()).append("\" desc=\"").append(this.getDesc()).append("\">");
        
        for(String key : arr.keySet()){
            Node node = arr.get(key);
            str.append(node.toString(getValue));
        }

        str.append("</object>");
        return str.toString();
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
