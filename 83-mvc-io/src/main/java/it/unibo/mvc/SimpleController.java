package it.unibo.mvc;

import java.util.List;

/**
 * 
 *
 */
public final class SimpleController implements Controller {
    private String nextString;

    @Override
    public void setNextString(String string) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public String getNextString() {
        return this.nextString;
        
    }

    @Override
    public List<String> history() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void printCurrentString() {
        // TODO Auto-generated method stub
        
    }

}
