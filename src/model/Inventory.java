
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

    public void totalDatos(){
        System.out.println("Total en arreglo \n"+ingredientList.size());
    }
    public void modifyQuantityIngredients(String nameIngredient, int quantify){
        for (int i=0; i<ingredientList.size(); i++){
            if(ingredientList.get(i).getName().equals(nameIngredient)){
                ingredient.setQuantity(quantify);
            }
        }
    }

    public void igL(int opt){

        do {
            switch (opt){
                case 1:modifyQuantityIngredients();
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:

                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:

                    break;
                case 8:
                    break;
                case 9:
                    break;
                case 10:
                    break;
                case 11:
                    break;
                case 12:
                    break;
                case 13:

                    break;
                case 14:
                    break;
                case 15:
                    break;
                case 16:

                    break;
                case 17:
                    break;
                case 18:
                    break;
                case 19:

                    break;
                case 20:
                    break;
                case 21:
                    break;
                case 22:

                    break;
                case 23:
                    break;
                case 24:
                    break;
                case 25:

                    break;
                case 26:
                    break;
            }
        }while (opt!=26);
    }

}
