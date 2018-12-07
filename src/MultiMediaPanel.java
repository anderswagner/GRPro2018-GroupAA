import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class MultiMediaPanel extends JPanel
{
    JLabel MediaCategory;
    JScrollPane scrollPane;
    public MultiMediaPanel(String mediaType){
        MediaCategory = new JLabel("" + mediaType);
        
        MediaCategory.setBackground(Color.BLACK);
        
        if(mediaType.equals("Movies")){
         //scrollPane =  new JScrollPane(new ScrollPanel(MediaController.getMovies()));   
        }
        
        //scrollPane =  new JScrollPane(new ScrollPanel());
        scrollPane.getHorizontalScrollBar().setUnitIncrement(30);
        this.setLayout(new BorderLayout()); 
        this.add(MediaCategory,BorderLayout.PAGE_START);
        this.setPreferredSize(new Dimension(600,400));
        
        
        this.add(scrollPane,BorderLayout.CENTER);
        this.setVisible(true);
    }
    
}
