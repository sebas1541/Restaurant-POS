package views.mainviews;

import views.ownclass.ResizeImage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**Clase donde se trabaja el inicio de sesion del administrador
 * * @author
 * *     David Lotero
 * *     Miguel Avila
 * *     Sebastian Cañon*/

public class Login extends JPanel {
    /**Definicion de atributos del panel*/
    private JLabel logoLabel;
    private JLabel usernameLabel;
    private JLabel passwordLabel;
    private ImageIcon icon;
    private JTextField usernameTextField;
    private JPasswordField passwordField;
    private JButton submitButton, backButton;
    private GridBagConstraints gbc;
    /**Método constructor
     * @param ac recibe el ActionListener, cual se asignara a algunos de
     * los componentes del panel*/
    public Login(ActionListener ac) {
        initComponents(ac);    }
    /**Método que inicializa cada uno de los atributos del panel
     * @param ac recibe el Action listener para asignarlo a algunos botones*/
    public void initComponents(ActionListener ac){
        this.setLayout(new GridBagLayout());
        gbc = new GridBagConstraints();
        createLogoLabel();
        createPasswordField();
        createPasswordLabel();
        createUserNameTextField();
        createUserNameLabel();
        createSubmitButton(ac);
        createBackButton(ac);
    }
    /**Metodo que le asigna a un JLabel una imagen*/
    public void createLogoLabel(){
        icon = new ImageIcon("src/resources/Logos/logo-dogzilla-01.png");
        icon = new ResizeImage().resize(icon, 220, 220);
        logoLabel = new JLabel(icon);
        GridBagConstraints gbcI = new GridBagConstraints();
        gbcI.insets = new Insets(0, 70, 0, 0);
        gbcI.anchor = GridBagConstraints.NORTH;
        this.add(logoLabel,gbcI);
    }
    /**Metodo donde se crea un JLabel, denominado "Username:",
     *el JLabel tiene la funcionalidad de identificar que JTextField es el encargado de almacenar
     * el usuario de ingreso*/
    public void createUserNameLabel(){
        usernameLabel = new JLabel("Username:");
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.insets = new Insets(20, -150, 0, 0);
        this.add(usernameLabel, gbc);
    }
    /**Metodo que retorna el usuario ingresado en el JTextField
     * @return usernameTextField.getText()   retorna el contenido del JTextField*/
    public String user() {
        return usernameTextField.getText();
    }
    /**Metodo que recupera la contraseña ingresada por el usuario
     * @return passwordField.getText()   retorna el contenido del JPasswordField*/
    public String password() {
        return passwordField.getText();
    }
    /**Metodo donde se crea un JTextFiel, en el cual se almacenara el usuario ingresado en la ventana;*/
    public void createUserNameTextField(){
        usernameTextField = new JTextField();
        usernameTextField.setPreferredSize(new Dimension(150, 30));
        gbc.insets = new Insets(20, -150, 0, 0);
        gbc.gridx = 1;
        gbc.gridy =1;
        this.add(usernameTextField, gbc);
    }
    /**Metodo donde se crea un JLabel, denominado "Password:",
     *el JLabel tiene la funcionalidad de ayudar al usuario a identificar en que sitio
     * debe ingresar su clave de ingreso*/
    public void createPasswordLabel(){
        passwordLabel = new JLabel("Password:");
        gbc.insets = new Insets(20, -150, 0, 0);
        gbc.gridx = 0;
        gbc.gridy = 2;
        this.add(passwordLabel, gbc);
    }


    /**Metodo donde se crea un JPasswordFiel, en el cual se almacena la contraseña ingresada por el usuario*/
    public void createPasswordField(){
        gbc.insets = new Insets(20, -150, 0, 0);
        passwordField = new JPasswordField();
        passwordField.setPreferredSize(new Dimension(150, 30));
        gbc.gridx = 1;
        gbc.gridy = 2;
        this.add(passwordField, gbc);
    }
    /**Metodo donde se inicializa el submintButton
     * @param ac recibe un ActionListener, el cual se le agrega al boton*/
    public void createSubmitButton(ActionListener ac){
        submitButton = new JButton("Enviar");
        submitButton.addActionListener(ac);
        gbc.insets = new Insets(20, -150, 0, 0);
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.CENTER;
        this.add(submitButton, gbc);
    }

    public void createBackButton(ActionListener ac){
        backButton = new JButton("Volver");
        backButton.addActionListener(ac);
        gbc.insets = new Insets(20, -150, 0, 0);
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.CENTER;
        this.add(backButton, gbc);
    }
}