import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import javax.imageio.ImageIO;
public class CreateUserView {
    private JFrame frame; //frame
    private JTextField userNameField; //til brugernavn
    private JPasswordField passwordField;
    private JLabel logInLabel; //til at printe på frame
    private JButton createButton;//
    private JCheckBox adminCheckBox;
    private Image img;
    public CreateUserView(){
        makeFrame();
    }
    private void makeFrame(){
        
        // Frame delen
        frame =new JFrame("Log in screen");
        frame.setSize(500,290);//sætter start størrelsen
        frame.setLocation(400,400);//sætter start location af frame
        frame.setLayout(null);//vælger typen af Layout
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//gør at programmet lukker ned hvis der trykkes på default close
        try {
            frame.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("C:/Users/Vikto/Desktop/AA/GRPro2018-GroupAA/ExternalData/logo.png")))));
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        // Username delen
        logInLabel = new JLabel("Enter new username");//Print string ved siden af box
        logInLabel.setSize(logInLabel.getPreferredSize());
        logInLabel.setLocation(10,100);
        frame.add(logInLabel);//tilføjer label til frame
        
        userNameField=new JTextField();//textField er text box 
        userNameField.setColumns(25);//længden på textboxen
        userNameField.setSize(userNameField.getPreferredSize());
        userNameField.setLocation(130,100);
        userNameField.setToolTipText("Enter new username");//print string ved mouseover
        frame.add(userNameField);
        
        // Password delen
        logInLabel = new JLabel("Enter new password");
        logInLabel.setSize(logInLabel.getPreferredSize());
        logInLabel.setLocation(10,150);
        frame.add(logInLabel);
        
        passwordField=new JPasswordField();//password felt betyer *** i stedet for string
        passwordField.setColumns(25);
        passwordField.setSize(userNameField.getPreferredSize());
        passwordField.setLocation(130,150);
        passwordField.setToolTipText("Enter new password");
        frame.add(passwordField);

        //admin chechbox
        adminCheckBox=new JCheckBox("Er du admin?");//JButton tilføjer knap med string
        adminCheckBox.setSize(adminCheckBox.getPreferredSize());
        adminCheckBox.setLocation(300,200);
        frame.add(adminCheckBox);

        //Enter knap
        createButton=new JButton("Opret Bruger");//JButton tilføjer knap med string
        createButton.setSize(createButton.getPreferredSize());
        createButton.setLocation(150,200);
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
            System.out.println("Created a user with username");
            MediaController.getController().getView();
            frame.dispose();
        }
    }
}