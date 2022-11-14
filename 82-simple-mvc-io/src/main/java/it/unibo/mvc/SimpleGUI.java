package it.unibo.mvc;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.LayoutManager;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 * A very simple program using a graphical interface.
 * 
 */
public final class SimpleGUI {

    private final JFrame frame = new JFrame();

    private SimpleGUI(Controller controller){
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        final JPanel canvas = new JPanel();
        final JButton save = new JButton("save");
        final JTextArea text = new JTextArea();
        final LayoutManager layout = new BorderLayout();
        canvas.setLayout(layout);


        //assembling gui
        canvas.add(text, BorderLayout.CENTER);
        canvas.add(save, BorderLayout.SOUTH);
        frame.setContentPane(canvas);

        //set dimension
        final Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        final int sw = (int) screen.getWidth();
        final int sh = (int) screen.getHeight();

        frame.setSize(sw/2, sh/2);
        frame.setLocationByPlatform(true);

    }

    public void display(){
        frame.setVisible(true);
    }

    public static void main(final String... a) {
        final SimpleGUI gui = new SimpleGUI(new Controller());
        gui.display();
    }

}
