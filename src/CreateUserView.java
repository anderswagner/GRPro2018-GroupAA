import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class CreateUserView {
    private JFrame frame; //frame
    private JTextField userNameField; //til brugernavn
    private JPasswordField passwordField;
    private JLabel logInLabel; //til at printe på frame
    private JButton createUserView;//
    private JCheckBox adminCheckBox;
    public CreateUserView(){
        makeFrame();
        //User user=new User();
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
        logInLabel = new JLabel("Enter new username");//Print string ved siden af box
        logInLabel.setSize(logInLabel.getPreferredSize());
        logInLabel.setLocation(10,50);
        frame.add(logInLabel);//tilføjer label til frame
        
        userNameField=new JTextField();//textField er text box 
        userNameField.setColumns(25);//længden på textboxen
        userNameField.setSize(userNameField.getPreferredSize());
        userNameField.setLocation(130,50);
        userNameField.setToolTipText("Enter new username");//print string ved mouseover
        frame.add(userNameField);
        
        // Password delen
        logInLabel = new JLabel("Enter new password");
        logInLabel.setSize(logInLabel.getPreferredSize());
        logInLabel.setLocation(10,100);
        frame.add(logInLabel);
        
        passwordField=new JPasswordField();//password felt betyer *** i stedet for string
        passwordField.setColumns(25);
        passwordField.setSize(userNameField.getPreferredSize());
        passwordField.setLocation(130,100);
        passwordField.setToolTipText("Enter new password");
        frame.add(passwordField);
        
        //Enter knap
        createUserView=new JButton("Opret Bruger");//JButton tilføjer knap med string
        createUserView.setSize(createUserView.getSize());
        createUserView.setLocation(150,150);
        createUserView.addActionListener((ActionEvent e)->{enterButtonPressed(e);}); //tilføjer funktion til knappen ved ActionEvent e
        frame.add(createUserView);
        
        //admin chechbox
        adminCheckBox=new JCheckBox("Er du admin?");//JButton tilføjer knap med string
        adminCheckBox.setSize(createUserView.getSize());
        adminCheckBox.setLocation(300,150);
        frame.add(adminCheckBox);
        
        
        frame.setVisible(true);
    }
    private void enterButtonPressed(ActionEvent e){
        if(adminCheckBox.isSelected()){}
        //user.setUserName(userNameField.getText());
        //user.setPassword(passwordField.getText());
        new LogInScreen();
        frame.dispose();
    }
    
    
}