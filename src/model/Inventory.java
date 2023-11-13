package model;

import persistence.Persistence;

import java.util.ArrayList;

public class Inventory {
    private ArrayList<Ingredient> ingredientList;

    public Inventory() {
        ingredientList = new ArrayList<>();
    }

    // Use Dependency Injection for better flexibility
    public void splitIngredients(Persistence persistence) {
        String file = persistence.readIngredientsFile();
        String[] lineIng = file.split("\n");
        for (String data : lineIng) {
            String[] ingredientsData = data.split(",");
            Ingredient ing = new Ingredient(ingredientsData[0], Integer.parseInt(ingredientsData[1]));
            addIngredients(ing);
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
