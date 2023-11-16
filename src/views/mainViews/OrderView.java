package views.mainViews;
import model.HotDogManager;
import presenter.OrderPresenter;
import views.panels.CenterPanel;
import views.panels.LeftPanel;
import views.panels.RightPanel;
import views.panels.TopPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;


public class OrderView extends JFrame {

    private TopPanel topPanel;
    private LeftPanel leftPanel;
    private CenterPanel centerPanel;
    private ImageIcon companyIcon;

    private RightPanel rightPanel;
    private OrderPresenter orderPresenter;


    public OrderView() {
      this.initComponents();
        HotDogManager manager = new HotDogManager("Client Name");
        this.orderPresenter = new OrderPresenter(this, manager);
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


    public CenterPanel getCenterPanel() {
        return centerPanel;
    }

    public static void main(String[] args) {
        new OrderView();
    }


}
