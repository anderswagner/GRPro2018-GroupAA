
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class View{
    JFrame frame;
    JScrollPane scrollPane;
    private JTextField userNameField;
    JMenuBar menubar;
    public View(){
        frame = new JFrame();
        makeScroll("");
        makeButtons();

        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setMinimumSize(new Dimension(600,400));
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(true);
        frame.pack();
        frame.setVisible(true);

    }

    public void makeScroll(String s){
        scrollPane =  new JScrollPane(new GUI(s));
        scrollPane.getVerticalScrollBar().setUnitIncrement(30);
        frame.add(scrollPane);
    }

    public void makeButtons(){
        menubar =new JMenuBar();
        frame.setJMenuBar(menubar);
        JMenuItem logOut =new JMenuItem("log out");
        JMenuItem personalList =new JMenuItem("Personal List");
        JMenuItem frontPage = new JMenuItem("Front Page");
        logOut.addActionListener(
            (ActionEvent e) -> {
                new LogInScreen();
                frame.dispose();
            });
        personalList.addActionListener(
            (ActionEvent e) -> {
                frame.getContentPane().removeAll();
                makeScroll("PersonalList");
                makeButtons();
                frame.revalidate();
                frame.repaint();

            });
        frontPage.addActionListener(
            (ActionEvent e) -> {
                frame.getContentPane().removeAll();
                makeScroll("");
                makeButtons();
                frame.revalidate();
                frame.repaint();

            });
        menubar.add(logOut);
        menubar.add(personalList);
        menubar.add(frontPage);
        logOut.setMaximumSize(logOut.getPreferredSize());
        personalList.setMaximumSize(personalList.getPreferredSize());
        frontPage.setMaximumSize(frontPage.getPreferredSize());
        userNameField=new JTextField("Search for your favorite content HERE",30);
        userNameField.setMaximumSize(userNameField.getPreferredSize() );
        userNameField.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    if((userNameField.getText()).equals("Search for your favorite content HERE")){
                        userNameField.setText("");    
                    }

                }
            });

        userNameField.addActionListener(
            (ActionEvent e) -> {
                String search = userNameField.getText().toLowerCase();
                search.trim();
                frame.getContentPane().removeAll();
                makeScroll(search);
                makeButtons();
                frame.revalidate();
                frame.repaint();

            });
        menubar.add(Box.createHorizontalGlue());
        menubar.add(userNameField);
    }
}