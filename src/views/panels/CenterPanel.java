package views.panels;

import views.ownClasses.ResizeImage;

import javax.swing.*;
import java.awt.*;

public class CenterPanel extends JPanel {
    private JPanel navigationPanel;
    private JButton hotDogButton, additiveButton, drinkButton;
    private JPanel itemsPanel;

    public CenterPanel() {
        setLayout(new BorderLayout());
        initializeNavigationPanel();
        initializeItemsPanel();

        add(navigationPanel, BorderLayout.SOUTH);
        add(itemsPanel, BorderLayout.NORTH);
    }

    private void initializeNavigationPanel() {
        navigationPanel = createPanelWithGridBag(new Color(216, 230, 233));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(20, 5, 20, 5);

        hotDogButton = createButton("PERROS", new Color(236, 90, 90), new Dimension(150, 58));
        additiveButton = createButton("ADITIVOS", null, new Dimension(150, 58));
        drinkButton = createButton("BEBIDAS", null, new Dimension(150, 58));

        addToPanel(navigationPanel, hotDogButton, gbc, 0);
        addToPanel(navigationPanel, additiveButton, gbc, 1);
        addToPanel(navigationPanel, drinkButton, gbc, 2);
    }

    private void initializeItemsPanel() {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        itemsPanel = new JPanel();
        itemsPanel.setBackground(Color.WHITE);

        ImageIcon itemImage = new ImageIcon("src/resources/HotDogPhotos/PerroClasico.png");
        itemImage = new ResizeImage().resize(itemImage, 203, 143);

        addHotDogItem("CLÁSICO", "10.500", itemImage);
    }

    private void addHotDogItem(String name, String price, ImageIcon image) {
        JPanel item = new JPanel(new BorderLayout());
        JLabel itemImageLabel = new JLabel(image);
        itemImageLabel.setHorizontalAlignment(JLabel.CENTER);

        JPanel itemInfoPanel = createItemInfoPanel(name, price);
        item.add(itemImageLabel, BorderLayout.NORTH);
        item.add(itemInfoPanel, BorderLayout.SOUTH);

        itemsPanel.add(item);
    }

    private JPanel createItemInfoPanel(String name, String price) {
        JPanel itemInfoPanel = createPanelWithGridBag(new Color(216, 230, 233));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        JLabel itemName = createLabel(name, new Font("Arial", Font.PLAIN, 12));
        JLabel itemPrice = createLabel(price, new Font("Arial", Font.PLAIN, 12));
        JButton addButton = createButton("+", new Color(216, 230, 233), new Dimension(30, 30));

        gbc.anchor = GridBagConstraints.CENTER;
        itemInfoPanel.add(itemName, gbc);

        gbc.anchor = GridBagConstraints.WEST;
        gbc.gridy = 1;
        itemInfoPanel.add(itemPrice, gbc);

        gbc.gridx = 1;
        itemInfoPanel.add(addButton, gbc);

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
}