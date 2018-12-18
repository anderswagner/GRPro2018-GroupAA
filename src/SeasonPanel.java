import java.util.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;

public class SeasonPanel
{
    Series m;
    JFrame frame;
    

    public SeasonPanel(Series m){
        this.m = m;
        frame = new JFrame();
        
        String[] options = new String[m.getSeasons()];

        for(int i = 0; i < m.getSeasons(); i++){
            options[i] = "" + (i+1);
        }
        JComboBox optionList =  new JComboBox(options);
        Point p = MouseInfo.getPointerInfo().getLocation();
        optionList.addActionListener(
            (ActionEvent e) -> {
                String search = (String) optionList.getSelectedItem();
                int seasonNumber = Integer.parseInt(search);
                frame.dispose();
                new EpisodePanel(seasonNumber, m, p);

            });
        frame.setLayout(new FlowLayout()); 
        frame.add(new JLabel("Which Season?"));
        frame.add(optionList);
        frame.setUndecorated(true);
        frame.setLocation(p.x + 15, p.y + 10);
        frame.pack();
        frame.setVisible(true);   
    }
}

