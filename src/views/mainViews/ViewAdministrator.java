package views.mainViews;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class ViewAdministrator extends JPanel {
    private JTextArea modifyMenu;
    private JLabel labelOptionToModify;
    private JTextField optionToModify;
    private JLabel quantityLabel;
    private JTextField quantity;
    private JButton modify;
    private JLabel title;
    private GridBagConstraints gbc;

    public ViewAdministrator(ActionListener ac) {
        this.setBackground(Color.white);
        initComponents(ac);
    }
    public void initComponents(ActionListener ac) {
        this.setLayout(new GridBagLayout());
        gbc = new GridBagConstraints();
        createJLabelTitle();
        createJTextAreaModifyMenu();
        createJButtonSend(ac);
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

    public void createJTextAreaModifyMenu() {
        modifyMenu = new JTextArea(menuOptions());
        modifyMenu.setBackground(Color.white);
        modifyMenu.setEditable(false);
        modifyMenu.setFont(new Font("century", Font.BOLD, 16));
        modifyMenu.setPreferredSize(new Dimension(500,300));
        gbc.insets = new Insets(0,0,20,0);
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.CENTER;
        this.add(modifyMenu, gbc);
    }
    public String menuOptions(){
        return"\n1. Pan                                             2. Salchicha\n"+
                "3. Cebolla                                       4. Tomate\n"+
                "5. Papas Cabello de Angel             6. Jalapenos\n"+
                "7. Tostacos                                     8. Pepinillos\n"+
                "9. Salsa de Tomate                      10. Salsa BBQ\n"+
                "11. Salsa Rosada                         12. Salsa de Pina\n"+
                "13. Mostaza                                 14. Salsa Tartara\n"+
                "15. Salsa Mayo Mostaza             16. Mayonesa\n"+
                "17. Huevo Codorniz                     18. Pina\n"+
                "19. Maiz Tierno                           20. Queso Derretido\n"+
                "21. Queso Chedar                        22. Pollo\n"+
                "23. Tocineta                                 24. Chile con Carne\n"+
                "25. Pepperoni                               26. Terminar modificaciones \n";
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
        modify = new JButton("Modificar");
        modify.setBackground(new Color(241,88,46));
        modify.setPreferredSize(new Dimension(100,50));
        modify.addActionListener(ac);
        gbc.gridx = 1;
        gbc.gridy = 7;
        gbc.gridwidth = 3;
        gbc.insets = new Insets(0, 0, 30, 0);
        this.add(modify, gbc);
    }

}