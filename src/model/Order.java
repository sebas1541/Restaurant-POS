package model;

import javax.swing.*;
import java.lang.reflect.Array;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Order {

    private ArrayList<HotDog> hotDogList;
    private HotDogManager hM;
    private String customerName;
    private int id_Order;
    private double consumption_Tax;

    private static final String COMPANY_NAME = "DogZilla HotDogs";
    private static final String COMPANY_LOCATION = "Tunja, Boyacá";
    private static final double TAX_RATE = 0.08; // 8% Tax rate

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

    public String textOrder() {
        tax();

        StringBuilder invoice = new StringBuilder();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        String currentTime = dateFormat.format(new Date());

        invoice.append("Company: ").append(COMPANY_NAME)
                .append("\nLocation: ").append(COMPANY_LOCATION)
                .append("\nTime: ").append(currentTime)
                .append("\nOrder Number: ").append(id_Order)
                .append("\nCustomer Name: ").append(customerName)
                .append("\nProducts:\n");

        for (HotDog hotDog : hotDogList) {
            invoice.append("- HOTDOG ").append(hotDog.getName())
                    .append("        Price: ").append(hotDog.getPrice()).append("\n");
        }

        invoice.append("\nSubtotal: ").append(sum_Price())
                .append("\nConsumption Tax (8%): ").append(consumption_Tax)
                .append("\nTotal Order Price: ").append(total_price());

        return invoice.toString();
    }
}