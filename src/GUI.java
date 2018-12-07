import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class GUI extends JPanel
{
    public GUI(String s){
        this.add(new MultiMediaPanel("Movies", s));
        this.add(new MultiMediaPanel("Series", s));
        this.add(new MultiMediaPanel("Series", s));
        
        this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS)); 
    }
}
