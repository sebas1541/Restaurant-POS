package views.mainviews;

import views.panels.CenterPanel;
import views.panels.LeftPanel;
import views.panels.TopPanel;

import javax.swing.*;
import java.awt.*;

import java.awt.event.ActionListener;


public class OrderView extends JPanel {



    private TopPanel topPanel;
    private LeftPanel leftPanel;
    private CenterPanel centerPanel;
    private ImageIcon companyIcon;
    private JPanel rightPanel;
    private JPanel rightTop, rightCenter, rightBottom, itemSelectedPanel;
    private JLabel orderLabel, orderNumberLabel, customerLabel, customerNameLabel;
    private JLabel itemSummaryItemName, ItemSummaryItemPrice, quantityText, quantityValue;
    private JLabel subtotal, subtotalPrice, tax, taxPrice, total, totalPrice;
    private JButton cancel, confirm;



    public OrderView(ActionListener ac) {
        this.initComponents(ac);
    }



    private void initRight(ActionListener ac) {
        setLayout(new BorderLayout());
        setBackground(Color.WHITE);

        createRightTopPanel();
        createRightCenterPanel();
        createRightBottomPanel(ac);

        rightPanel.add(rightTop, BorderLayout.NORTH);
        rightPanel.add(rightCenter, BorderLayout.CENTER);
        rightPanel.add(rightBottom, BorderLayout.SOUTH);

        repaint();
    }

    private void createRightTopPanel() {
        rightTop = new JPanel(new GridBagLayout());
        rightTop.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        rightTop.setBackground(Color.WHITE);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        orderLabel = new JLabel("ORDEN #");
        orderLabel.setFont(new Font("Arial", Font.BOLD, 20));
        orderLabel.setForeground(Color.BLACK);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        rightTop.add(orderLabel, gbc);

        orderNumberLabel = new JLabel("1234567");
        orderNumberLabel.setFont(new Font("Arial", Font.BOLD, 20));
        orderNumberLabel.setForeground(Color.BLACK);
        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.EAST;
        rightTop.add(orderNumberLabel, gbc);

        customerLabel = new JLabel("CLIENTE:");
        customerLabel.setFont(new Font("Arial", Font.BOLD, 14));
        customerLabel.setForeground(Color.BLACK);
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.WEST;
        rightTop.add(customerLabel, gbc);

        customerNameLabel = new JLabel("SEBASTIAN CANON CASTELLANOS");
        customerNameLabel.setFont(new Font("Arial", Font.BOLD, 14));
        customerNameLabel.setForeground(new Color(236, 90, 90));
        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.EAST;
        rightTop.add(customerNameLabel, gbc);

        repaint();
    }

    private void createRightCenterPanel() {
        rightCenter = new JPanel(new GridLayout(4, 0));
        rightCenter.setBackground(Color.WHITE);

        itemSelectedPanel = new JPanel(new GridBagLayout());
        itemSelectedPanel.setBackground(new Color(216, 230, 233));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        itemSummaryItemName = new JLabel("CLASICO");
        itemSummaryItemName.setFont(new Font("Arial", Font.PLAIN, 17));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        itemSelectedPanel.add(itemSummaryItemName, gbc);

        ItemSummaryItemPrice = new JLabel("$12.500");
        ItemSummaryItemPrice.setFont(new Font("Arial", Font.BOLD, 26));
        gbc.gridy = 1;
        itemSelectedPanel.add(ItemSummaryItemPrice, gbc);

        quantityText = new JLabel("CANTIDAD");
        quantityText.setFont(new Font("Arial", Font.PLAIN, 17));
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.EAST;
        itemSelectedPanel.add(quantityText, gbc);

        quantityValue = new JLabel("2");
        quantityValue.setFont(new Font("Arial", Font.BOLD, 26));
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.CENTER;
        itemSelectedPanel.add(quantityValue, gbc);

        rightCenter.add(itemSelectedPanel);

        repaint();
    }

    public void repaintPanel() {
        this.revalidate();
        this.repaint();
    }


    public void updateRightPanel(Object T){
        System.out.println("Is EDT: " + SwingUtilities.isEventDispatchThread());
        getTotalPrice().setText(String.valueOf(T));
        remove(totalPrice);
        repaintPanel();
    }


    private void createRightBottomPanel(ActionListener ac) {
        rightBottom = new JPanel(new GridBagLayout());
        rightBottom.setBackground(Color.WHITE);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        subtotal = new JLabel("SUBTOTAL");
        subtotal.setFont(new Font("Arial", Font.PLAIN, 17));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        rightBottom.add(subtotal, gbc);

        subtotalPrice = new JLabel("$12500");
        subtotalPrice.setFont(new Font("Arial", Font.PLAIN, 17));
        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.EAST;
        rightBottom.add(subtotalPrice, gbc);

        tax = new JLabel("IMPUESTO AL CONSUMO 8%");
        tax.setFont(new Font("Arial", Font.PLAIN, 17));
        gbc.gridx = 0;
        gbc.gridy = 1;
        rightBottom.add(tax, gbc);

        taxPrice = new JLabel("$1320");
        taxPrice.setFont(new Font("Arial", Font.PLAIN, 17));
        gbc.gridx = 1;
        rightBottom.add(taxPrice, gbc);

        total = new JLabel("TOTAL");
        total.setFont(new Font("Arial", Font.PLAIN, 26));
        gbc.gridx = 0;
        gbc.gridy = 2;
        rightBottom.add(total, gbc);

        totalPrice = new JLabel();
        totalPrice.setText("a");
        totalPrice.setFont(new Font("Arial", Font.PLAIN, 26));
        gbc.gridx = 1;
        rightBottom.add(totalPrice, gbc);

        cancel = new JButton("CANCELAR");
        cancel.addActionListener(ac);
        cancel.setPreferredSize(new Dimension(150, 58));
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.WEST;
        rightBottom.add(cancel, gbc);

        confirm = new JButton("CONFIRMAR");
        confirm.addActionListener(ac);
        confirm.setPreferredSize(new Dimension(150, 58));
        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.EAST;
        rightBottom.add(confirm, gbc);
    }






    public void initComponents(ActionListener ac){
        topPanel = new TopPanel();
        leftPanel = new LeftPanel();
        centerPanel = new CenterPanel(ac);
        rightPanel = new JPanel(new BorderLayout());
        initRight(ac);
        this.setLayout(new BorderLayout());

        this.add(topPanel, BorderLayout.NORTH);
        this.add(leftPanel, BorderLayout.WEST);
        this.add(centerPanel, BorderLayout.CENTER);
        this.add(rightPanel, BorderLayout.EAST);

        this.setSize(1400,900);
        this.setVisible(true);
    }


    public CenterPanel getCenterPanel() {
        return centerPanel;
    }


    public JLabel getItemSummaryItemName() {
        return itemSummaryItemName;
    }

    public JLabel getTotalPrice() {
        return totalPrice;
    }





}