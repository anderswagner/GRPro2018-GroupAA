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
    JCheckBox addedToList;
    public MediaPanel(String s, Media m){
        this.setLayout(new FlowLayout()); 
        this.m = m;
        name = new JLabel(s);
        name.setHorizontalTextPosition(JLabel.CENTER);
        name.setVerticalTextPosition(JLabel.BOTTOM);
        this.setPreferredSize(new Dimension(200, 280));
        name.setIcon(new ImageIcon("ExternalData/Billeder/" + s + ".jpg"));
        this.add(name);
        if((MediaController.getController().getPersonalList()).contains(m)){
            addedToList = new JCheckBox("Added to ersonal list", true);
        }
        else{
            addedToList = new JCheckBox("Added to ersonal list");
        }
        addedToList.setSize(addedToList.getPreferredSize());
        addedToList.setLocation(170,210);
        this.add(addedToList);

        addedToList.addActionListener(
            (ActionEvent e) -> {
                if(addedToList.isSelected()){
                    MediaController.getController().addToPersonalList(m);

                }
                else{
                    MediaController.getController().removeFromPersonalList(m);

                }

            });

        name.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    if(e.getButton() == MouseEvent.BUTTON1){
                        if(m instanceof Series){
                            Series castedM = (Series) m;
                            new SeasonPanel(castedM);

                        }
                        else{
                            frame =  new JFrame();
                            frame.setUndecorated(true);
                            frame.add(new JLabel("  Spiller nu filmen: " + s + "  "));
                            frame.setLocationRelativeTo(null);
                            frame.pack();
                            frame.setVisible(true);
                        }

                    }

                }
            });

    }
}
