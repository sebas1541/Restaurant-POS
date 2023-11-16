package views.mainViews;


import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class View extends JFrame{
    private Login panelLogin;
    private ViewAdministrator panelInfoInventory;
    private LogInView panelLV;
    private JPanel panel;
    public View(ActionListener ac) {
        this.setUpFrame();
        this.initComponents(ac);
    }
    public void initComponents(ActionListener ac) {
        addHeader(ac);
        this.setVisible(true);
        createPanelLogin(ac);
        createPanelInventoryAdm(ac);
        createPanelLV(ac);
    }
    public void setUpFrame() {
        this.setTitle("Punto de venta");
        this.setSize(700,730);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());
        this.setLocationRelativeTo(null);
    }
    public void createPanelLogin(ActionListener ac) {
        setPanel();
        panelLogin = new Login(ac);
        panel.add(panelLogin);
        panel.revalidate();
        panel.repaint();
        repaint();
    }
    public void createPanelLV(ActionListener ac) {
        setPanel();
        panelLV = new LogInView(ac);
        panel.add(panelLV);
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
        panelLogin = new Login(ac);
        panel.add(panelLogin, BorderLayout.CENTER);
    }
    private void setPanel() {
        if (panelLogin != null) {
            panelLogin.setVisible(false);
            remove(panelLogin);
        }
        if (panelInfoInventory != null) {
            panelInfoInventory.setVisible(false);
            remove(panelInfoInventory);
        }
        if (panelLV != null) {
            panelLV.setVisible(false);
            remove(panelLV);
        }
    }
}
