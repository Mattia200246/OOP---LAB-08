package it.unibo.mvc;


import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;


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
        text.setText(controller.getCurrentPath());
        text.setEditable(false);
        JTextArea textArea = new JTextArea();


        final JButton save = new JButton("save");
        save.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e){
                try{
                    controller.save(textArea.getText());
                    textArea.setText("");
                    textArea.requestFocus();
                } catch (IOException i) {
                    JOptionPane.showMessageDialog(null, i.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
                }
            }
            
        });

        final JButton browse = new JButton("Browse...");
        browse.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                final JFileChooser choose = new JFileChooser();
                final int choice = choose.showSaveDialog(frame);
                switch (choice){
                    default:
                        JOptionPane.showMessageDialog(frame, choice, "Error", JOptionPane.ERROR_MESSAGE);
                    case JFileChooser.APPROVE_OPTION:
                        final File new_file = choose.getSelectedFile();
                        controller.setFile(new_file);
                        text.setText(new_file.getAbsolutePath());
                        break;
                    
                    case JFileChooser.CANCEL_OPTION:
                        break;
                }
            }
            
        });
        
        canvas_up.add(text, BorderLayout.CENTER);
        canvas_up.add(browse, BorderLayout.LINE_END);
        canvas.add(canvas_up, BorderLayout.NORTH);
        canvas.add(save, BorderLayout.SOUTH);
        canvas.add(textArea, BorderLayout.CENTER);

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
