package it.unibo.mvc;

import java.util.List;

/**
 *
 */
public interface Controller {
    void setNextString(String string);

    void getNextString();

    List<String> history();

    void printCurrentString();
}
