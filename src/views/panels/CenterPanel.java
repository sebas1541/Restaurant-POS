package views.panels;

import views.ownclass.ResizeImage;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionListener;

public class CenterPanel extends JPanel {
    private JPanel navigationPanel;
    private JButton hotDogButton, additiveButton, drinkButton, addButton;
    private JPanel itemsPanel;

    public CenterPanel(ActionListener ac) {
        setLayout(new BorderLayout());
        initializeNavigationPanel(ac);
        initItems(ac);
        add(navigationPanel, BorderLayout.SOUTH);
        add(itemsPanel, BorderLayout.NORTH);
    }

    private void initializeNavigationPanel(ActionListener ac) {
        navigationPanel = createPanelWithGridBag(new Color(216, 230, 233));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(20, 5, 20, 5);

        hotDogButton = createButton("PERROS", new Color(236, 90, 90), new Dimension(150, 58));
        additiveButton = createButton("ADITIVOS", null, new Dimension(150, 58));
        additiveButton.addActionListener(ac);
        drinkButton = createButton("BEBIDAS", null, new Dimension(150, 58));

        this.setBackground(Color.WHITE);
        this.setBorder(BorderFactory.createEmptyBorder(0,17,0,17));
        addToPanel(navigationPanel, hotDogButton, gbc, 0);
        addToPanel(navigationPanel, additiveButton, gbc, 1);
        addToPanel(navigationPanel, drinkButton, gbc, 2);
    }

    private void initItems(ActionListener ac) {
        itemsPanel = new JPanel(new GridLayout(0, 4, 15, 30));
        itemsPanel.setBackground(Color.WHITE);

        String[] hotDogs = {"CLASICO", "DOGZILLA", "MEXICANO", "COLOMBIANO", "HAWAIANO", "ITALIANO", "DESGRANADO"};
        String[] prices = {"$16.500", "$16.500", "$15.500", "$15.500", "$15.500", "$15.500", "$15.500"};
        String[] imagePaths = {"PerroClasico.png", "DogZilla.png", "Mexicano.png", "Colombiano.png", "Hawaiano.png", "Italiano.png", "Desgranado.png"};

        for (int i = 0; i < hotDogs.length; i++) {
            ImageIcon imageIcon = loadImageIcon("src/resources/HotDogPhotos/" + imagePaths[i], 203, 143);
            addHotDogItem(hotDogs[i], prices[i], imageIcon, ac);
        }

    }


    private ImageIcon loadImageIcon(String path, int width, int height) {
        ImageIcon imageIcon = new ImageIcon(path);
        return new ResizeImage().resize(imageIcon, width, height);
    }


    private void addHotDogItem(String name, String price, ImageIcon image , ActionListener ac) {
        JPanel item = new JPanel(new BorderLayout());
        JLabel itemImageLabel = new JLabel(image);
        itemImageLabel.setBackground(Color.WHITE);
        itemImageLabel.setHorizontalAlignment(JLabel.CENTER);

        JPanel itemInfoPanel = createItemInfoPanel(price);
        item.add(itemImageLabel, BorderLayout.NORTH);
        item.add(itemInfoPanel, BorderLayout.SOUTH);

        addButton = createButton(name, new Color(216, 230, 233), new Dimension(100, 50));
        addButton.addActionListener(ac);

        itemInfoPanel.add(addButton);

        itemsPanel.add(item);
    }



    private JPanel createItemInfoPanel(String price) {
        JPanel itemInfoPanel = createPanelWithGridBag(new Color(216, 230, 233));
        itemInfoPanel.setPreferredSize(new Dimension(120,120));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 15, 15, 5);


        JLabel itemPrice = createLabel(price, new Font("Arial", Font.PLAIN, 12));



        gbc.anchor = GridBagConstraints.WEST;
        gbc.gridy = 1;
        itemInfoPanel.add(itemPrice, gbc);

        gbc.gridx = 1;


        return itemInfoPanel;
    }

    private JButton createButton(String text, Color bgColor, Dimension size) {
        JButton button = new JButton(text);
        if (bgColor != null) {
            button.setBackground(bgColor);
        }
        button.setPreferredSize(size);
        return button;
    }

    private JLabel createLabel(String text, Font font) {
        JLabel label = new JLabel(text);
        label.setFont(font);
        return label;
    }

    private JPanel createPanelWithGridBag(Color backgroundColor) {
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBackground(backgroundColor);
        return panel;
    }

    private void addToPanel(JPanel panel, Component component, GridBagConstraints gbc, int gridx) {
        gbc.gridx = gridx;
        panel.add(component, gbc);
    }

    public JButton getAddButton() {
        return addButton;
    }

    public JButton getAdditiveButton() {
        return additiveButton;
    }
}