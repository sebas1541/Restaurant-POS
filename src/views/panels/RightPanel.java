package views.panels;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class RightPanel extends JPanel{
    //Atributos Sub Panel Superior del Panel Derecho

    private JPanel topPanel;
    private JLabel orderLabel;
    private JLabel orderNumberLabel;
    private JLabel customerLabel;
    private JLabel customerNameLabel;

    //Atributos Sub Panel central del Panel Derecho - Resumen de Items

    private JPanel centerPanel;
    private JPanel itemSelectedPanel;
    private JLabel itemSummaryItemName;
    private JLabel ItemSummaryItemPrice;
    private JLabel quantityText;
    private JLabel quantityValue;


    private JPanel bottomPanel;
    private JLabel subtotal;

    private JLabel subtotalPrice;

    private JLabel tax;

    private JLabel taxPrice;

    private JLabel total;
    private JLabel totalPrice;
    private JButton cancel;
    private JButton confirm;


    public RightPanel(){
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5,5,5,5);

        topPanel = new JPanel(new GridBagLayout());
        topPanel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        topPanel.setBackground(Color.WHITE);

        orderLabel = new JLabel("ORDEN #");
        orderLabel.setFont(new Font("Arial", Font.BOLD, 20));
        orderLabel.setForeground(Color.BLACK);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        topPanel.add(orderLabel, gbc);

        orderNumberLabel = new JLabel("1234567");
        orderNumberLabel.setFont(new Font("Arial", Font.BOLD, 20));
        orderNumberLabel.setForeground(Color.BLACK);
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.EAST;
        topPanel.add(orderNumberLabel, gbc);

        customerLabel = new JLabel("CLIENTE:");
        customerLabel.setFont(new Font("Arial", Font.BOLD, 14));
        customerLabel.setForeground(Color.BLACK);
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.WEST;
        topPanel.add(customerLabel, gbc);

        customerNameLabel = new JLabel("SEBASTIAN CANON CASTELLANOS");
        customerNameLabel.setFont(new Font("Arial", Font.BOLD, 14));
        customerNameLabel.setForeground(new Color(236,90,90));
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.EAST;
        topPanel.add(customerNameLabel, gbc);
        //-------------------------------------------------------------------
        centerPanel = new JPanel(new GridLayout(4,0));
        centerPanel.setBackground(Color.WHITE);

        itemSelectedPanel = new JPanel();
        itemSelectedPanel.setBackground(new Color(216, 230, 233));
        itemSelectedPanel.setLayout(new GridBagLayout());

        itemSummaryItemName = new JLabel("CLASICO");
        itemSummaryItemName.setFont(new Font("Arial", Font.PLAIN, 17));
        gbc.gridx = 0;
        gbc.gridy  = 0;
        gbc.anchor = GridBagConstraints.WEST;
        itemSelectedPanel.add(itemSummaryItemName, gbc);


        ItemSummaryItemPrice = new JLabel("$12.500");
        ItemSummaryItemPrice.setFont(new Font("Arial", Font.BOLD, 26));
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.WEST;
        itemSelectedPanel.add(ItemSummaryItemPrice, gbc);


        quantityText = new JLabel("CANTIDAD");
        quantityText.setFont(new Font("Arial", Font.PLAIN, 17));
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.EAST;
        itemSelectedPanel.add(quantityText, gbc);



        quantityValue = new JLabel("2");
        quantityValue.setFont(new Font("Arial", Font.BOLD, 26));
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.CENTER;
        itemSelectedPanel.add(quantityValue, gbc);

        centerPanel.add(itemSelectedPanel);
        //---------------------------------------------------------------
        bottomPanel = new JPanel();
        bottomPanel.setBackground(Color.WHITE);
        bottomPanel.setLayout(new GridBagLayout());



        subtotal = new JLabel("SUBTOTAL");
        subtotal.setFont(new Font("Arial", Font.PLAIN, 17));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        bottomPanel.add(subtotal, gbc);



        subtotalPrice = new JLabel("$12500");
        subtotalPrice.setFont(new Font("Arial", Font.PLAIN, 17));
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.EAST;
        bottomPanel.add(subtotalPrice, gbc);



        tax = new JLabel("IMPUESTO AL CONSUMO 8%");
        tax.setFont(new Font("Arial", Font.PLAIN, 17));
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.WEST;
        bottomPanel.add(tax, gbc);


        taxPrice = new JLabel("$1320");
        taxPrice.setFont(new Font("Arial", Font.PLAIN, 17));
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.EAST;
        bottomPanel.add(taxPrice, gbc);


        total = new JLabel("TOTAL");
        total.setFont(new Font("Arial", Font.PLAIN, 26));
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.WEST;
        bottomPanel.add(total, gbc);


        totalPrice = new JLabel("13820");
        totalPrice.setFont(new Font("Arial", Font.PLAIN, 26));
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.EAST;
        bottomPanel.add(totalPrice, gbc);



        cancel = new JButton("CANCELAR");

        cancel.setPreferredSize(new Dimension(150, 58));
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.WEST;
        bottomPanel.add(cancel, gbc);



        confirm = new JButton("CONFIRMAR");

        confirm.setPreferredSize(new Dimension(150, 58));
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.EAST;
        bottomPanel.add(confirm, gbc);




        this.setBackground(Color.WHITE);
        this.setLayout(new BorderLayout());
        this.add(topPanel, BorderLayout.NORTH);
        this.add(centerPanel, BorderLayout.CENTER);
        this.add(bottomPanel, BorderLayout.SOUTH);
    }
}
