package views.mainviews;

import views.panels.CenterPanel;
import views.panels.LeftPanel;
import views.panels.TopPanel;

import javax.swing.*;
import java.awt.*;

import java.awt.event.ActionListener;




/**
 * Clase OrderView para la vista principal de una orden en una interfaz gráfica.
 * Combina paneles superiores, izquierdos, centrales y derechos para mostrar la información de la orden.
 */

public class OrderView extends JPanel {



    private TopPanel topPanel;
    private LeftPanel leftPanel;
    private CenterPanel centerPanel;
    private ImageIcon companyIcon;
    private JPanel rightPanel;
    private JPanel rightTop, rightBottom, itemSelectedPanel;
    private JScrollPane rightCenter;
    private JLabel orderLabel, orderNumberLabel, customerLabel, customerNameLabel;
    private JLabel itemSummaryItemName, ItemSummaryItemPrice, quantityText, quantityValue;
    private JLabel subtotal, subtotalPrice, tax, taxPrice, total, totalPrice;
    private JPanel innerPanel;
    private JButton cancel, confirm;



    /**
     * Constructor que inicializa los componentes de la vista.
     *
     * @param ac ActionListener para manejar eventos.
     */

    public OrderView(ActionListener ac) {
        this.initComponents(ac);
    }

    /**
     * Inicializa el panel derecho con sus componentes y estilo.
     *
     * @param ac ActionListener para los eventos de los botones.
     */

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

    /**
     * Crea y configura el panel superior derecho.
     */

    private void createRightTopPanel() {
        rightTop = new JPanel(new GridBagLayout());
        rightTop.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        rightTop.setBackground(Color.WHITE);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        orderLabel = new JLabel("ORDEN");
        orderLabel.setFont(new Font("Arial", Font.BOLD, 20));
        orderLabel.setForeground(Color.BLACK);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        rightTop.add(orderLabel, gbc);


        customerLabel = new JLabel("CLIENTE");
        customerLabel.setFont(new Font("Arial", Font.BOLD, 14));
        customerLabel.setForeground(Color.BLACK);
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.WEST;
        rightTop.add(customerLabel, gbc);

        customerNameLabel = new JLabel("");
        customerNameLabel.setFont(new Font("Arial", Font.BOLD, 14));
        customerNameLabel.setForeground(new Color(236, 90, 90));
        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.EAST;
        rightTop.add(customerNameLabel, gbc);

        repaintPanel();
    }


    /**
     * Crea y configura el panel central derecho con un JScrollPane.
     */
    private void createRightCenterPanel() {
        innerPanel = new JPanel();
        innerPanel.setLayout(new BoxLayout(innerPanel, BoxLayout.Y_AXIS));
        innerPanel.setBackground(Color.WHITE);

        rightCenter = new JScrollPane(innerPanel);
        rightCenter.setBackground(Color.WHITE);

    }

    /**
     * Añade un item de hot dog al panel de pedidos.
     *
     * @param name Nombre del hot dog.
     * @param price Precio del hot dog.
     * @param quantity Cantidad del hot dog.
     */

    public void addHotdogItem(String name, String price, String quantity) {
        setupHotDogInfoPanel(innerPanel, name, price, quantity);
        repaintPanel();
    }


    /**
     * Configura un panel para mostrar la información de un hot dog en el pedido.
     *
     * @param panel Panel donde se añadirá la información del hot dog.
     * @param name Nombre del hot dog.
     * @param price Precio del hot dog.
     * @param quantity Cantidad del hot dog.
     */
    private void setupHotDogInfoPanel(JPanel panel, String name, String price, String quantity) {
        JPanel hotDogPanel = new JPanel(new GridBagLayout());
        hotDogPanel.setBackground(new Color(216, 230, 233));
        hotDogPanel.setBorder(BorderFactory.createMatteBorder(0,0,1,0,Color.GRAY));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        JLabel itemName = new JLabel(name);
        itemName.setFont(new Font("Arial", Font.PLAIN, 17));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        hotDogPanel.add(itemName, gbc);

        JLabel itemPrice = new JLabel(price);
        itemPrice.setFont(new Font("Arial", Font.BOLD, 26));
        gbc.gridy = 1;
        hotDogPanel.add(itemPrice, gbc);

        JLabel quantityText = new JLabel("CANTIDAD");
        quantityText.setFont(new Font("Arial", Font.PLAIN, 17));
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.EAST;
        hotDogPanel.add(quantityText, gbc);

        JLabel quantityValue = new JLabel(quantity);
        quantityValue.setFont(new Font("Arial", Font.BOLD, 26));
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.CENTER;
        hotDogPanel.add(quantityValue, gbc);

        panel.add(hotDogPanel);
    }


    /**
     * Repinta el panel para actualizar la visualización.
     */

    public void repaintPanel() {
        this.revalidate();
        this.repaint();
    }



    /**
     * Actualiza la información del panel derecho.
     *
     * @param X Información del precio total.
     * @param Y Información del impuesto.
     */
    public void updateRightPanel(Object X, Object Y){
        getTotalPrice().setText(String.valueOf(X));
        getTaxPrice().setText(String.valueOf(Y));
        repaintPanel();
    }

    public JLabel getTaxPrice() {
        return taxPrice;
    }


    private void createRightBottomPanel(ActionListener ac) {
        rightBottom = new JPanel(new GridBagLayout());
        rightBottom.setBackground(Color.WHITE);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);


        tax = new JLabel("IMPUESTO AL CONSUMO 8%");
        tax.setFont(new Font("Arial", Font.PLAIN, 17));
        gbc.gridx = 0;
        gbc.gridy = 1;
        rightBottom.add(tax, gbc);

        taxPrice = new JLabel("");
        taxPrice.setFont(new Font("Arial", Font.PLAIN, 17));
        gbc.gridx = 1;
        rightBottom.add(taxPrice, gbc);

        total = new JLabel("TOTAL");
        total.setFont(new Font("Arial", Font.PLAIN, 26));
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.WEST;
        rightBottom.add(total, gbc);

        totalPrice = new JLabel();
        totalPrice.setText("");
        totalPrice.setFont(new Font("Arial", Font.PLAIN, 26));
        totalPrice.setBorder(BorderFactory.createEmptyBorder(0,0,0,10));
        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.EAST;
        rightBottom.add(totalPrice, gbc);


        confirm = new JButton("CONFIRMAR");
        confirm.addActionListener(ac);
        confirm.setPreferredSize(new Dimension(150, 58));
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.EAST;
        rightBottom.add(confirm, gbc);
    }



    /**
     * Inicializa los componentes principales de la vista.
     *
     * @param ac ActionListener para los eventos de los botones.
     */


    public void initComponents(ActionListener ac){
        topPanel = new TopPanel();
        leftPanel = new LeftPanel(ac);
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