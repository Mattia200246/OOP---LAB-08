package it.unibo.mvc;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

/**
 * Application controller. Performs the I/O.
 */
public class Controller {
    
    private final static String HOME = System.getProperty("user.home");
    private final static String DEFAULT_FILE = "output.txt";

    private File file = new File (HOME+ File.separator+ "Desktop" + File.separator + DEFAULT_FILE);

    public void setFile(final File newfile){
        final File parent = newfile.getParentFile();
        if(parent.exists()){
            file = newfile;
        }else{
            throw new IllegalArgumentException("Non existing folder");
        }
    }

    public File getCurrentFile(){
        return file;
    }   

    public String getCurrentPath(){
        return file.getPath();
    }

    public void save (final String string) throws IOException{
        try (PrintStream ps = new PrintStream(file, StandardCharsets.UTF_8)){
            ps.print(string);
        }
    }

}
