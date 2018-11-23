import java.util.*;
import java.awt.*;
import javax.swing.*;
public class MediaPanel extends JPanel
{
    private Media myMedia;
    private Dimension size;
    private JLabel name;
    public MediaPanel(){
      //myMedia = media;
      //name = new JLabel( myMedia.getName());
      this.setLayout(new FlowLayout()); 
      name = new JLabel("Pirate");
      this.setPreferredSize(new Dimension(200, 100));;
      this.add(name);
      this.setBackground(Color.MAGENTA);

    }
}
