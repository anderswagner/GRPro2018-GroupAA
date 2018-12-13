import java.util.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
public class MediaPanel extends JPanel
{
    private JLabel name;
    public MediaPanel(String s){
        this.setLayout(new FlowLayout()); 
        name = new JLabel(s);
        name.setHorizontalTextPosition(JLabel.CENTER);
        name.setVerticalTextPosition(JLabel.BOTTOM);
        this.setPreferredSize(new Dimension(200, 250));
        name.setIcon(new ImageIcon("ExternalData/Billeder/" + s + ".jpg"));
        this.add(name);
        name.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    if(e.getButton() == MouseEvent.BUTTON1){
                        JFrame frame =  new JFrame();
                        frame.setUndecorated(true);
                        frame.add(new JLabel("  Spiller nu filmen: " + s + "  "));
                        //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); DONT det lukker HELE programemt når du trykker kryds på det nye vindue
                        frame.setLocationRelativeTo(null);
                        frame.pack();
                        frame.setVisible(true);
                    }
                    else if(e.getButton() == MouseEvent.BUTTON3){

                        JFrame frame =  new JFrame();
                        frame.setUndecorated(true);
                        frame.add(new JLabel("  Here are your options:  "));
                        Point p = MouseInfo.getPointerInfo().getLocation();
                        String[] options = {"What is my purpose master?", "Remove from my list", "Add to my list"};
                        JComboBox optionList =  new JComboBox(options);
                        frame.add(optionList);
                        frame.setLocation(p.x + 15, p.y + 10);
                        frame.pack();
                        frame.setVisible(true);

                    }
                }
            });

        //this.setBackground(Color.MAGENTA);

    }
}
