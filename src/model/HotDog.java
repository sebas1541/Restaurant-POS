package model;

import java.util.List;

public class HotDog {
    private String name;
    private double price;
    private List<Ingredient> ingredients;
    private String imgFilePath;

    public HotDog(String name, double price, List<Ingredient> ingredients, String imgFilePath){
        this.name = name;
        this.price = price;
        this.ingredients = ingredients;
        this.imgFilePath = imgFilePath;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public String getImgFilePath() {
        return imgFilePath;
    }

    public void setImgFilePath(String imgFilePath) {
        this.imgFilePath = imgFilePath;
    }

    @Override
    public String toString() {
        return "HotDog{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", ingredients=" + ingredients +
                ", imgFilePath='" + imgFilePath + '\'' +
                '}';
    }
}
