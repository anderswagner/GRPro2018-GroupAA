import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class GUI
{
    JFrame frame;
    Container contentPane;
    JPanel top;
    JPanel mid;
    JPanel bot;
    public GUI(){
        start();
        contentPane.setBackground(Color.BLACK);
        drawPanels();
        }
    private void start(){
        frame = new JFrame();
        contentPane = frame.getContentPane();
        frame.addComponentListener(new ComponentAdapter() {
            public void componentResized(ComponentEvent componentEvent) {
                //Dette sker hver gang vinduet blivder resized.
                contentPane.removeAll();
                drawPanels();
                contentPane.add(top);
                contentPane.add(mid);
                contentPane.add(bot);
                contentPane.revalidate();
            }
        });
        frame.setLayout(new FlowLayout()); 
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setMinimumSize(new Dimension(600,400));
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(true);
        frame.pack();
        frame.setVisible(true);
    }
    public void drawPanels(){
        top = makePanel(1,7, "Bruger navn");
        mid = makePanel(2,7, "Film");
        bot = makePanel(2,7, "Serier");
        top.setBackground(Color.RED);
        mid.setBackground(Color.BLUE);
        bot.setBackground(Color.RED);
    }
    private JPanel makePanel(int y, int t, String mediaType){
        JPanel x = new MultiMediaPanel("" + mediaType);
        int width = contentPane.getWidth()/2;
        int height = contentPane.getHeight() * y/t ;
        x.setPreferredSize(new Dimension(width,height));
        System.out.println(width + "  " + height);
        return x;
    }
}
