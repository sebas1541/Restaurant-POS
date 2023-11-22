package model;

import persistence.Persistence;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import java.util.ArrayList;

public class  Inventory {
    private ArrayList<Ingredient> ingredientList;

    public Inventory() {
        ingredientList = new ArrayList<>();
    }

    public void splitIngredients() {
        JsonArray jsonArray = new Persistence().readIngredientsFile();
        if (jsonArray != null) {
            for (JsonObject jsonObject : jsonArray.getValuesAs(JsonObject.class)) {
                String name = jsonObject.getString("name");
                int value = jsonObject.getInt("value");
                Ingredient ing = new Ingredient(name, value);
                addIngredients(ing);
            }
        }
    }

    public void addIngredients(Ingredient ingredient) {
        ingredientList.add(ingredient);
    }

    public void modifyQuantityIngredients(String nameIngredient, int quantity) {
        for (Ingredient ing : ingredientList) {
            if (ing.getName().equals(nameIngredient)) {
                ing.setQuantity(quantity);
            }
        }
    }

    @Override
    public String toString() {
        return "Inventory{" +
                "ingredientList=" + ingredientList +
                '}';
    }
    public void menu(int opt, int quantity){
        String nombreI="";

        switch (opt) {
            case 1:
                nombreI = "Pan";
                break;
            case 2:
                nombreI = "Salchicha";
                break;
            case 3:
                nombreI = "Cebolla";
                break;
            case 4:
                nombreI = "Tomate";
                break;
            case 5:
                nombreI = "Papas Cabello de Angel";
                break;
            case 6:
                nombreI = "Jalapenos";
                break;
            case 7:
                nombreI = "Tostacos";
                break;
            case 8:
                nombreI = "Pepinillos";
                break;
            case 9:
                nombreI = "Salsa de Tomate";
                break;
            case 10:
                nombreI = "Salsa BBQ";
                break;
            case 11:
                nombreI = "Salsa Rosada";
                break;
            case 12:
                nombreI = "Salsa de Pina";
                break;
            case 13:
                nombreI = "Mostaza";
                break;
            case 14:
                nombreI = "Salsa Tartara";
                break;
            case 15:
                nombreI = "Salsa Mayo Mostaza";
                break;
            case 16:
                nombreI = "Mayonesa";
                break;
            case 17:
                nombreI = "Huevo Codorniz";
                break;
            case 18:
                nombreI = "Pina";
                break;
            case 19:
                nombreI = "Maiz Tierno";
                break;
            case 20:
                nombreI = "Queso Derretido";
                break;
            case 21:
                nombreI = "Queso Chedar";
                break;
            case 22:
                nombreI = "Pollo";
                break;
            case 23:
                nombreI = "Tocineta";
                break;
            case 24:
                nombreI = "Chile con Carne";
                break;
            case 25:
                nombreI = "Pepperoni";
                break;
        }
        modifyQuantityIngredients(nombreI, quantity);
    }


    public String getIngredientName(int index) {
        if (index >= 0 && index < ingredientList.size()) {
            return ingredientList.get(index).getName();
        } else {
            return null;
        }
    }


    public int getIngredientQuantity(int index) {
        if (index >= 0 && index < ingredientList.size()) {
            return ingredientList.get(index).getQuantity();
        } else {
            return 0;
        }
    }


    public ArrayList<Ingredient> getIngredientList() {
        return ingredientList;
    }
    public ArrayList<Ingredient> getIngredientList2() {
        splitIngredients();
        return ingredientList;
    }
}