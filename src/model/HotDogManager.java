package model;

import java.util.ArrayList;
import java.util.List;

public class HotDogManager {
    private ArrayList<Ingredient> toppings;
    private ArrayList<Ingredient> sauces;
    private ArrayList<Ingredient> extras;
    private String name_client;

    public HotDogManager(String name_client) {
        this.name_client = name_client;
        toppings = new ArrayList<>();
        sauces = new ArrayList<>();
        extras = new ArrayList<>();
    }

    public void toppings(String name) {
        if (toppings.isEmpty()) {
            toppings.add(new Ingredient("Pan", 1, 0));
            toppings.add(new Ingredient("Salchicha", 1, 0));
        }
        for (int i = 0; i < toppings.size(); i++) {
            if (!name.equals(toppings.get(i).getName())) {
                toppings.add(new Ingredient(name, 1, 0));
            } else {
                toppings.get(i).setQuantity(0);
            }
        }
    }

    public void sauces(String name) {
        for (int i = 0; i < sauces.size(); i++) {
            if (!name.equals(sauces.get(i).getName())) {
                sauces.add(new Ingredient(name, 1, 0));
            } else {
                sauces.get(i).setQuantity(0);
            }
        }
    }

    public void extras(String name, int price) {
        for (int i = 0; i < extras.size(); i++) {
            if (!name.equals(extras.get(i).getName())) {
                extras.add(new Ingredient(name, 1, price));
            } else {
                extras.get(i).setQuantity(0);
            }
        }
    }

    public ArrayList<Ingredient> totalIngredients() {
        ArrayList<Ingredient> ingredients = new ArrayList<>();
        ingredients.addAll(toppings);
        ingredients.addAll(sauces);
        ingredients.addAll(extras);
        return ingredients;
    }

    public ArrayList<Ingredient> saucesAndExtras() {
        ArrayList<Ingredient> ingredients = new ArrayList<Ingredient>();
        ingredients.addAll(sauces);
        ingredients.addAll(extras);
        sauces.clear();
        extras.clear();
        return ingredients;
    }

    public int totalPrice(int hotDogPrice, ArrayList<Ingredient> ingredients) {
        //int add = 0;
        /*
        for (int i = 0; i < ingredients.size(); i++) {
            add += ingredients.get(i).getPrice() + hotDogPrice;
        }
        return add;

         */
        return hotDogPrice;
    }

    public HotDog classic(String nameI, int quantityI) {
        String name = "Clasico";
        String path = "src/resources/HotDogPhotos/PerroClasico.png";
        int price = 12500;
        HotDog hotDogClassic = new HotDog(name, totalIngredients(), path, totalPrice(price, totalIngredients()));
        return hotDogClassic;
    }

    public HotDog dogzilla(String nameI, int quantityI) {
        String name = "Dogzilla";
        String path = "src/resources/HotDogPhotos/DogZilla.png";
        int price = 16500;
        ArrayList<Ingredient> ing = new ArrayList<Ingredient>();
        ing.add(new Ingredient("Pan", 1, 0));
        ing.add(new Ingredient("Salchicha", 1, 0));
        ing.add(new Ingredient("Pollo", 1, 0));
        ing.add(new Ingredient("Tocineta", 1, 0));
        ing.add(new Ingredient("Maiz Tierno", 1, 0));
        ing.add(new Ingredient("Chile con Carne", 1, 0));
        ing.add(new Ingredient("Pina", 1, 0));
        ing.add(new Ingredient("Huevo Codorniz", 1, 0));
        ing.add(new Ingredient("Queso Derretido", 1, 0));
        ing.addAll(totalIngredients());
        HotDog hotDogDogzilla = new HotDog(name, ing, path, totalPrice(price, ing));
        return hotDogDogzilla;
    }

    public HotDog mexican(String nameI, int quantityI) {
        String name = "Mexicano";
        String path = "src/resources/HotDogPhotos/Mexicano.png";

        ArrayList<Ingredient> ing = new ArrayList<Ingredient>();
        ing.add(new Ingredient("Pan", 1, 0));
        ing.add(new Ingredient("Salchicha", 1, 0));
        ing.add(new Ingredient("Chile con Carne", 1, 0));
        ing.add(new Ingredient("Queso Chedar", 1, 0));
        ing.add(new Ingredient("Maiz Tierno", 1, 0));
        int price = 15500;
        ing.addAll(saucesAndExtras());
        HotDog hotDogMexican = new HotDog(name, ing, path, totalPrice(price, ing));
        return hotDogMexican;
    }

    public HotDog colombian(String nameI, int quantityI) {
        String name = "Colombiano";
        String path = "src/resources/HotDogPhotos/Colombiano.png";
        int price = 14900;
        ArrayList<Ingredient> ing = new ArrayList<Ingredient>();
        ing.add(new Ingredient("Pan", 1, 0));
        ing.add(new Ingredient("Salchicha", 1, 0));
        ing.add(new Ingredient("Queso Derretido", 1, 0));
        ing.add(new Ingredient("Cebolla", 1, 0));
        ing.add(new Ingredient("Huevo Codorniz", 1, 0));
        ing.add(new Ingredient("Papas Cabello de Angel", 1, 0));
        ing.add(new Ingredient("Salsa de Tomate", 1, 0));
        ing.add(new Ingredient("Mayonesa", 1, 0));
        ing.add(new Ingredient("Mostaza", 1, 0));
        ing.addAll(saucesAndExtras());
        HotDog hotDogColombian = new HotDog(name, ing, path, totalPrice(price, ing));
        return hotDogColombian;
    }

    public HotDog hawaiian(String nameI, int quantityI) {
        String name = "Hawaiano";
        String path = "src/resources/HotDogPhotos/Hawaiano.png";
        int price = 14900;
        ArrayList<Ingredient> ing = new ArrayList<Ingredient>();
        ing.add(new Ingredient("Pan", 1, 0));
        ing.add(new Ingredient("Salchicha", 1, 0));
        ing.add(new Ingredient("pina", 1, 0));
        ing.add(new Ingredient("Queso Derretido", 1, 0));
        ing.add(new Ingredient("Tocineta", 1, 0));
        ing.add(new Ingredient("Salsa Tartara", 1, 0));
        ing.add(new Ingredient("Salsa de Pina", 1, 0));
        ing.add(new Ingredient("Mayonesa", 1, 0));
        ing.addAll(extras);
        HotDog hotDogHawaiian = new HotDog(name, ing, path, totalPrice(price, ing));
        return hotDogHawaiian;
    }

    public HotDog italian(String nameI, int quantityI) {
        String name = "ITALIANO";
        String path = "src/resources/HotDogPhotos/Italiano.png";
        int price = 14900;
        ArrayList<Ingredient> ing = new ArrayList<Ingredient>();
        ing.add(new Ingredient("Pan", 1, 0));
        ing.add(new Ingredient("Salchicha", 1, 0));
        ing.add(new Ingredient("Queso Derretido", 1, 0));
        ing.add(new Ingredient("Pepperoni", 1, 0));
        ing.add(new Ingredient("Salsa de Tomate", 1, 0));
        ing.add(new Ingredient("Salsa Rosada", 1, 0));
        ing.add(new Ingredient("Mayonesa", 1, 0));
        HotDog hotDogItalian = new HotDog(name, ing, path, totalPrice(price, ing));
        return hotDogItalian;
    }

    public HotDog shredded(String nameI, int quantityI) {
        String name = "Desgranado";
        String path = "src/resources/HotDogPhotos/Desgranado.png";
        int price = 14900;
        ArrayList<Ingredient> ing = new ArrayList<Ingredient>();
        ing.add(new Ingredient("Pan", 1, 0));
        ing.add(new Ingredient("Salchicha", 1, 0));
        ing.add(new Ingredient("Pollo", 1, 0));
        ing.add(new Ingredient("Maiz Tierno", 1, 0));
        ing.add(new Ingredient("Queso Derretido", 1, 0));
        ing.add(new Ingredient("Papas Cabello de Angel", 1, 0));
        ing.add(new Ingredient("Salsa Tartara", 1, 0));
        ing.add(new Ingredient("Mayonesa", 1, 0));
        ing.add(new Ingredient("Salsa de Pina", 1, 0));
        ing.addAll(extras);
        HotDog hotDogShredded = new HotDog(name, ing, path, totalPrice(price, ing));
        return hotDogShredded;
    }

    public List<HotDog> getAllHotDogs(){
        List<HotDog> hotDogs = new ArrayList<>();
        hotDogs.add(classic("clasico", 1));
        hotDogs.add(dogzilla("dogzilla", 1));
        hotDogs.add(mexican("mexicano", 1));
        hotDogs.add(colombian("cololmbiano", 1));
        hotDogs.add(hawaiian("hawaiano", 1));
        hotDogs.add(italian("italiano", 1));
        hotDogs.add(shredded("desmechado", 1));
        return hotDogs;
    }

    public String getName_client() {
        return name_client;
    }

    public void setName_client(String name_client) {
        this.name_client = name_client;
    }
}


