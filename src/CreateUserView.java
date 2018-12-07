import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class CreateUserView {
    private JFrame frame; //frame
    private JTextField userNameField; //til brugernavn
    private JPasswordField passwordField;
    private JLabel logInLabel; //til at printe på frame
    private JButton createButton;//
    private JCheckBox adminCheckBox;
    public CreateUserView(){
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

        //admin chechbox
        adminCheckBox=new JCheckBox("Er du admin?");//JButton tilføjer knap med string
        adminCheckBox.setSize(adminCheckBox.getPreferredSize());
        adminCheckBox.setLocation(300,150);
        frame.add(adminCheckBox);

        //Enter knap
        createButton=new JButton("Opret Bruger");//JButton tilføjer knap med string
        createButton.setSize(createButton.getPreferredSize());
        createButton.setLocation(150,150);
        createButton.addActionListener((ActionEvent e)->{
            createdUser(
            MediaController.getController().
                    CreateUser(userNameField.getText(),
                            String.valueOf(passwordField.getPassword()),
                            adminCheckBox.isSelected()
                    )
            );
        }); //Tilføjer event til MediaController på knappe-tryk

        frame.add(createButton);
        frame.setVisible(true);
    }

    private void createdUser(boolean success){
        if (success) {
            System.out.println("Created a user");
        }
    }
}