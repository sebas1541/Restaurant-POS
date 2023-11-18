package presenter;

import javax.swing.*;

public class HotDogDTO {
    private String name;
    private String price;
    private ImageIcon image;


    public HotDogDTO(String name, String price, ImageIcon image) {
        this.name = name;
        this.price = price;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public ImageIcon getImage() {
        return image;
    }

    public void setImage(ImageIcon image) {
        this.image = image;
    }
}
