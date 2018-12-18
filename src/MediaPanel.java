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
            addedToList = new JCheckBox("Add to Personal list", true);
        }
        else{
            addedToList = new JCheckBox("Add to Personal list");
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

                            JOptionPane.showMessageDialog(null, "  Spiller nu filmen: " + s + "  ", "MediaPlayer", JOptionPane.INFORMATION_MESSAGE);

                        }

                    }
                    else if(e.getButton() == MouseEvent.BUTTON3){
                        if(m instanceof Movie){
                            JOptionPane.showMessageDialog(null,  s + "  has a rating of:  " + m.getRating() + "\n" + "And was first released in:  " + m.getYear(), "InfoBox", JOptionPane.INFORMATION_MESSAGE);
                        }
                        else if(m instanceof Series){
                            Series castedM = (Series) m;
                            String yearTo = "" +castedM.getYearTo();
                            if(Integer.parseInt(yearTo) == 0){
                                yearTo = Calendar.getInstance().get(Calendar.YEAR) + "  (Still running)";
                            }
                            JOptionPane.showMessageDialog(null,  s + "  has a rating of:  " + m.getRating() +"\n" + "The show has been running from:  " + m.getYear() + " to:  " + yearTo, "InfoBox", JOptionPane.INFORMATION_MESSAGE);
                        }
                    }
                }
            });

    }
}
