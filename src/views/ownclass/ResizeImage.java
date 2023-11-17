package views.ownclass;

import javax.swing.*;
import java.awt.*;

public  class ResizeImage {

    public ImageIcon resize(ImageIcon img, int width, int height ){
        Image image = img.getImage();
        Image resizedImage = image.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        ImageIcon resizedIcon = new ImageIcon(resizedImage);
        return resizedIcon;
    }
}
