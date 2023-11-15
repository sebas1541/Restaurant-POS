package views;

import views.panels.CenterPanel;
import views.panels.LeftPanel;
import views.panels.TopPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class OrderView extends JFrame {


    private TopPanel topPanel;
    private LeftPanel leftPanel;
    private CenterPanel centerPanel;



    private ImageIcon companyIcon;


    //Atributos de la navegación inferior
    private JPanel navigationPanelBottom;
    private JButton hotDogButton;
    private JButton additiveButton;
    private JButton drinkBUtton;




    //Center Top Panel Attributes-------------------------------------------------------------------------------------------

    private JPanel itemsPanel;
    private JPanel item;
    private ImageIcon itemImage;
    private JLabel itemImageLabel;
    private JPanel itemInfoPanel;
    private JLabel itemName;
    private JLabel itemPrice;
    private JButton addButtonItem;
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






    public OrderView() {
        companyIcon = new ImageIcon("src/resources/Logos/logo-dogzilla-01.png");
        topPanel = new TopPanel();
        leftPanel = new LeftPanel();
        centerPanel = new CenterPanel();




        //Center Panel Styles-------------------------------------------------------------------------------------------

        centerPanel.setLayout(new BorderLayout());

        //Center Bottom Panel Styles-------------------------------------------------------------------------------------------

        navigationPanelBottom = new JPanel();


        navigationPanelBottom.setBackground(new Color(216,230,233));

        GridBagConstraints gbcBottomPanel = new GridBagConstraints();
        gbcBottomPanel.insets = new Insets(20,5,20,5);

        navigationPanelBottom.setLayout(new GridBagLayout());
        hotDogButton = new JButton("PERROS");
        hotDogButton.setBackground(new Color(236,90,90));

        hotDogButton.setPreferredSize(new Dimension(150,58));
        additiveButton = new JButton("ADITIVOS");
        additiveButton.setPreferredSize(new Dimension(150,58));
        drinkBUtton = new JButton("BEBIDAS");
        drinkBUtton.setPreferredSize(new Dimension(150,58));

        gbcBottomPanel.gridx = 0;
        navigationPanelBottom.add(hotDogButton, gbcBottomPanel);

        gbcBottomPanel.gridx = 1;
        navigationPanelBottom.add(additiveButton, gbcBottomPanel);

        gbcBottomPanel.gridx = 2;
        navigationPanelBottom.add(drinkBUtton, gbcBottomPanel);
        centerPanel.add(navigationPanelBottom, BorderLayout.SOUTH);

        //Center Panel of Center Panel

        GridBagConstraints gbcOfItemPanel = new GridBagConstraints();
        gbcOfItemPanel.insets = new Insets(5,5,5,5);
        gbcOfItemPanel.fill = GridBagConstraints.HORIZONTAL;

        itemsPanel = new JPanel();
        item = new JPanel();

        itemImage = new ImageIcon("src/resources/HotDogPhotos/Clasico.png");
        itemImage = new ResizeImage().resize(itemImage, 203,143);
        itemImageLabel = new JLabel(itemImage);
        itemImageLabel.setHorizontalAlignment(JLabel.CENTER);

        itemName = new JLabel("CLÁSICO");
        itemName.setFont(new Font("Arial", Font.PLAIN,12));
        itemPrice = new JLabel("10.500");
        itemPrice.setFont(new Font("Arial", Font.PLAIN,12));
        addButtonItem = new JButton("+");
        addButtonItem.setPreferredSize(new Dimension(30,30));
        addButtonItem.setBackground(new Color(216, 230, 233));

        scrollPane = new ScrollPane();

        itemInfoPanel = new JPanel();
        itemInfoPanel.setLayout(new GridBagLayout());
        itemInfoPanel.setBackground(new Color(216, 230, 233));

        gbcOfItemPanel.gridx = 1;
        gbcOfItemPanel.gridy = 0;
        gbcOfItemPanel.anchor = GridBagConstraints.CENTER;
        itemInfoPanel.add(itemName, gbcOfItemPanel);

        gbcOfItemPanel.gridx = 0;
        gbcOfItemPanel.gridy = 1;
        gbcOfItemPanel.anchor = GridBagConstraints.WEST;
        itemInfoPanel.add(itemPrice, gbcOfItemPanel);

        gbcOfItemPanel.gridx = 2;
        gbcOfItemPanel.gridy = 1;
        gbcOfItemPanel.anchor = GridBagConstraints.WEST;
        itemInfoPanel.add(addButtonItem, gbcOfItemPanel);

        item.setLayout(new BorderLayout());


        item.add(itemImageLabel, BorderLayout.NORTH);
        item.add(itemInfoPanel, BorderLayout.CENTER);


        itemsPanel.add(item, BorderLayout.NORTH);
        itemsPanel.setBackground(Color.WHITE);
        centerPanel.add(itemsPanel, BorderLayout.NORTH);

        this.add(topPanel, BorderLayout.NORTH);
        this.add(leftPanel, BorderLayout.WEST);
        this.add(centerPanel, BorderLayout.CENTER);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setIconImage(companyIcon.getImage());
        this.setSize(1280,850);
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

    private void updateDateTime(JLabel label) {
        // Use DateTimeFormatter to format the date and time as you like
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd 'de' MMMM 'de' yyyy HH:mm:ss");
        // Get the current date and time
        String dateTimeString = LocalDateTime.now().format(formatter);
        // Update the JLabel
        label.setText(dateTimeString);
    }


    /**
     private void populateCenterPanel(JPanel centerPanel) {
     // Example list of hot dog items, you would get this from your data source
     List<HotDog> hotDogs = getHotDogItems(); // This is a hypothetical method to get your items

     for (HotDogItem hotDog : hotDogs) {
     ImageIcon icon = new ImageIcon(hotDog.getImagePath()); // Ensure this is the correct path to your image
     JPanel itemPanel = createItemPanel(hotDog.getName(), icon, hotDog.getPrice());
     centerPanel.add(itemPanel);
     }
     }
     */


    public static void main(String[] args) {
        new OrderView();
    }
}
