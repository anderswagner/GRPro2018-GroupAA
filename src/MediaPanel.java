import java.util.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
public class MediaPanel extends JPanel
{
    private JLabel name;
    Media m;
    JFrame frame;
    public MediaPanel(String s, Media m){
        this.setLayout(new FlowLayout()); 
        this.m = m;
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
                        
                        frame =  new JFrame();
                        frame.setUndecorated(true);
                        frame.add(new JLabel("  Spiller nu filmen: " + s + "  "));
                        //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); DONT det lukker HELE programemt når du trykker kryds på det nye vindue
                        frame.setLocationRelativeTo(null);
                        frame.pack();
                        frame.setVisible(true);
                    }
                    else if(e.getButton() == MouseEvent.BUTTON3){
                        
                        frame =  new JFrame();
                        frame.setUndecorated(true);
                        frame.add(new JLabel("  Here are your options:  "));
                        Point p = MouseInfo.getPointerInfo().getLocation();
                        String[] options = {"What is my purpose master?", "Remove from my list", "Add to my list"};
                        JComboBox optionList =  new JComboBox(options);
                        optionList.addActionListener(
                            (ActionEvent t) -> {
                                String search = (String) optionList.getSelectedItem();

                                if(search.equals("Remove from my list")){
                                    try{
                                        frame.dispose();
                                        MediaController.getController().RemoveFromPersonalList(m);
                                        
                                    }
                                    catch(Exception error){}
                                }
                                else if(search.equals("Add to my list")){
                                    frame.dispose();
                                    MediaController.getController().AddToPersonalList(m);
                                }
                                else{frame.dispose();}

                            });
                        frame.add(optionList);
                        frame.setLocation(p.x + 15, p.y + 10);
                        frame.pack();
                        frame.setVisible(true);

                    }
                }
            });

    }
}
