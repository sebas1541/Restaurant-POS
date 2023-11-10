
package model;

import persistence.Persistence;

import java.util.ArrayList;

public class Inventory {
    private Ingredient ingredient;


    private ArrayList<Ingredient> ingredientList;

    public Inventory() {
        ingredientList = new ArrayList<Ingredient>();
        ingredient = new Ingredient();
    }
    public void addIngredients(Ingredient ingredient){
        ingredientList.add(ingredient);
    }


    public void splitIngredients() {
        Persistence pr = new Persistence();
        String file = "";
        file=pr.readIngredientsFile();
        String[] lineIng = file.split("\n");
        for (String data : lineIng) {
            String []ingredientsData = data.split(",");
            Ingredient ing=new Ingredient(ingredientsData[0],Integer.parseInt(ingredientsData[1]));
            addIngredients(ing);
        }
    }
    public String myGetStringListIngredients() {
        String output="";
        for (Ingredient ing : ingredientList) {
            output+=ing;
        }
        return output;
    }
    public void totalDatos(){
        System.out.println("Total en arreglo \n"+ingredientList.size());
    }
    public void modifyQuantityIngredients(String nameIngredient, int quantity){
        for (int i=0; i<ingredientList.size(); i++){
            if(ingredientList.get(i).getName().equals(nameIngredient)){
                ingredient.setQuantity(quantity);

            }
        }
    }



}
