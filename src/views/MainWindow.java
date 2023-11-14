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

    //Center Panel Attributes-------------------------------------------------------------------------------------------

    private JPanel itemsPanel;
    private JPanel item;
    private ImageIcon itemImage;
    private JLabel itemImageLabel;
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
    private JLabel settingsOptionImageLabel;
    private JLabel settingsOptionText;

    public MainWindow() {
        //Top Panel Styling
        topPanel = new JPanel();
        GridBagConstraints gbcTopPanel = new GridBagConstraints();
        gbcTopPanel.insets = new Insets(5,17,5,70);
        topPanel.setLayout(new GridBagLayout());
        topPanel.setBackground(Color.WHITE);
        topPanel.setBorder(BorderFactory.createMatteBorder(0,0,1,0, new Color(236, 237, 237)));

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

        //Left Panel Styles---------------------------------------------------------------------------------------------

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

        homeOptionText = new JLabel("INICIO");
        homeOptionText.setForeground(new Color(189,189,189));
        homeOptionText.setFont(new Font("Arial", Font.BOLD, 12));
        homeOptionText.setHorizontalAlignment(SwingConstants.CENTER);
        homeOptionText.setBorder(BorderFactory.createEmptyBorder(10,0,0,0));

        homeOption.setBackground(Color.WHITE);
        homeOption.add(homeOptionImageLabel, BorderLayout.CENTER);
        homeOption.add(homeOptionText, BorderLayout.PAGE_END);
        homeOption.setBorder(BorderFactory.createEmptyBorder(0,0,80,0));

        gbcLeftPanel.gridy = 0;
        leftPanel.add(homeOption, gbcLeftPanel);

        //Order Button

        orderOption = new JPanel();
        orderOption.setLayout(new BorderLayout());

        orderOptionImage = new ImageIcon("src/resources/OrderViewResources/LeftPanelIcons/Order Button Clicked.png");
        orderOptionImage = new ResizeImage().resize(orderOptionImage, 30,28);
        orderOptionImageLabel = new JLabel(orderOptionImage);

        orderOptionText = new JLabel("ORDEN");
        orderOptionText.setForeground(new Color(236,90,90));
        orderOptionText.setFont(new Font("Arial", Font.BOLD, 12));
        orderOptionText.setHorizontalAlignment(SwingConstants.CENTER);
        orderOptionText.setBorder(BorderFactory.createEmptyBorder(10,0,0,0));

        orderOption.setBackground(Color.WHITE);
        orderOption.add(orderOptionImageLabel, BorderLayout.CENTER);
        orderOption.add(orderOptionText, BorderLayout.PAGE_END);
        orderOption.setBorder(BorderFactory.createEmptyBorder(0,0,80,0));

        gbcLeftPanel.gridy = 1;
        leftPanel.add(orderOption, gbcLeftPanel);

        //Order History Button

        orderHistoryOption = new JPanel();
        orderHistoryOption.setLayout(new BorderLayout());

        orderHistoryOptionImage = new ImageIcon("src/resources/OrderViewResources/LeftPanelIcons/OrderHistory Button Not Clicked.png");
        orderHistoryOptionImage = new ResizeImage().resize(orderHistoryOptionImage, 30,28);
        orderHistoryOptionImageLabel = new JLabel(orderHistoryOptionImage);

        orderHistoryOptionText = new JLabel("HISTORIAL");
        orderHistoryOptionText.setForeground(new Color(189,189,189));
        orderHistoryOptionText.setFont(new Font("Arial", Font.BOLD, 12));
        orderHistoryOptionText.setHorizontalAlignment(SwingConstants.CENTER);
        orderHistoryOptionText.setBorder(BorderFactory.createEmptyBorder(10,0,0,0));

        orderHistoryOption.setBackground(Color.WHITE);
        orderHistoryOption.add(orderHistoryOptionImageLabel, BorderLayout.CENTER);
        orderHistoryOption.add(orderHistoryOptionText, BorderLayout.PAGE_END);
        orderHistoryOption.setBorder(BorderFactory.createEmptyBorder(0,0,80,0));

        gbcLeftPanel.gridy = 2;
        leftPanel.add(orderHistoryOption, gbcLeftPanel);

        //Settings Button

        settingsOption = new JPanel();
        settingsOption.setLayout(new BorderLayout());

        settingsOptionImage = new ImageIcon("src/resources/OrderViewResources/LeftPanelIcons/Config Button Not Clicked.png");
        settingsOptionImage = new ResizeImage().resize(settingsOptionImage, 30,28);
        settingsOptionImageLabel = new JLabel(settingsOptionImage);

        settingsOptionText = new JLabel("CONFIG.");
        settingsOptionText.setForeground(new Color(189,189,189));
        settingsOptionText.setFont(new Font("Arial", Font.BOLD, 12));
        settingsOptionText.setHorizontalAlignment(SwingConstants.CENTER);
        settingsOptionText.setBorder(BorderFactory.createEmptyBorder(10,0,0,0));

        settingsOption.setBackground(Color.WHITE);
        settingsOption.add(settingsOptionImageLabel, BorderLayout.CENTER);
        settingsOption.add(settingsOptionText, BorderLayout.PAGE_END);

        gbcLeftPanel.gridy = 3;
        leftPanel.add(settingsOption, gbcLeftPanel);

        //Center Panel Styles-------------------------------------------------------------------------------------------











        this.add(topPanel, BorderLayout.NORTH);
        this.add(leftPanel, BorderLayout.WEST);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setIconImage(companyIcon.getImage());
        this.setSize(1280,720);
        this.setVisible(true);
    }


    private JPanel createItemPanel(String name, ImageIcon icon, String price) {
        JPanel itemPanel = new JPanel(new BorderLayout());
        itemPanel.setBorder(BorderFactory.createLineBorder(Color.GRAY)); // As an example

        JLabel itemImageLabel = new JLabel(icon);
        JLabel itemNameLabel = new JLabel(name);
        JLabel itemPriceLabel = new JLabel(price);

        itemPanel.add(itemImageLabel, BorderLayout.CENTER);
        itemPanel.add(itemNameLabel, BorderLayout.PAGE_START);
        itemPanel.add(itemPriceLabel, BorderLayout.PAGE_END);

        return itemPanel;
    }



    /**
    private void populateCenterPanel(JPanel centerPanel) {
        // Example list of hot dog items, you would get this from your data source
        List<HotDogItem> hotDogs = getHotDogItems(); // This is a hypothetical method to get your items

        for (HotDogItem hotDog : hotDogs) {
            ImageIcon icon = new ImageIcon(hotDog.getImagePath()); // Ensure this is the correct path to your image
            JPanel itemPanel = createItemPanel(hotDog.getName(), icon, hotDog.getPrice());
            centerPanel.add(itemPanel);
        }
    }
     */


    public static void main(String[] args) {
        new MainWindow();
    }
}
