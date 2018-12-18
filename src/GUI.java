import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class GUI extends JPanel
{
    public GUI(String s){
        if(s.equals("PersonalList")){
            this.add(new MultiMediaPanel("PersonalList", s));    
        }
        else{
            this.add(new MultiMediaPanel("Movies", s));
            this.add(new MultiMediaPanel("Series", s));
        }

        
        this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS)); 
    }
}
