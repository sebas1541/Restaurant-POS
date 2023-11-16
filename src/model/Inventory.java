package model;

import persistence.Persistence;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import java.util.ArrayList;

public class Inventory {
    private ArrayList<Ingredient> ingredientList;

    public Inventory() {
        ingredientList = new ArrayList<>();
    }

    public void splitIngredients(Persistence persistence) {
        JsonArray jsonArray = persistence.readIngredientsFile();
        if (jsonArray != null) {
            for (JsonObject jsonObject : jsonArray.getValuesAs(JsonObject.class)) {
                String name = jsonObject.getString("name");
                int value = jsonObject.getInt("value");
                String price = null;
                Ingredient ing = new Ingredient(name, value);
                addIngredients(ing);
            }
        }
    }

    public void addIngredients(Ingredient ingredient) {
        ingredientList.add(ingredient);
    }

    public String getStringListIngredients() {
        StringBuilder output = new StringBuilder();
        for (Ingredient ing : ingredientList) {
            output.append(ing.toString()).append("\n");
        }
        return output.toString();
    }

    public void totalDatos() {
        System.out.println("Total en arreglo: " + ingredientList.size());
    }

    public void modifyQuantityIngredients(String nameIngredient, int quantity) {
        for (Ingredient ing : ingredientList) {
            if (ing.getName().equals(nameIngredient)) {
                ing.setQuantity(quantity);
            }
        }
    }
}
