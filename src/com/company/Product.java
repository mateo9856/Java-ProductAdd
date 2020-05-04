package com.company;


import java.util.List;
import java.util.Scanner;

public class Product {
    protected int id;
    protected double price;
    protected int quanity;
    protected String name;


    public Product() {
        this(0, 0, 0, "");
    }

    public Product(int id, double price, int quanity, String name) {
        this.id = id;
        this.price = price;
        this.quanity = quanity;
        this.name = name;
    }

    //Odczyt i zmiana wprowadzonych danych
    public void setData(int id, double price, int quanity, String name) {
        this.id = id;
        this.price = price;
        this.quanity = quanity;
        this.name = name;
    }

    public void readData() {
        System.out.println("Wprowadziłeś:");
        System.out.println(id);
        System.out.println(price);
        System.out.println(quanity);
        System.out.println(name);
    }

    //Dodawanie do list
    public void addProduct(List idList, List priceList, List quanityList, List nameList) {
        idList.add(id);
        priceList.add(price);
        quanityList.add(quanity);
        nameList.add(name);
        System.out.println("Dodałem");
        System.out.println(idList);
        System.out.println(priceList);
        System.out.println(quanityList);
        System.out.println(nameList);
    }


    public void selectWithID(int id ,List idList, List priceList, List quanityList, List nameList) {
        System.out.println("Wybrałeś: ");
        System.out.println("Id: " + idList.get(id));
        System.out.println("Wartość: " + priceList.get(id));
        System.out.println("Ilość: " + quanityList.get(id));
        System.out.println("Nazwa Produktu: " + nameList.get(id));
    }

    public int setValueWithID(int id ,List idList, List priceList, List quanityList, List nameList) {
        System.out.println("Co modyfikujesz?");
        System.out.println("1.Wartość");
        System.out.println("2.Ilość");
        System.out.println("3.Nazwa");
        Scanner s = new Scanner(System.in);
        int choice = s.nextInt();
        switch (choice) {
            case 1:
                priceList.set(id, s.nextDouble());
                System.out.println("Wprowadziłeś: " + priceList.get(id));
                break;
            case 2:
                quanityList.set(id, s.nextInt());
                System.out.println("Wprowadziłeś: " + quanityList.get(id));
                break;
            case 3:
                nameList.set(id, s.nextLine());
                System.out.println("Wprowadziłeś " + nameList.get(id));
                break;
            default:
                break;
        }
        System.out.println("Zmodyfikoano ID = " + id);
        return id;
    }



}
