package views;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.border.Border;

public class MainWindow extends JFrame {


    //Atributos Top Panel - Encabezado

    private JPanel topPanel;
    private ImageIcon companyIcon;
    private JLabel companyIconLabelHeader;
    private JLabel date;


    //Atributos de la navegación inferior
    private JPanel navigationPanelBottom;
    private JButton hotDogButton;
    private JButton additiveButton;
    private JButton drinkBUtton;

    //Atributos del display de items del centro

    private JPanel itemsPanel;
    private JPanel item;
    private ImageIcon itemImage;
    private JLabel itemName;
    private JLabel itemPrice;
    private ScrollPane scrollPane;

    //Atributos del panel derecho - Resumen Total de Orden

    private JPanel rightPanel;

    //Atributos Sub Panel Superior del Panel Derecho

    private JPanel topPanelOfRightPanel;
    private JLabel orderLabel;
    private JLabel orderNumberLabel;
    private JLabel customerLabel;
    private JLabel customerNameLabel;

    //Atributos Sub Panel central del Panel Derecho - Resumen de Items

    private JPanel centerPanelofRightPanel;
    private JPanel itemSummary;
    private ImageIcon itemSummaryImage;
    private JLabel itemSummaryItemName;
    private JLabel ItemSummaryItemPrice;
    private JLabel quantityText;
    private JLabel quantityValue;
    private JButton addItem;
    private JButton substractItem;

    //Atributos Sub Panel Inferior del Panel Derecho - Resumen de Orden
    private JPanel buttomPanelOfRightPanel;

    //Atrrubitos Sub Panel Superior del Sub Panel inferior del Panel Derecho
    private JPanel topPanelOfButtomPanelofRightPanel;
    private JLabel subtotalText;
    private JLabel subtotalValue;
    private JLabel taxText;
    private JLabel taxValue;

    //Atributos Sub Panel Inferior del Sub Panel inferior del Panel Derecho
    private JPanel buttomPanelOfButtomPanelofRightPanel;
    private JLabel total;
    private JLabel totalPriceValue;
    private JButton cancelButton;
    private JButton confirmButton;


    //Atributos Panel de la Izquierda
    private JPanel leftPanel;

    //Boton Home
    private JPanel homeOption;
    private ImageIcon homeOptionImage;
    private JLabel homeOptionImageLabel;
    private JLabel homeOptionText;

    //Boton Orden
    private JPanel orderOption;
    private ImageIcon orderOptionImage;
    private JLabel orderOptionImageLabel;
    private JLabel orderOptionText;

    //Boton Historial Ordenes
    private JPanel orderHistoryOption;
    private ImageIcon orderHistoryOptionImage;
    private JLabel orderHistoryOptionImageLabel;
    private JLabel orderHistoryOptionText;

    //Boton Configuración POS
    private JPanel settingsOption;
    private ImageIcon settingsOptionImage;
    private JLabel settingsOptionText;

    public MainWindow() {
        //Top Panel Styling
        topPanel = new JPanel();
        GridBagConstraints gbcTopPanel = new GridBagConstraints();
        gbcTopPanel.insets = new Insets(5,10,5,70);
        topPanel.setLayout(new GridBagLayout());
        topPanel.setBackground(Color.WHITE);
        topPanel.setBorder(BorderFactory.createMatteBorder(0,0,3,0, new Color(236, 237, 237)));

        //Image Styling and Positioning
        //IconImage Resizing
        companyIcon = new ImageIcon("src/resources/Logos/logo-dogzilla-01.png");
        companyIcon = new ResizeImage().resize(companyIcon, 80,80);
        //Grid Bag Layout Properties
        companyIconLabelHeader = new JLabel(companyIcon);
        gbcTopPanel.gridx = 0;
        gbcTopPanel.gridy = 0;
        gbcTopPanel.anchor = GridBagConstraints.WEST;
        topPanel.add(companyIconLabelHeader, gbcTopPanel);

        //Date Styles
        date = new JLabel("23 de Junio de 2023");
        date.setFont(new Font("Arial", Font.BOLD, 12));

        gbcTopPanel.gridx = 1;
        gbcTopPanel.gridy = 0;
        gbcTopPanel.anchor = GridBagConstraints.EAST;
        gbcTopPanel.weightx = 1;
        topPanel.add(date, gbcTopPanel);

        //Left Panel Styles
        leftPanel = new JPanel();
        leftPanel.setLayout(new GridBagLayout());
        leftPanel.setBackground(Color.WHITE);
        leftPanel.setPreferredSize(new Dimension(107, leftPanel.getHeight()));
        leftPanel.setBorder(BorderFactory.createMatteBorder(0,0,0,3, new Color(236, 237, 237)));


        GridBagConstraints gbcLeftPanel = new GridBagConstraints();
        gbcLeftPanel.insets = new Insets(10, 0, 10, 0);

        //Home Button

        homeOption = new JPanel();
        homeOption.setLayout(new BorderLayout());

        homeOptionImage = new ImageIcon("src/resources/OrderViewResources/LeftPanelIcons/Home Button Not Clicked.png");
        homeOptionImage = new ResizeImage().resize(homeOptionImage, 30,28);
        homeOptionImageLabel = new JLabel(homeOptionImage);

        homeOptionText = new JLabel("Inicio");
        homeOptionText.setForeground(new Color(189,189,189));
        homeOptionText.setFont(new Font("Arial", Font.BOLD, 12));
        homeOptionText.setHorizontalAlignment(SwingConstants.CENTER);
        homeOptionText.setBorder(BorderFactory.createEmptyBorder(10,0,0,0));

        homeOption.setBackground(Color.WHITE);
        homeOption.add(homeOptionImageLabel, BorderLayout.CENTER);
        homeOption.add(homeOptionText, BorderLayout.PAGE_END);

        gbcLeftPanel.gridy = 0;
        leftPanel.add(homeOption, gbcLeftPanel);

        //Order Button

        orderOption = new JPanel();
        orderOption.setLayout(new BorderLayout());

        orderOptionImage = new ImageIcon("src/resources/OrderViewResources/LeftPanelIcons/Order Button Clicked.png");
        orderOptionImage = new ResizeImage().resize(orderOptionImage, 30,28);
        orderOptionImageLabel = new JLabel(orderOptionImage);

        orderOptionText = new JLabel("Órden");
        orderOptionText.setForeground(new Color(236,90,90));
        orderOptionText.setFont(new Font("Arial", Font.BOLD, 12));
        orderOptionText.setHorizontalAlignment(SwingConstants.CENTER);
        orderOptionText.setBorder(BorderFactory.createEmptyBorder(10,0,0,0));

        orderOption.setBackground(Color.WHITE);
        orderOption.add(orderOptionImageLabel, BorderLayout.CENTER);
        orderOption.add(orderOptionText, BorderLayout.PAGE_END);

        gbcLeftPanel.gridy = 1;
        leftPanel.add(orderOption, gbcLeftPanel);

        //





        this.add(topPanel, BorderLayout.NORTH);
        this.add(leftPanel, BorderLayout.WEST);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setIconImage(companyIcon.getImage());
        this.setSize(1280,720);
        this.setVisible(true);
    }
    public static void main(String[] args) {
        new MainWindow();
    }
}
