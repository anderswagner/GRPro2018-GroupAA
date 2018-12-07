import java.util.*;
//import java.awt.*;
import javax.swing.*;
public class ScrollPanel extends JPanel
{
    List<Media> media;
    public ScrollPanel(List l){
        media = l;
        for(Media m : media){
            if(m instanceof Movie){
             this.add(new MediaPanel("" + m.getName()));   
            }
        }
        
    }
}
