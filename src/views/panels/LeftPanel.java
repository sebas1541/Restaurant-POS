package views.panels;
import views.ownclass.ResizeImage;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * Clase LeftPanel para crear un panel izquierdo en una interfaz gráfica.
 * Incluye botones con texto e imágenes, y está diseñada para usar en un layout de GridBag.
 */

public class LeftPanel extends JPanel {
    private static final Color BUTTON_TEXT_COLOR = new Color(189, 189, 189);
    private static final Font BUTTON_FONT = new Font("Arial", Font.PLAIN, 12);
    private static final int IMAGE_WIDTH = 30;
    private static final int IMAGE_HEIGHT = 28;

    /**
     * Constructor que inicializa los componentes del panel izquierdo.
     *
     * @param ac ActionListener para manejar eventos de los botones.
     */

    public LeftPanel(ActionListener ac) {
        initComponents(ac);
    }

    /**
     * Crea un panel que contiene un botón con texto y una imagen.
     *
     * @param text Texto del botón.
     * @param imagePath Ruta de la imagen del botón.
     * @param textColor Color del texto del botón.
     * @param ac ActionListener para el evento del botón.
     * @return Un JPanel con un botón y una imagen.
     */

    private JPanel createButtonPanel(String text, String imagePath, Color textColor, ActionListener ac) {

        JPanel buttonPanel = new JPanel(new BorderLayout());
        ImageIcon icon = new ImageIcon(imagePath);
        icon = new ResizeImage().resize(icon, IMAGE_WIDTH, IMAGE_HEIGHT);
        JLabel imageLabel = new JLabel(icon);
        JButton textButton = new JButton(text);
        Cursor pointer = Cursor.getPredefinedCursor(Cursor.HAND_CURSOR);
        textButton.addActionListener(ac);
        textButton.setCursor(pointer);
        textButton.setForeground(textColor);
        textButton.setFont(BUTTON_FONT);
        textButton.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));

        buttonPanel.setBackground(Color.WHITE);
        buttonPanel.add(imageLabel, BorderLayout.CENTER);
        buttonPanel.add(textButton, BorderLayout.SOUTH);
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 80, 0));

        return buttonPanel;
    }

    /**
     * Añade un componente JPanel a este panel en una posición específica del GridBagLayout.
     *
     * @param panel Panel a añadir.
     * @param gbc Configuración de GridBagConstraints.
     * @param gridy Posición en el eje Y dentro del GridBagLayout.
     */

    private void add(JPanel panel, GridBagConstraints gbc, int gridy) {
        gbc.gridy = gridy;
        add(panel, gbc);
    }

    /**
     * Inicializa los componentes del panel izquierdo, como los botones.
     *
     * @param ac ActionListener para los eventos de los botones.
     */

    private void initComponents(ActionListener ac){
        this.setLayout(new GridBagLayout());
        setBackground(Color.WHITE);
        setPreferredSize(new Dimension(107, getHeight()));
        setBorder(BorderFactory.createMatteBorder(0, 0, 0, 1, new Color(236, 237, 237)));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 0, 10, 0);

        add(createButtonPanel("INICIO", "src/resources/orderview/Home Button Not Clicked.png", BUTTON_TEXT_COLOR, ac), gbc, 0);
        add(createButtonPanel("ORDEN", "src/resources/orderview/Order Button Clicked.png", new Color(236, 90, 90), ac), gbc, 1);
        add(createButtonPanel("ADMIN", "src/resources/orderview/OrderHistory Button Not Clicked.png", BUTTON_TEXT_COLOR, ac), gbc, 2);
    }
}
