package views.panels;

import views.ResizeImage;

import javax.swing.*;
import java.awt.*;

public class CenterPanel extends JPanel {
    private JPanel navigationPanel;
    private JButton hotDogButton, additiveButton, drinkButton;
    private JPanel itemsPanel;

    public CenterPanel() {
        setLayout(new BorderLayout());
        setBackground(Color.WHITE);  // Set the background color for the center panel

        createNavigationPanel();
        initItems();

        add(navigationPanel, BorderLayout.SOUTH);
        add(itemsPanel, BorderLayout.CENTER);
    }

    private void createNavigationPanel() {
        navigationPanel = new JPanel(new GridBagLayout());
        navigationPanel.setBackground(new Color(216, 230, 233));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(20, 5, 20, 5);

        hotDogButton = new JButton("PERROS");
        hotDogButton.setBackground(new Color(236, 90, 90));
        hotDogButton.setPreferredSize(new Dimension(150, 58));

        additiveButton = new JButton("ADITIVOS");
        additiveButton.setPreferredSize(new Dimension(150, 58));

        drinkButton = new JButton("BEBIDAS");
        drinkButton.setPreferredSize(new Dimension(150, 58));

        gbc.gridx = 0;
        navigationPanel.add(hotDogButton, gbc);

        gbc.gridx = 1;
        navigationPanel.add(additiveButton, gbc);

        gbc.gridx = 2;
        navigationPanel.add(drinkButton, gbc);
    }

    private void initItems() {
        itemsPanel = new JPanel(new BorderLayout()); // Or another suitable layout
        itemsPanel.setBackground(Color.WHITE);

        // Adding a sample item with image, name, and price
        ImageIcon itemImage = new ImageIcon("src/resources/HotDogPhotos/Clasico.png");
        // Resize image if necessary. Assuming ResizeImage.resize() is a valid method
        itemImage = new ResizeImage().resize(itemImage, 203, 143);

        JLabel itemImageLabel = new JLabel(itemImage);
        itemImageLabel.setHorizontalAlignment(JLabel.CENTER);

        JLabel itemName = new JLabel("CLÁSICO");
        itemName.setFont(new Font("Arial", Font.PLAIN, 12));

        JLabel itemPrice = new JLabel("10.500");
        itemPrice.setFont(new Font("Arial", Font.PLAIN, 12));

        JButton addButtonItem = new JButton("+");
        addButtonItem.setPreferredSize(new Dimension(30, 30));
        addButtonItem.setBackground(new Color(216, 230, 233));

        JPanel itemInfoPanel = new JPanel(new GridBagLayout());
        itemInfoPanel.setBackground(new Color(216, 230, 233));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.CENTER;
        itemInfoPanel.add(itemName, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.WEST;
        itemInfoPanel.add(itemPrice, gbc);

        gbc.gridx = 2;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.WEST;
        itemInfoPanel.add(addButtonItem, gbc);

        JPanel itemPanel = new JPanel(new BorderLayout());
        itemPanel.add(itemImageLabel, BorderLayout.NORTH);
        itemPanel.add(itemInfoPanel, BorderLayout.CENTER);

        itemsPanel.add(itemPanel, BorderLayout.NORTH); // Add the item panel to the itemsPanel
    }
}
