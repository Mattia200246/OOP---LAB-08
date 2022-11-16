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
        final JTextArea text = new JTextArea();
        final LayoutManager layout = new BorderLayout();
        final JPanel canvas = new JPanel();
        canvas.setLayout(layout);
        final JButton save = new JButton("save");
        save.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent arg0) {
                try{
                    controller.save(text.getText());
                }catch(IOException e){
                    JOptionPane.showMessageDialog(save, "Error");
                }
                
            }
            
        });
        


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


//INIZIATO IN LAB - ALCUNE DIFFICOLTA NELLA COMPRENSIONE DEL PRINT STREAM.
//ALCUNE DIFFICOLTA NELLA COMPRENSIONE DEL FUNZIONAMENTO DEL JFileChooser - INASPETTATA INTERFACCIA GRAFICA
//INIZIALMENTE NON AVEVO USATO UNO SWITCH MA UN IF, NON TENENDO CONTO DELLA POSSIBILITA' DI AVERE PIU' DI UNA OPZIONE

