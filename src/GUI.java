import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class GUI extends JPanel
{
    public GUI(){
        this.add(new MultiMediaPanel("film"));
        this.add(new MultiMediaPanel("film"));
        
        this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS)); 
    }
}
