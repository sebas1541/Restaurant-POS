package model;

import java.util.ArrayList;
import java.util.List;

public class HotDogManager {

    public HotDog classic() {
        String name = "CLASICO";
        String path = "src/resources/HotDogPhotos/PerroClasico.png";
        int price = 12500;
        ArrayList <Ingredient> ing = new ArrayList<Ingredient>();
        ing.add(new Ingredient("Pan", 1));
        ing.add(new Ingredient("Salchicha", 1));
        ing.add(new Ingredient("Cebolla", 1));
        ing.add(new Ingredient("Tomate", 1));
        ing.add(new Ingredient("Papas Cabello de Angel", 1));
        HotDog hotDogClassic = new HotDog(name, ing, path, price);
        return hotDogClassic;
    }

    public HotDog dogzilla() {
        String name = "DOGZILLA";
        String path = "src/resources/HotDogPhotos/DogZilla.png";
        int price = 16500;
        ArrayList<Ingredient> ing = new ArrayList<Ingredient>();
        ing.add(new Ingredient("Pan", 1));
        ing.add(new Ingredient("Salchicha", 1));
        ing.add(new Ingredient("Pollo", 1));
        ing.add(new Ingredient("Tocineta", 1));
        ing.add(new Ingredient("Maiz Tierno", 1));
        ing.add(new Ingredient("Chile con Carne", 1));
        ing.add(new Ingredient("Pina", 1));
        ing.add(new Ingredient("Huevo Codorniz", 1));
        ing.add(new Ingredient("Queso Derretido", 1));
        HotDog hotDogDogzilla = new HotDog(name, ing, path, price);
        return hotDogDogzilla;
    }

    public HotDog mexican() {
        String name = "MEXICANO";
        String path = "src/resources/HotDogPhotos/Mexicano.png";

        ArrayList<Ingredient> ing = new ArrayList<Ingredient>();
        ing.add(new Ingredient("Pan", 1));
        ing.add(new Ingredient("Salchicha", 1));
        ing.add(new Ingredient("Chile con Carne", 1));
        ing.add(new Ingredient("Queso Chedar", 1));
        ing.add(new Ingredient("Maiz Tierno", 1));
        int price = 15500;
        HotDog hotDogMexican = new HotDog(name, ing, path, price);
        return hotDogMexican;
    }

    public HotDog colombian() {
        String name = "COLOMBIANO";
        String path = "src/resources/HotDogPhotos/Colombiano.png";
        int price = 14900;
        ArrayList<Ingredient> ing = new ArrayList<Ingredient>();
        ing.add(new Ingredient("Pan", 1));
        ing.add(new Ingredient("Salchicha", 1));
        ing.add(new Ingredient("Queso Derretido", 1));
        ing.add(new Ingredient("Cebolla", 1));
        ing.add(new Ingredient("Huevo Codorniz", 1));
        ing.add(new Ingredient("Papas Cabello de Angel", 1));
        ing.add(new Ingredient("Salsa de Tomate", 1));
        ing.add(new Ingredient("Mayonesa", 1));
        ing.add(new Ingredient("Mostaza", 1));
        HotDog hotDogColombian = new HotDog(name, ing, path, price);
        return hotDogColombian;
    }

    public HotDog hawaiian() {
        String name = "HAWAIANO";
        String path = "src/resources/HotDogPhotos/Hawaiano.png";
        int price = 14900;
        ArrayList<Ingredient> ing = new ArrayList<Ingredient>();
        ing.add(new Ingredient("Pan", 1));
        ing.add(new Ingredient("Salchicha", 1));
        ing.add(new Ingredient("pina", 1));
        ing.add(new Ingredient("Queso Derretido", 1));
        ing.add(new Ingredient("Tocineta", 1));
        ing.add(new Ingredient("Salsa Tartara", 1));
        ing.add(new Ingredient("Salsa de Pina", 1));
        ing.add(new Ingredient("Mayonesa", 1));
        HotDog hotDogHawaiian = new HotDog(name, ing, path, price);
        return hotDogHawaiian;
    }

    public HotDog italian() {
        String name = "ITALIANO";
        String path = "src/resources/HotDogPhotos/Italiano.png";
        int price = 14900;
        ArrayList<Ingredient> ing = new ArrayList<Ingredient>();
        ing.add(new Ingredient("Pan", 1));
        ing.add(new Ingredient("Salchicha", 1));
        ing.add(new Ingredient("Queso Derretido", 1));
        ing.add(new Ingredient("Pepperoni", 1));
        ing.add(new Ingredient("Salsa de Tomate", 1));
        ing.add(new Ingredient("Salsa Rosada", 1));
        ing.add(new Ingredient("Mayonesa", 1));
        HotDog hotDogItalian = new HotDog(name, ing, path, price);
        return hotDogItalian;
    }

    public HotDog shredded() {
        String name = "DESGRANADO";
        String path = "src/resources/HotDogPhotos/Desgranado.png";
        int price = 14900;
        ArrayList<Ingredient> ing = new ArrayList<Ingredient>();
        ing.add(new Ingredient("Pan", 1));
        ing.add(new Ingredient("Salchicha", 1));
        ing.add(new Ingredient("Pollo", 1));
        ing.add(new Ingredient("Maiz Tierno", 1));
        ing.add(new Ingredient("Queso Derretido", 1));
        ing.add(new Ingredient("Papas Cabello de Angel", 1));
        ing.add(new Ingredient("Salsa Tartara", 1));
        ing.add(new Ingredient("Mayonesa", 1));
        ing.add(new Ingredient("Salsa de Pina", 1));
        HotDog hotDogShredded = new HotDog(name, ing, path, price);
        return hotDogShredded;
    }

    public List<HotDog> getAllHotDogs(){
        List<HotDog> hotDogs = new ArrayList<>();
        hotDogs.add(classic());
        hotDogs.add(dogzilla());
        hotDogs.add(mexican());
        hotDogs.add(colombian());
        hotDogs.add(hawaiian());
        hotDogs.add(italian());
        hotDogs.add(shredded());
        return hotDogs;
    }
}