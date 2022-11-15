package it.unibo.mvc;

import javax.swing.*;
import java.awt.*;


/**
 * A very simple program using a graphical interface.
 * 
 */
public final class SimpleGUIWithFileChooser {

    private final JFrame frame = new JFrame();
    
    public SimpleGUIWithFileChooser(Controller controller){
        JPanel canvas = new JPanel();
        JPanel canvas2 = new JPanel();
        canvas.setLayout(new BorderLayout());
        canvas2.setLayout(new BorderLayout());
        JTextArea text = new JTextArea();
        JButton browse = new JButton("Browse...");
        
        //canvas.add(canvas1, BorderLayout.NORTH);
        canvas2.add(canvas, BorderLayout.NORTH);
        canvas2.add(text, BorderLayout.CENTER);
        canvas2.add(browse, BorderLayout.LINE_END);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(canvas);
        frame.setContentPane(canvas2);
        
    }

    void display(){
        frame.setVisible(true);
    }

    public static void main(final String... a) {
        final SimpleGUIWithFileChooser gui = new SimpleGUIWithFileChooser(new Controller());
        gui.display();
    }

}
