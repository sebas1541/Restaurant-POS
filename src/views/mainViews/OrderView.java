package views.mainViews;
import views.panels.CenterPanel;
import views.panels.LeftPanel;
import views.panels.RightPanel;
import views.panels.TopPanel;

import javax.swing.*;
import java.awt.*;



public class OrderView extends JFrame {

    private TopPanel topPanel;
    private LeftPanel leftPanel;
    private CenterPanel centerPanel;
    private ImageIcon companyIcon;

    private RightPanel rightPanel;


    public OrderView() {
      this.initComponents();
    }

    public void initComponents(){
        companyIcon = new ImageIcon("src/resources/Logos/logo-dogzilla-01.png");
        topPanel = new TopPanel();
        leftPanel = new LeftPanel();
        centerPanel = new CenterPanel();
        rightPanel = new RightPanel();

        this.add(topPanel, BorderLayout.NORTH);
        this.add(leftPanel, BorderLayout.WEST);
        this.add(centerPanel, BorderLayout.CENTER);
        this.add(rightPanel, BorderLayout.EAST);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setIconImage(companyIcon.getImage());
        this.setSize(1280,850);
        this.setVisible(true);
    }


    public static void main(String[] args) {
        new OrderView();
    }
}
