import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class LogInScreen {
    private JFrame frame; //frame
    private JTextField userNameField; //til brugernavn
    private JPasswordField passwordField;
    private JLabel logInLabel; //til at printe på frame
    private JButton enterButton;//
    public LogInScreen(){
        makeFrame();
    }
    private void makeFrame(){
        // Frame delen
        frame =new JFrame("Log in screen");
        frame.setSize(500,250);//sætter start størrelsen
        frame.getContentPane().setBackground(Color.magenta);//sætter baggrundsfarven
        frame.setLocation(400,400);//sætter start location af frame
        frame.setLayout(null);//vælger typen af Layout
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//gør at programmet lukker ned hvis der trykkes på default close
        
        // Username delen
        logInLabel = new JLabel("Enter username");//Print string ved siden af box
        logInLabel.setSize(logInLabel.getPreferredSize());
        logInLabel.setLocation(10,50);
        frame.add(logInLabel);//tilføjer label til frame
        
        userNameField=new JTextField();//textField er text box 
        userNameField.setColumns(25);//længden på textboxen
        userNameField.setSize(userNameField.getPreferredSize());
        userNameField.setLocation(120,50);
        userNameField.setToolTipText("Enter username");//print string ved mouseover
        frame.add(userNameField);
        
        // Password delen
        logInLabel = new JLabel("Enter password");
        logInLabel.setSize(logInLabel.getPreferredSize());
        logInLabel.setLocation(10,100);
        frame.add(logInLabel);
        
        passwordField=new JPasswordField();//password felt betyer *** i stedet for string
        passwordField.setColumns(25);
        passwordField.setSize(userNameField.getPreferredSize());
        passwordField.setLocation(120,100);
        passwordField.setToolTipText("Enter password");
        frame.add(passwordField);
        
        //Enter knap
        enterButton=new JButton("Enter");//JButton tilføjer knap med string
        enterButton.setSize(enterButton.preferredSize());
        enterButton.setLocation(300,150);
        enterButton.addActionListener((ActionEvent e)->{enterButtonPressed(e);}); //tilføjer funktion til knappen ved ActionEvent e
        frame.add(enterButton);
        //Opret brugerknap
        enterButton=new JButton("Opret ny bruger");//JButton tilføjer knap med string
        enterButton.setSize(enterButton.preferredSize());
        enterButton.setLocation(120,150);
        enterButton.addActionListener((ActionEvent e)->{new OpretBruger();frame.dispose();}); //tilføjer funktion til knappen ved ActionEvent e
        frame.add(enterButton);
        frame.setVisible(true);
    }
    public void enterButtonPressed(ActionEvent e){
        new GUI();//åbner nyt gui vindue
        frame.dispose();//lukker vinduet 
    }
    
}