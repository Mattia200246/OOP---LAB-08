package it.unibo.mvc;

import javax.swing.*;
import java.awt.*;

/**
 * A very simple program using a graphical interface.
 * 
 */
public final class SimpleGUI {

    private final JFrame frame = new JFrame();

    public SimpleGUI(){
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel canvas = new JPanel();
        JPanel canvasSouth = new JPanel();
        canvas.setLayout(new BorderLayout());
        canvasSouth.setLayout(new BoxLayout(canvasSouth, BoxLayout.LINE_AXIS));

        JTextArea textArea = new JTextArea();
        JTextField textField = new JTextField();
        JButton print = new JButton("Print");
        JButton viewHistory = new JButton("View History");

        frame.setContentPane(canvas);
        canvas.add(textField, BorderLayout.NORTH);
        canvas.add(textArea, BorderLayout.CENTER);
        canvas.add(canvasSouth, BorderLayout.SOUTH);
        canvasSouth.add(print);
        canvasSouth.add(viewHistory);

        
    }

    void display(){
        frame.setVisible(true);
    }

    public static void main(final String... a){
        SimpleGUI gui = new SimpleGUI();
        gui.display();
    }

}
