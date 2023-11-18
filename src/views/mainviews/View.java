package views.mainviews;


import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import javax.swing.*;


public class View extends JFrame{
    private MainWindow panelMainWindow;
    private ViewAdministrator panelInfoInventory;
    private Login panelLogin;
    private JPanel panel;
    private OrderView orderView;
    public View(ActionListener ac) {
        this.setUpFrame();
        this.initComponents(ac);
    }
    public void notifyWarning(String mesagge) {
        JOptionPane jo = new JOptionPane();
        jo.showMessageDialog(null,mesagge,"",JOptionPane.ERROR_MESSAGE);
    }
    public void initComponents(ActionListener ac) {
        addHeader(ac);
    }
    public void setUpFrame() {
        this.setTitle("Punto de venta");
        this.setSize(1400,900);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    public void createPanelMainWindow(ActionListener ac) {
        setPanel();
        panelMainWindow = new MainWindow(ac);
        panel.add(panelMainWindow);
        panel.revalidate();
        panel.repaint();
        repaint();
    }

    public void createOrderPanel(ActionListener ac){
        setPanel();
        orderView = new OrderView(ac);
        panel.add(orderView);
        panel.setSize(1400,900);
        panel.revalidate();
        panel.repaint();
        repaint();
    }

    public void createPanelLogin(ActionListener ac) {
        setPanel();
        panelLogin = new Login(ac);
        panel.add(panelLogin);
        panel.revalidate();
        panel.repaint();
        repaint();
    }

    public void createPanelInventoryAdm(ActionListener ac) {
        setPanel();
        panelInfoInventory = new ViewAdministrator(ac);
        panel.add(panelInfoInventory);
        panel.revalidate();
        panel.repaint();
        repaint();
    }

    private void addHeader(ActionListener ac) {
        panel = new JPanel();
        panel.setLayout(new BorderLayout());
        this.getContentPane().add(panel, BorderLayout.CENTER);
        panelMainWindow = new MainWindow(ac);
        panel.add(panelMainWindow, BorderLayout.CENTER);
    }
    private void setPanel() {
        if (panelMainWindow != null) {
            panelMainWindow.setVisible(false);
            remove(panelMainWindow);
        }
        if (panelInfoInventory != null) {
            panelInfoInventory.setVisible(false);
            remove(panelInfoInventory);
        }
        if (panelLogin != null) {
            panelLogin.setVisible(false);
            remove(panelLogin);
        }
    }
    public String user(){
        return panelLogin.user();
    }
    public String password(){
        return panelLogin.password();
    }
    public String quantity(){
        return panelInfoInventory.quantity();
    }
    public String optionModify(){
        return panelInfoInventory.optionModify();
    }
}