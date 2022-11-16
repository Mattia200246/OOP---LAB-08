package it.unibo.mvc;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

/**
 * A very simple program using a graphical interface.
 * 
 */
public final class SimpleGUI {

    private final JFrame frame = new JFrame();
    private final Controller controller;

    public SimpleGUI(Controller controller){
        this.controller = controller;
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel canvas = new JPanel();
        JPanel canvasSouth = new JPanel();
        canvas.setLayout(new BorderLayout());
        canvasSouth.setLayout(new BoxLayout(canvasSouth, BoxLayout.LINE_AXIS));

        JTextArea textArea = new JTextArea();
        JTextField textField = new JTextField();
        JButton print = new JButton("Print");
        print.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.setNextString(textField.getText());
                controller.printCurrentString();

            }
        });
        JButton viewHistory = new JButton("View History");
        viewHistory.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                List<String> history = SimpleGUI.this.controller.history();
                String finalText= " ";
                for(String i : history ){
                    finalText= finalText + i + "\n";
                }
                
                textArea.setText(finalText);
            }
            
        });

        frame.setContentPane(canvas);
        canvas.add(textField, BorderLayout.NORTH);
        canvas.add(textArea, BorderLayout.CENTER);
        canvas.add(canvasSouth, BorderLayout.SOUTH);
        canvasSouth.add(print);
        canvasSouth.add(viewHistory);

        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        final int width = (int) dimension.getWidth();
        final int height = (int) dimension.getHeight();
        frame.setSize(width/2, height/2);
        frame.setLocationByPlatform(true);

        
    }

    void display(){
        frame.setVisible(true);
    }

    public static void main(final String... a){
        new SimpleGUI(new SimpleController()).display();
    }

}
