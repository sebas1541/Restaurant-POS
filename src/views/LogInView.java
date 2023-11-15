package views;

import resources.Fonts.Roboto;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;


public class LogInView extends JPanel {

    private JLabel logoLabel;
    private JLabel usernameLabel;
    private JLabel passwordLabel;
    private ImageIcon icon;
    private JTextField usernameTextField;
    private JPasswordField passwordField;
    private JButton submitButton;
    private GridBagConstraints gbc;
    public LogInView(ActionListener ac) {
        initComponents(ac);    }
    public void initComponents(ActionListener ac){
        this.setLayout(new GridBagLayout());
        gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        createLogoLabel();
        createPasswordField();
        createPasswordLabel();
        createUserNameTextField();
        createUserNameLabel();
        createSubmitButton(ac);
    }
    public void createLogoLabel(){
        icon = new ImageIcon("src/resources/Logos/logo-dogzilla-01.png");
        icon = new ResizeImage().resize(icon, 220, 220);
        logoLabel = new JLabel(icon);
        GridBagConstraints gbcI = new GridBagConstraints();
        gbcI.insets = new Insets(0, 70, 0, 0);
        //gbcI.gridy =0;
        //gbcI.gridx =0;
        gbcI.anchor = GridBagConstraints.NORTH;
        this.add(logoLabel,gbcI);
    }
    public void createUserNameLabel(){
        usernameLabel = new JLabel("Username:");
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.insets = new Insets(20, -150, 0, 0);
        this.add(usernameLabel, gbc);
    }
    public String user() {
        return usernameTextField.getText();
    }
    public String password() {
        return passwordField.getText();
    }
    public void createUserNameTextField(){
        usernameTextField = new JTextField();
        usernameTextField.setPreferredSize(new Dimension(150, 30));
        gbc.insets = new Insets(20, -150, 0, 0);
        gbc.gridx = 1;
        gbc.gridy =1;
        this.add(usernameTextField, gbc);
    }
    public void createPasswordLabel(){
        passwordLabel = new JLabel("Password:");
        gbc.insets = new Insets(20, -150, 0, 0);
        gbc.gridx = 0;
        gbc.gridy = 2;
        this.add(passwordLabel, gbc);
    }
    public void createPasswordField(){
        gbc.insets = new Insets(20, -150, 0, 0);
        passwordField = new JPasswordField();
        passwordField.setPreferredSize(new Dimension(150, 30));
        gbc.gridx = 1;
        gbc.gridy = 2;
        this.add(passwordField, gbc);
    }
    public void createSubmitButton(ActionListener ac){
        submitButton = new JButton("Submit");
        submitButton.addActionListener(ac);
        gbc.insets = new Insets(20, -150, 0, 0);
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.CENTER;
        this.add(submitButton, gbc);
    }
}