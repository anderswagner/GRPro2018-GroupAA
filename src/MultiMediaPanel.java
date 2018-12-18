import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class MultiMediaPanel extends JPanel
{
    JLabel MediaCategory;
    JScrollPane scrollPane;
    public MultiMediaPanel(String mediaType, String s){
        MediaCategory = new JLabel("" + mediaType);
        
        MediaCategory.setBackground(Color.BLACK);
        
        if(mediaType.equals("Movies")){
        scrollPane =  new JScrollPane(new ScrollPanel(s, MediaController.getController().getMovies()));
        }
        else if(mediaType.equals("Series")){
        scrollPane =  new JScrollPane(new ScrollPanel(s, MediaController.getController().getSeries()));
        }
        else if(mediaType.equals("PersonalList")){
          scrollPane =  new JScrollPane(new ScrollPanel("", MediaController.getController().getPersonalList()));  
        }
        
        
        scrollPane.getHorizontalScrollBar().setUnitIncrement(30);
        this.setLayout(new BorderLayout()); 
        this.add(scrollPane,BorderLayout.CENTER);
        
               
        
        this.add(MediaCategory,BorderLayout.PAGE_START);
        this.setPreferredSize(new Dimension(600,200));
        
        
        
        this.setVisible(true);
    }
    
}
