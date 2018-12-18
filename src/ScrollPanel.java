import java.util.*;
//import java.awt.*; List eksistere som metode i AWT og UTIL, samt AWT bliver ikke brugt
import javax.swing.*;
public class ScrollPanel extends JPanel
{
    List<Media> media;
    public ScrollPanel(String s, List l){
        media = l;
        for(Media m : media){
            if(m.getName().toLowerCase().contains(s)){ 
                this.add(new MediaPanel("" + m.getName(), m));

            }
            else if(m.getCategories().contains(s)){
                this.add(new MediaPanel("" + m.getName(), m));
            }
            
        }

    }
}
