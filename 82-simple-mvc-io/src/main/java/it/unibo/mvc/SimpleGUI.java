package it.unibo.mvc;

import java.awt.BorderLayout;
import java.awt.LayoutManager;
import javax.swing.JButton;
import javax.swing.JFrame;
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

        canvas.add(text, BorderLayout.CENTER);
        canvas.add(save, BorderLayout.SOUTH);

        
        
        frame.setContentPane(canvas);

    }

    public void display(){
        frame.setVisible(true);
    }

    public static void main(final String... a) {
        final SimpleGUI gui = new SimpleGUI(new Controller());
        gui.display();
    }

}
