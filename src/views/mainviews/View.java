package views.mainviews;


import presenter.VerificationPresenter;

import java.awt.BorderLayout;
import javax.swing.*;


public class View extends JFrame{
    private MainWindow panelMainWindow;
    private PaymentView paymentView;
    private ViewAdministrator panelInfoInventory;
    private Login panelLogin;
    private JPanel panel;
    private OrderView orderView;
    public View(VerificationPresenter ac) {
        this.setUpFrame();
        this.initComponents(ac);
    }
    public void notifyWarning(String mesagge) {
        JOptionPane jo = new JOptionPane();
        jo.showMessageDialog(null,mesagge,"",JOptionPane.ERROR_MESSAGE);
    }
    public void initComponents(VerificationPresenter ac) {
        addHeader(ac);
    }
    public void setUpFrame() {
        this.setTitle("Point of Sale Dogzilla HotDogs");
        this.setSize(1400,900);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
    public void createPanelInventoryAdm(VerificationPresenter ac) {
        setPanel();
        panelInfoInventory = new ViewAdministrator(ac);
        ac.cargarDatos();
        panelInfoInventory.revalidate();
        panelInfoInventory.repaint();
        panel.add(panelInfoInventory);
        panel.revalidate();
        panel.repaint();
        repaint();
    }
    public void createPanelMainWindow(VerificationPresenter ac) {
        setPanel();
        panelMainWindow = new MainWindow(ac);
        panel.add(panelMainWindow);
        panel.revalidate();
        panel.repaint();
        repaint();
    }

    public void createPaymentPanel(VerificationPresenter ac) {
        setPanel();
        paymentView = new PaymentView(ac);
        panel.add(paymentView);
        panel.revalidate();
        panel.repaint();
        repaint();
    }

    public void createOrderPanel(VerificationPresenter ac){
        setPanel();
        orderView = new OrderView(ac);
        panel.add(orderView);
        panel.setSize(1400,900);
        panel.revalidate();
        panel.repaint();
        repaint();
    }

    public void createPanelLogin(VerificationPresenter ac) {
        setPanel();
        panelLogin = new Login(ac);
        panel.add(panelLogin);
        panel.revalidate();
        panel.repaint();
        repaint();
    }

    private void addHeader(VerificationPresenter ac) {
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
        if (orderView != null) {
            orderView.setVisible(false);
            remove(orderView);
        }
        if (paymentView != null) {
            paymentView.setVisible(false);
            remove(paymentView);
        }
    }

    public PaymentView getPaymentView() {
        return paymentView;
    }

    public OrderView getOrderView() {
        return orderView;
    }

    public void updateEntirePanel(){
        this.repaint();
        this.revalidate();
    }

    public ViewAdministrator getPanelInfoInventory() {
        return panelInfoInventory;
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