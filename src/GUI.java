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
        top = makePanel();
        mid = makePanel();
        bot = makePanel();
        top.setBackground(Color.RED);
        mid.setBackground(Color.BLUE);
        bot.setBackground(Color.RED);
    }
    private JPanel makePanel(){
        JPanel x = new JPanel();
        int width = contentPane.getWidth();
        int height = contentPane.getHeight()/3 ;
        x.setPreferredSize(new Dimension(width,height));
        System.out.println(width + "  " + height);
        return x;
    }
}
