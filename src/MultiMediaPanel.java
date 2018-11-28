import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class MultiMediaPanel extends JPanel
{
    JLabel MediaCategory;
    JScrollPane scrollPane;
    public MultiMediaPanel(String mediaType){
        MediaCategory = new JLabel("" + mediaType);
        scrollPane =  new JScrollPane(new ScrollPanel());
        this.setLayout(new BorderLayout()); 
        this.add(MediaCategory,BorderLayout.PAGE_START);
        
        //scrollPane.setViewportView(new ScrollPanel());
        
        this.add(scrollPane,BorderLayout.CENTER);
        this.setVisible(true);
    }
    
}
