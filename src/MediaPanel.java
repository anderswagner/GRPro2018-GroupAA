import java.util.*;
import java.awt.*;
import javax.swing.*;
public class MediaPanel extends JPanel
{
    private JLabel name;
    public MediaPanel(String s){
      this.setLayout(new FlowLayout()); 
      name = new JLabel(s);
      this.setPreferredSize(new Dimension(200, 100));;
      this.add(name);
      this.setBackground(Color.MAGENTA);

    }
}
