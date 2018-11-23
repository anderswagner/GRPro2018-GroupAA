import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class MultiMediaPanel extends JPanel
{
    JLabel MediaCategory;
    public MultiMediaPanel(String mediaType){
        MediaCategory = new JLabel("" + mediaType);
        this.setLayout(new BorderLayout()); 
        this.add(MediaCategory,BorderLayout.PAGE_START);
        this.add(new ScrollPanel(),BorderLayout.CENTER);

    }
    
}
