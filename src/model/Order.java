package model;

import javax.swing.*;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class Order {

    private ArrayList<HotDog> hotDogList;
    private HotDogManager hM;
    private String customerName;
    private int id_Order;
    private double consumption_Tax;

    public Order (String customerName){
        hotDogList = new ArrayList<HotDog>();
        hM = new HotDogManager();
        this.customerName = customerName;
        consumption_Tax = 0;
    }

    public void addHotDog(int op) {
        switch (op) {
            case 1:
                hotDogList.add(hM.classic());
                break;
            case 2:
                hotDogList.add(hM.dogzilla());
                break;
            case 3:
                hotDogList.add(hM.mexican());
                break;
            case 4:
                hotDogList.add(hM.colombian());
                break;
            case 5:
                hotDogList.add(hM.hawaiian());
                break;
            case 6:
                hotDogList.add(hM.italian());
                break;
            case 7:
                hotDogList.add(hM.shredded());
                break;
            default:
                System.out.println("Invalid option. Please enter a number between 1 and 7.");
                break;
        }
    }



    public double getConsumption_Tax() {
        return consumption_Tax;
    }



    public double total_price(){
        tax();
        return sum_Price() + consumption_Tax;
    }
    public double sum_Price(){
        double total_price = 0;
        for (int i = 0; i < hotDogList.size(); i++) {
            total_price += hotDogList.get(i).getPrice();
        }
        return total_price;
    }

    public void tax (){
        consumption_Tax = sum_Price() * 0.08;
    }



    public String showOrderDetails(){
        tax();
        String text = "Los productos son: \n";
        for (int i = 0; i < hotDogList.size(); i++) {
            text += "- HOTDOG " + hotDogList.get(i).getName()  + "        Precio: " + hotDogList.get(i).getPrice() + "\n";
        }
        text += "\n El subtotal es:     "+ sum_Price() + "\n El impuesto al consumo a pagar es:     " + consumption_Tax  + " (8%) " +"\n El precio total de su orden es:     " + total_price();
        return text;
    }


    public String showDogs(){
        String text = "";
        for (int i = 0; i < hotDogList.size(); i++) {
            text +=  hotDogList.get(i).getName() + "\n";
        }
        return text;
    }

    public String showDogPrice(){
        String text = "";
        for (int i = 0; i < hotDogList.size(); i++) {
            text +=  hotDogList.get(i).getPrice() + "\n";
        }
        return text;
    }

    public String textOrder (){
        tax();

        String text = "El numero de orden es: " + id_Order + "\nEl pedido se encuentra a nombre de: " + customerName + "\n Los productos son: \n";
        for (int i = 0; i < hotDogList.size(); i++) {
            text += "- HOTDOG " + hotDogList.get(i).getName()  + "        Precio: " + hotDogList.get(i).getPrice() + "\n";
        }
        text += "\n El subtotal es:     "+ sum_Price() + "\n El impuesto al consumo a pagar es:     " + consumption_Tax  + " (8%) " +"\n El precio total de su orden es:     " + total_price();
        return text;
    }
}