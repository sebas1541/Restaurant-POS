package views.panels;

import views.ownClasses.ResizeImage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TopPanel extends JPanel {
    private JLabel dateLabel;
    private ImageIcon companyIcon;
    private JLabel companyIconLabel;
    private JLabel companyIconLabelHeader;
    private JLabel date;

    public TopPanel(){
        this.initComponents();
    }

    public void initComponents(){
        //Top Panel Styling
        GridBagConstraints gbcTopPanel = new GridBagConstraints();
        gbcTopPanel.insets = new Insets(5,17,5,70);
        this.setLayout(new GridBagLayout());
        this.setBackground(Color.WHITE);
        this.setBorder(BorderFactory.createMatteBorder(0,0,1,0, new Color(236, 237, 237)));

        //Image Styling and Positioning
        //IconImage Resizing
        companyIcon = new ImageIcon("src/resources/Logos/logo-dogzilla-01.png");
        companyIcon = new ResizeImage().resize(companyIcon, 80,80);
        //Grid Bag Layout Properties
        companyIconLabelHeader = new JLabel(companyIcon);
        gbcTopPanel.gridx = 0;
        gbcTopPanel.gridy = 0;
        gbcTopPanel.anchor = GridBagConstraints.WEST;
        this.add(companyIconLabelHeader, gbcTopPanel);

        //Date Styles
        date = new JLabel();
        date.setFont(new Font("Arial", Font.PLAIN, 12));
        int delay = 1000;

        new Timer(delay, taskPerformer).start();

        gbcTopPanel.gridx = 1;
        gbcTopPanel.gridy = 0;
        gbcTopPanel.anchor = GridBagConstraints.EAST;
        gbcTopPanel.weightx = 1;
        this.add(date, gbcTopPanel);
    }

    private void updateDateTime(JLabel label) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd 'de' MMMM 'de' yyyy HH:mm:ss");
        String dateTimeString = LocalDateTime.now().format(formatter);
        label.setText(dateTimeString);

    }

    ActionListener taskPerformer = new ActionListener() {
        public void actionPerformed(ActionEvent evt) {
            updateDateTime(date);
        }
    };


}
