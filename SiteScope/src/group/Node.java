/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package group;

import java.util.concurrent.ConcurrentHashMap;

/**
 *
 * @author out-zaikin-sn
 */
public abstract class Node {
    
    private String name;
    private String desc;
    private float value=0;
    //private Type type;
    
    protected ConcurrentHashMap<String, Node> arr = new ConcurrentHashMap<>();
    
    public Node(String name_, String desc_){
        name = name_;
        desc = desc_;
    }
    
    protected String getName(){
        return name;
    }
    
    protected String getDesc(){
        return desc;
    }
    
    protected abstract void setValue(String path, float val);
    protected void setValue(float val){
        value = val;
    }
    
    protected abstract float getValue(String path);
    protected float getValue(){
        return value;
    }
    public abstract String toString(boolean getValue);
    
    protected Node getChildNode(String path) throws Exception{
        if (path.contains("\\")) {
            int pos = path.indexOf("\\");
            String path_root = path.substring(1, pos-1);
            String path_node = path.substring(pos+1);
            Node node = arr.get(path_root);
            if (node==null){
                throw new Exception("Node does not exists");
            }
            return node.getChildNode(path_node);
        }
        return this;
    }
   
}
