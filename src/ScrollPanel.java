import java.util.*;
//import java.awt.*;
import javax.swing.*;
public class ScrollPanel extends JPanel
{
    List<Media> media;
    public ScrollPanel(String s, List l){
        media = l;
        for(Media m : media){
            if(m.getName().toLowerCase().contains(s)){ 
                this.add(new MediaPanel("" + m.getName()));

            }
            if(m.getCategories().contains(s)){
                this.add(new MediaPanel("" + m.getName()));
            }
        }

    }
}
