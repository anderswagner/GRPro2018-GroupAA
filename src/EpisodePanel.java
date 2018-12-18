import java.util.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
public class EpisodePanel
{
    Series m;
    JFrame frame;
    Point p;
    public EpisodePanel(int s, Series m, Point p){
        this.m = m;
        this.p = p;
        frame = new JFrame();
        int season = s;
        int episodes = m.getEpisodesInSeason(season);
        String[] options = new String[episodes];

        for(int i = 0; i < episodes; i++){
            options[i] = "" + (i+1);
        }
        JComboBox optionList =  new JComboBox(options);
        optionList.addActionListener(
            (ActionEvent e) -> {
                frame.dispose();
                JOptionPane.showMessageDialog(null, "  Spiller nu: " + m.getName() + "  Season: " + s + "  Episode: " + optionList.getSelectedItem(), "MediaPlayer", JOptionPane.INFORMATION_MESSAGE);

            });

        frame.setLayout(new FlowLayout()); 
        frame.add(new JLabel("Which Episode?"));
        frame.add(optionList);
        frame.setUndecorated(true);
        frame.setLocation(p.x + 15, p.y + 10);
        frame.pack();
        frame.setVisible(true);
    }
}
