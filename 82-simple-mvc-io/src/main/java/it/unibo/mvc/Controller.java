package it.unibo.mvc;

import java.io.File;

/**
 * Application controller. Performs the I/O.
 */
public class Controller {
    
    private final static String HOME = System.getProperty("user.home");

    private File file = new File (HOME+File.separator+"output.txt");

    public File getCurrentFile(){
        return file;
    }   




}
