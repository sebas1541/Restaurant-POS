package model;

import java.util.ArrayList;
import java.util.List;

public class HotDog {
    private String name;
    private int price;
    private List<Ingredient> ingredients;
    private String imgFilePath;

    public HotDog(String name, int price, List<Ingredient> ingredients, String imgFilePath){
        this.name = name;
        this.price = price;
        ingredients = new ArrayList<Ingredient>();
        this.ingredients = ingredients;
        this.imgFilePath = imgFilePath;
    }

    public HotDog (String name, ArrayList<Ingredient> iL, int price){
        this.name = name;
        this.ingredients  = new ArrayList<Ingredient>();
        this.ingredients = iL;
        this.price = price;
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
        return imgFilePath;
    }

    public void setImgFilePath(String imgFilePath) {
        this.imgFilePath = imgFilePath;
    }

    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("Nombre del HotDog: ").append(name).append("\nIngredientes:\n");
        for (Ingredient ingredient : ingredients) {
            result.append(" - ").append(ingredient.getName()).append(": ").append(ingredient.getQuantity()).append("\n");
        }
        result.append("\nSu precio es: ").append(price);

        return result.toString();
    }
}