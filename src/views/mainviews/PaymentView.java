package views.mainviews;

import model.Order;
import presenter.VerificationPresenter;
import views.panels.LeftPanel;
import views.panels.TopPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * Clase PaymentView para la vista de pago en una interfaz gráfica.
 * Combina paneles superiores, izquierdos y centrales para mostrar la información de pago.
 */

public class PaymentView extends JPanel {
    LeftPanel leftPanel;
    TopPanel topPanel;
    JPanel centerPanel;
    JLabel orderSummary;
    JTextArea dogItems;
    JTextArea dogPrices;
    JLabel dogItemLabel;
    JLabel singleDogPrice;
    JLabel subTotal;
    JLabel subTotalText;
    JLabel tax, total, taxText, totalTextl;
    JButton cancel, pay;

    // Componentes para mostrar detalles de la orden y realizar acciones como pagar o cancelar.
    // Implementación de constructores y métodos.

    /**
     * Constructor que inicializa los componentes de la vista de pago.
     *
     * @param ac ActionListener para manejar eventos.
     */



    public PaymentView(ActionListener ac) {
        initItems(ac);
    }

    /**
     * Inicializa el panel central con todos los componentes para la vista de pago.
     *
     * @param ac ActionListener para los eventos de los botones.
     */
    public void initCenterPanel(ActionListener ac) {
        centerPanel = new JPanel(new BorderLayout());
        centerPanel.setBackground(new Color(216, 230, 233));
        centerPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);



        dogItemLabel = new JLabel("ITEM");
        dogItemLabel.setFont(new Font("Arial", Font.BOLD, 25));
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.WEST;
        centerPanel.add(dogItemLabel, gbc);



        singleDogPrice = new JLabel("PRECIO");
        singleDogPrice.setFont(new Font("Arial", Font.BOLD, 25));
        gbc.gridy = 1;
        gbc.gridx = 2;
        centerPanel.add(singleDogPrice, gbc);


        orderSummary = new JLabel("DETALLES DE ÓRDEN");
        orderSummary.setFont(new Font("Arial", Font.BOLD, 25));
        orderSummary.setBorder(BorderFactory.createEmptyBorder(0,0,35,0));
        gbc.gridy = 0;
        gbc.gridx = 1;
        centerPanel.add(orderSummary, gbc);

        dogItems = new JTextArea();
        dogItems.setFont(new Font("Arial", Font.PLAIN, 19));
        dogItems.setBackground(new Color(216, 230, 233));
        dogItems.setSize(new Dimension(400, 300));

        gbc.gridy = 2;
        gbc.gridx = 0;
        centerPanel.add(dogItems, gbc);

        dogPrices = new JTextArea();
        dogPrices.setFont(new Font("Arial", Font.PLAIN, 19));
        dogPrices.setBackground(new Color(216, 230, 233));
        dogPrices.setSize(new Dimension(400, 300));

        gbc.gridy = 2;
        gbc.gridx = 2;
        gbc.anchor = GridBagConstraints.EAST;
        centerPanel.add(dogPrices, gbc);

        subTotalText = new JLabel("SUBTOTAL");
        subTotalText.setFont(new Font("Arial", Font.BOLD, 20));
        gbc.gridy = 3;
        gbc.gridx =0;
        gbc.anchor = GridBagConstraints.WEST;
        centerPanel.add(subTotalText, gbc);

        subTotal = new JLabel();
        subTotal.setFont(new Font("Arial", Font.BOLD, 20));
        gbc.gridy = 3;
        gbc.gridx =2;
        gbc.anchor = GridBagConstraints.EAST;
        centerPanel.add(subTotal, gbc);



        taxText = new JLabel("IMPUESTO");
        taxText.setFont(new Font("Arial", Font.BOLD, 20));
        taxText.setBackground(new Color(216, 230, 233));

        gbc.gridy = 4;
        gbc.gridx = 0;
        gbc.anchor = GridBagConstraints.WEST;
        centerPanel.add(taxText, gbc);

        tax = new JLabel();
        tax.setFont(new Font("Arial", Font.BOLD, 20));
        tax.setBackground(new Color(216, 230, 233));
        gbc.gridy = 4;
        gbc.gridx = 2;
        gbc.anchor = GridBagConstraints.EAST;
        centerPanel.add(tax, gbc);


        total = new JLabel();
        total.setFont(new Font("Arial", Font.BOLD, 20));
        total.setBackground(new Color(216, 230, 233));
        gbc.gridy = 5;
        gbc.gridx = 2;
        gbc.anchor = GridBagConstraints.EAST;
        centerPanel.add(total, gbc);


        totalTextl = new JLabel("TOTAL");
        totalTextl.setFont(new Font("Arial", Font.BOLD, 20));
        totalTextl.setBackground(new Color(216, 230, 233));
        gbc.gridy = 5;
        gbc.gridx = 0;
        gbc.anchor = GridBagConstraints.WEST;
        centerPanel.add(totalTextl, gbc);

        cancel = new JButton("CANCELAR");
        cancel.setSize(new Dimension(150, 58));
        cancel.setBackground(new Color(216, 230, 233));

        cancel.addActionListener(ac);

        gbc.gridy = 6;
        gbc.gridx = 0;
        gbc.anchor = GridBagConstraints.WEST;
        centerPanel.add(cancel, gbc);

        pay = new JButton("PAGAR");
        pay.setSize(new Dimension(150, 58));
        pay.setBackground(new Color(236, 90, 90));

        pay.addActionListener(ac);
        gbc.gridy = 6;
        gbc.gridx = 2;
        gbc.anchor = GridBagConstraints.WEST;
        centerPanel.add(pay, gbc);



    }


    public JLabel getTax() {
        return tax;
    }

    public JLabel getTotal() {
        return total;
    }

    public JLabel getSubTotal() {
        return subTotal;
    }

    public JTextArea getDogItems() {
        return dogItems;
    }


    public JTextArea getDogPrices() {
        return dogPrices;
    }

    // Métodos para obtener información de impuestos, totales y otros elementos.

    /**
     * Inicializa los componentes principales de la vista de pago.
     *
     * @param ac ActionListener para los eventos de los botones.
     */

    public void initItems(ActionListener ac) {
        initCenterPanel(ac);
        leftPanel = new LeftPanel(ac);
        topPanel = new TopPanel();

        this.setLayout(new BorderLayout());
        this.add(topPanel, BorderLayout.NORTH);
        this.add(leftPanel, BorderLayout.WEST);
        this.add(centerPanel, BorderLayout.CENTER);

        this.setSize(1400, 900);
        this.setVisible(true);
    }

    public void repaintPanel() {
        this.revalidate();
        this.repaint();
    }
}
