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
public class SimpleCounter extends Node{

    public SimpleCounter(String name_, String desc_) {
        super(name_, desc_);
    }

    @Override
    protected void setValue(String path, float val) {
        if (path.replace("\\", "").equals("")){
            this.setValue(val);
        } else {
            throw new UnsupportedOperationException("child node setValue not supported yet for SimpleCounter."); //To change body of generated methods, choose Tools | Templates.
        }
    }

    @Override
    protected float getValue(String path) {
        if (path.replace("\\", "").equals("")){
            return this.getValue();
        } else {
            throw new UnsupportedOperationException("child node getValue Not supported yet for SimpleCounter."); //To change body of generated methods, choose Tools | Templates.
        }
    }

    @Override
    public String toString(boolean getValue) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
