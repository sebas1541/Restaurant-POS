package views.mainviews;
import presenter.OrderPresenter;
import views.panels.CenterPanel;
import views.panels.LeftPanel;
import views.panels.RightPanel;
import views.panels.TopPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class OrderView extends JPanel {

    private TopPanel topPanel;
    private LeftPanel leftPanel;
    private CenterPanel centerPanel;
    private ImageIcon companyIcon;

    private RightPanel rightPanel;
    private OrderPresenter orderPresenter;


    public OrderView(ActionListener ac) {
      this.initComponents(ac);
      this.orderPresenter = new OrderPresenter(this);
    }

    public void initComponents(ActionListener ac){
        companyIcon = new ImageIcon("src/resources/Logos/logo-dogzilla-01.png");
        topPanel = new TopPanel();
        leftPanel = new LeftPanel();
        centerPanel = new CenterPanel();
        rightPanel = new RightPanel();

        this.setLayout(new BorderLayout());

        this.add(topPanel, BorderLayout.NORTH);
        this.add(leftPanel, BorderLayout.WEST);
        this.add(centerPanel, BorderLayout.CENTER);
        this.add(rightPanel, BorderLayout.EAST);
       // this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //this.setIconImage(companyIcon.getImage());
        this.setSize(1400,900);
        this.setVisible(true);
    }


    public CenterPanel getCenterPanel() {
        return centerPanel;
    }



}
