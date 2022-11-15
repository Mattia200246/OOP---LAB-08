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
        final JPanel canvas = new JPanel();
        final JPanel canvas_up = new JPanel();

        canvas.setLayout(new BorderLayout());
        canvas_up.setLayout(new BorderLayout());

        JTextField text = new JTextField();
        text.setEditable(false);

        final JButton browse = new JButton("Browse...");
        
        canvas_up.add(text, BorderLayout.CENTER);
        canvas_up.add(browse, BorderLayout.LINE_END);
        canvas.add(canvas_up, BorderLayout.NORTH);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(canvas);

        final Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        final int wh = (int) dimension.getWidth();
        final int ht = (int) dimension.getHeight();
        frame.setSize(wh/2, ht/2);
        frame.setLocationByPlatform(true);
    }

    void display(){
        frame.setVisible(true);
    }

    public static void main(final String... a) {
        final SimpleGUIWithFileChooser gui = new SimpleGUIWithFileChooser(new Controller());
        gui.display();
    }

}
