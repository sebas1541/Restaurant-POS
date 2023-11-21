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
        //id_Order = 0;
        consumption_Tax = 0;
    }

    public void addHotDog(int op){
        do {
            switch (op) {
                case 1:
                    hotDogList.add(hM.classic());
                    op = 8;
                    break;
                case 2:
                    hotDogList.add(hM.dogzilla());
                    op = 8;
                    break;
                case 3:
                    hotDogList.add(hM.mexican());
                    op = 8;
                    break;
                case 4:
                    hotDogList.add(hM.colombian());
                    op = 8;
                    break;
                case 5:
                    hotDogList.add(hM.hawaiian());
                    op = 8;
                    break;
                case 6:
                    hotDogList.add(hM.italian());
                    op = 8;
                    break;
                case 7:
                    hotDogList.add(hM.shredded());
                    op = 8;
                    break;
                case 8:
                    JOptionPane.showMessageDialog(null, "Finalizado");
            }
        } while (op != 8);
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