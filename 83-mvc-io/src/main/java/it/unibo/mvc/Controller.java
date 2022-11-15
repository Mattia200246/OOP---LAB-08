package it.unibo.mvc;

import java.util.List;

/**
 *
 */
public interface Controller {
    void setNextString(String string);

    String getNextString();

    List<String> history();

    void printCurrentString();
}
