package views.panels;
import views.ResizeImage;


import javax.swing.*;
import java.awt.*;

public class LeftPanel extends JPanel {
    private static final Color BUTTON_TEXT_COLOR = new Color(189, 189, 189);
    private static final Font BUTTON_FONT = new Font("Arial", Font.PLAIN, 12);
    private static final int IMAGE_WIDTH = 30;
    private static final int IMAGE_HEIGHT = 28;

    public LeftPanel() {
        initComponents();
    }

    private JPanel createButtonPanel(String text, String imagePath, Color textColor) {
        JPanel buttonPanel = new JPanel(new BorderLayout());
        ImageIcon icon = new ImageIcon(imagePath);
        icon = new ResizeImage().resize(icon, IMAGE_WIDTH, IMAGE_HEIGHT);
        JLabel imageLabel = new JLabel(icon);
        JLabel textLabel = new JLabel(text, SwingConstants.CENTER);
        textLabel.setForeground(textColor);
        textLabel.setFont(BUTTON_FONT);
        textLabel.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));

        buttonPanel.setBackground(Color.WHITE);
        buttonPanel.add(imageLabel, BorderLayout.CENTER);
        buttonPanel.add(textLabel, BorderLayout.PAGE_END);
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 80, 0));

        return buttonPanel;
    }

    private void add(JPanel panel, GridBagConstraints gbc, int gridy) {
        gbc.gridy = gridy;
        add(panel, gbc);
    }

    private void initComponents(){
        this.setLayout(new GridBagLayout());
        setBackground(Color.WHITE);
        setPreferredSize(new Dimension(107, getHeight()));
        setBorder(BorderFactory.createMatteBorder(0, 0, 0, 1, new Color(236, 237, 237)));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 0, 10, 0);

        add(createButtonPanel("INICIO", "src/resources/OrderViewResources/LeftPanelIcons/Home Button Not Clicked.png", BUTTON_TEXT_COLOR), gbc, 0);
        add(createButtonPanel("ORDEN", "src/resources/OrderViewResources/LeftPanelIcons/Order Button Clicked.png", new Color(236, 90, 90)), gbc, 1);
        add(createButtonPanel("HISTORIAL", "src/resources/OrderViewResources/LeftPanelIcons/OrderHistory Button Not Clicked.png", BUTTON_TEXT_COLOR), gbc, 2);
        add(createButtonPanel("CONFIG.", "src/resources/OrderViewResources/LeftPanelIcons/Config Button Not Clicked.png", BUTTON_TEXT_COLOR), gbc, 3);

    }
}
