package views.mainviews;

import views.ownclass.ResizeImage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**Clase que hereda de JPanel,
 * donde, se maneja la ventana principal del proyecto
 * * @author
 * *     David Lotero
 * *     Miguel Avila
 * *     Sebastian Cañon*/
public class MainWindow extends JPanel {
    /**Definicion de atributos del panel*/
    private JButton employee, adm;
    private JLabel info, icon;
    private GridBagConstraints gbc;
    /**Método constructor
     * @param ac recibe el ActionListener para asignarlo a algunos de sus componentes*/
    public MainWindow(ActionListener ac){
        this.setBackground(Color.white);
        initComponents(ac);
    }
    /**Método que inicializa cada uno de los atributos del panel
     * @param ac recibe un ActionListener para asignarlo a algunos componentes del panel*/
    public void initComponents(ActionListener ac){
        this.setLayout(new GridBagLayout());
        gbc = new GridBagConstraints();
        createJLabelIcon();
        createJLabelInfo();
        createJButtonAdministrator(ac);
        createJButtonEmployee(ac);
    }
    /**Metodo que asigna una imagen a un JLabel,
     * le asigna tamaño y ubicacion  dentro del panel*/
    public void createJLabelIcon() {
        ImageIcon ImgIcon = new ImageIcon("src/resources/Logos/logo-dogzilla-01.png");
        ImgIcon = new ResizeImage().resize(ImgIcon,100,100);
        icon = new JLabel(ImgIcon);
        gbc.insets = new Insets(0,0,50,0);
        gbc.gridx = 0;
        gbc.gridy = 1;
        this.add(icon, gbc);
    }
    /**Metodo donde se crea un JLabel;
     * dicho JLabel, tiene la funcion de pedirle al usuario que elija si es "Administrador" o "Empleado"*/
    public void createJLabelInfo() {
        info = new JLabel("Elige la opción:");
        info.setFont(new Font("Arial", Font.BOLD, 24));
        info.setForeground(Color.BLACK);
        info.setPreferredSize(new Dimension(500,30));
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 3;
        gbc.insets = new Insets(10,0,80,0);
        gbc.anchor = GridBagConstraints.CENTER;
        this.add(info, gbc);
    }
    /**Metodo donde se inicializa el boton de empleado,
     * @param ac recibe un ActionListener para asignarlo al boton de "Empleado" */
    public void createJButtonEmployee(ActionListener ac) {
        employee = new JButton("Empleado");
        employee.addActionListener(ac);
        employee.setPreferredSize(new Dimension(150,50));
        gbc.insets = new Insets(0,0,20,0);
        gbc.gridx = 1;
        gbc.gridy = 5;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.gridwidth = 1;
        this.add(employee, gbc);
    }
    /**Metodo donde se inicializa el boton de administrador,
     * @param ac recibe un ActionListener para asignarlo al boton de "Administrador" */
    public void createJButtonAdministrator(ActionListener ac) {
        adm = new JButton("Administrador");
        adm.addActionListener(ac);
        adm.setPreferredSize(new Dimension(150,50));
        gbc.insets = new Insets(0,0,20,0);
        gbc.gridx = 2;
        gbc.gridy = 5;
        gbc.anchor = GridBagConstraints.EAST;
        gbc.gridwidth = 1;
        this.add(adm, gbc);
    }
}