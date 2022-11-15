package it.unibo.mvc;

import java.util.LinkedList;
import java.util.List;

/**
 * 
 *
 */
public final class SimpleController implements Controller {
    private String nextString;
    private final List<String> history = new LinkedList<>();

    @Override
    public void setNextString(String string) {
        this.nextString = string;
    }

    @Override
    public String getNextString() {
        return this.nextString;
    }

    @Override
    public List<String> history() {
        return this.history;
    }

    @Override
    public void printCurrentString() {
        // TODO Auto-generated method stub

    }

}
