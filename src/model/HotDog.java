package model;

import java.util.ArrayList;
import java.util.List;

public class HotDog {
    private String name;
    private int price;
    private List<Ingredient> ingredients;
    private String path;

    public HotDog(String name, int price, List<Ingredient> ingredients, String imgFilePath){
        this.name = name;
        this.price = price;
        ingredients = new ArrayList<Ingredient>();
        this.ingredients = ingredients;
        this.path = imgFilePath;
    }

    public HotDog (String name, ArrayList<Ingredient> iL, int price){
        this.name = name;
        this.ingredients  = new ArrayList<Ingredient>();
        this.ingredients = iL;
        this.price = price;
    }

    public HotDog(String name, List<Ingredient> ingredients, String imgFilePath, int price) {
        this.name = name;
        this.price = price;
        this.ingredients = ingredients;
        this.path = imgFilePath;
    }




    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public String getImgFilePath() {
        return path;
    }

    public void setImgFilePath(String path) {
        this.path = path;
    }

    @Override
    public String toString() {
        return "HotDog{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", ingredients=" + ingredients +
                ", imgFilePath='" + path + '\'' +
                '}';
    }
}