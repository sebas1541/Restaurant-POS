package views.mainviews;

import views.panels.LeftPanel;
import views.panels.TopPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class PaymentView extends JPanel {
    LeftPanel leftPanel;
    TopPanel topPanel;

    public PaymentView(ActionListener ac){



        //leftPanel = new LeftPanel();
        //topPanel = new TopPanel();

        this.setLayout(new BorderLayout());
        //this.add(topPanel, BorderLayout.NORTH);
        //this.add(leftPanel, BorderLayout.WEST);



        this.setSize(1400,900);
        this.setVisible(true);


    }

}
