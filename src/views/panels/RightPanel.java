package views.panels;

import javax.swing.*;

public class RightPanel extends JPanel{
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
}
