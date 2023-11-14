package views;

import resources.Fonts.Roboto;

import javax.swing.*;
import java.awt.*;


public class LogInView extends JFrame {

    private JPanel panel;
    private JLabel logoLabel;
    private JLabel usernameLabel;
    private JLabel passwordLabel;
    private ResizeImage resizeImage = new ResizeImage();
    private ImageIcon icon;
    private JTextField usernameTextField;
    private JPasswordField passwordField;
    private JButton submitButton;


    public LogInView() {
        panel = new JPanel();
        logoLabel = new JLabel();
        usernameLabel = new JLabel("Username:");
        passwordLabel = new JLabel("Password:");
        usernameTextField = new JTextField();
        passwordField = new JPasswordField();
        submitButton = new JButton("Submit");

        icon = new ImageIcon("src/resources/logo-dogzilla-01.png");
        icon = resizeImage.resize(icon, 200, 200);

        logoLabel.setIcon(icon);
        logoLabel.setHorizontalAlignment(SwingConstants.CENTER);

        usernameTextField.setPreferredSize(new Dimension(150, 30));
        passwordField.setPreferredSize(new Dimension(150, 30));



        panel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(usernameLabel, gbc);

        gbc.gridx = 1;
        panel.add(usernameTextField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(passwordLabel, gbc);

        gbc.gridx = 1;
        panel.add(passwordField, gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        panel.add(submitButton, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;


        this.add(logoLabel, BorderLayout.NORTH);
        this.add(panel, BorderLayout.CENTER);
        this.setIconImage(icon.getImage());
        this.setSize(400, 400);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }


    public static void main(String[] args) {
        new LogInView();
    }
}
