import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class View{
    JFrame frame;
    JScrollPane scrollPane;
    public View(){
        frame = new JFrame();
        scrollPane =  new JScrollPane(new GUI());
        frame.add(scrollPane);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setMinimumSize(new Dimension(600,400));
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(true);
        frame.pack();
        frame.setVisible(true);
        
    }
    
}