package views.mainviews;


import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionListener;

public class ViewAdministrator extends JPanel {
    private JTable jTable;
    private JLabel labelOptionToModify;
    private JTextField optionToModify;
    private JLabel quantityLabel;
    private JTextField quantity;
    private JButton modify;
    private JButton goBack;
    private JLabel title;
    private GridBagConstraints gbc;
    private JScrollPane scrollPane;
    public ViewAdministrator(ActionListener ac) {
        this.setBackground(Color.white);
        initComponents(ac);
    }
    public void initComponents(ActionListener ac) {
        this.setLayout(new GridBagLayout());
        gbc = new GridBagConstraints();
        createJLabelTitle();
        createJTable();
        createJButtonSend(ac);
        createJButtonReturn(ac);
        createJLabelOptionToModify();
        createOptionNumber();
        createNewQuantity();
        createJLabelQuantity();
    }
    public String quantity(){
        return quantity.getText();
    }
    public String optionModify(){
        return optionToModify.getText();
    }

    public void createJTable() {
        jTable = new JTable();
        scrollPane = new JScrollPane(jTable);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        jTable.setBackground(Color.white);
        jTable.setFont(new Font("century", Font.BOLD, 16));
        jTable.setPreferredSize(new Dimension(500,420));
        gbc.insets = new Insets(0,0,20,0);
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.CENTER;
        this.add(scrollPane, gbc);
    }
    public void updateTable(DefaultTableModel table){
        jTable.setModel(table);
    }
    public void createJLabelTitle() {
        title = new JLabel("Inventario");
        title.setFont(new Font("century", Font.BOLD, 24));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 3;
        gbc.insets = new Insets(20, 0, 20, 0);
        gbc.anchor = GridBagConstraints.CENTER;
        this.add(title, gbc);
    }
    public void createJLabelOptionToModify() {
        labelOptionToModify = new JLabel("Ingrese el numero del producto a modificar");
        labelOptionToModify.setFont(new Font("century", Font.BOLD, 16));
        labelOptionToModify.setPreferredSize(new Dimension(400,30));
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        gbc.insets = new Insets(0, 10, 30, 10);
        this.add(labelOptionToModify, gbc);
    }
    public void createOptionNumber() {
        optionToModify= new JTextField();
        optionToModify.setPreferredSize(new Dimension(200,30));
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        gbc.insets = new Insets(0, 10, 30, 10);
        this.add(optionToModify, gbc);;
    }
    public void createJLabelQuantity() {
        quantityLabel = new JLabel("Ingrese la cantidad");
        quantityLabel.setFont(new Font("century", Font.BOLD, 16));
        quantityLabel.setPreferredSize(new Dimension(250,30));
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 1;
        gbc.insets = new Insets(0, 10, 30, 10);
        this.add(quantityLabel, gbc);
    }
    public void createNewQuantity() {
        quantity = new JTextField();
        quantity.setPreferredSize(new Dimension(200,30));
        gbc.gridx = 1;
        gbc.gridy = 5;
        gbc.gridwidth = 1;
        gbc.insets = new Insets(0, 10, 30, 10);
        this.add(quantity, gbc);
    }
    public void createJButtonSend(ActionListener ac) {
        modify = new JButton("Modificar");    //Se inicializa el boton "Modificar", el cual permite cambiar la cantidad de un producto del inventario
        modify.setBackground(new Color(241,88,46));  //se le asigna un color de fondo
        modify.setPreferredSize(new Dimension(100,50));    //le asignamos un ancho y alto al boton
        modify.addActionListener(ac);  //Agregamos un Action Listener
        gbc.gridx = 1;  //Asignamos la posición en x de la ubicacion del boton, por medio de un GridBagConstrains
        gbc.gridy = 7;   //Asignamos la posición en x de la ubicacion del boton, por medio de un GridBagConstrains
        gbc.gridwidth = 3;
        gbc.insets = new Insets(0, 0, 30, 0);
        this.add(modify, gbc);
    }
    public void createJButtonReturn(ActionListener ac) {
        goBack = new JButton("Volver");
        goBack.setBackground(new Color(241,88,9));
        goBack.setPreferredSize(new Dimension(100,50));
        goBack.addActionListener(ac);
        gbc.gridx = 0;
        gbc.gridy = 7;
        gbc.gridwidth = 3;
        gbc.insets = new Insets(0, 0, 30, 0);
        this.add(goBack, gbc);
    }

    public JTable getjTable() {
        return jTable;
    }

    public JLabel getLabelOptionToModify() {
        return labelOptionToModify;
    }

    public JTextField getOptionToModify() {
        return optionToModify;
    }

    public JLabel getQuantityLabel() {
        return quantityLabel;
    }

    public JTextField getQuantity() {
        return quantity;
    }

    public JButton getModify() {
        return modify;
    }

    public JButton getGoBack() {
        return goBack;
    }

    public JLabel getTitle() {
        return title;
    }

    public GridBagConstraints getGbc() {
        return gbc;
    }

}