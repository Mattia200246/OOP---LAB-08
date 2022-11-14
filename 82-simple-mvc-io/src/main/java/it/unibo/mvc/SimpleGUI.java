package it.unibo.mvc;

import java.awt.BorderLayout;

import javax.swing.*;

/**
 * A very simple program using a graphical interface.
 * 
 */
public final class SimpleGUI {

    private final JFrame frame = new JFrame();

    private SimpleGUI(){
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        final JPanel canvas = new JPanel();
        final JButton save = new JButton("save");
        final JTextArea text = new JTextArea();

        canvas.add(text, BorderLayout.SOUTH);
        canvas.add(save, BorderLayout.CENTER);



    }

}
