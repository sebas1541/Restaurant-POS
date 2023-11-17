package views.mainviews;

import views.panels.LeftPanel;
import views.panels.TopPanel;

import javax.swing.*;
import java.awt.*;

public class PaymentView extends JFrame {
    LeftPanel leftPanel;
    TopPanel topPanel;

    public PaymentView(){
        leftPanel = new LeftPanel();
        topPanel = new TopPanel();

        this.add(topPanel, BorderLayout.NORTH);
        this.add(leftPanel, BorderLayout.WEST);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1400,900);
        this.setVisible(true);


    }

    public static void main(String[] args) {
        new PaymentView();
    }
}
