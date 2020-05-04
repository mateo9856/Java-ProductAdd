package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Inventory extends Product {
    Scanner s = new Scanner(System.in);
    List<Integer> sumQuanity = new ArrayList<>();
    List <Double> sumPrice = new ArrayList<>();

    /*public Inventory(int id, double price, int quanity, String name ,int sumQuanity, double sumPrice) {
        super(id, price, quanity, name);
        this.sumQuanity = sumQuanity;
        this.sumPrice = sumPrice;
    }
    */
    public void viewInventory(List idList, List priceList, List quanityList, List nameList) {
        //System.out.format("%-15s%-15s%-15s%-15s\n", "ID", "Price", "Quanity", "Name");
        //System.out.println("");
        //for (int i = 0; i < idList.size(); i++) {
            //System.out.format("%-15d%-15f%-15d%-15s\n", idList.get(i), priceList.get(i), quanityList.get(i), nameList.get(i));
        //    System.out.println("Wyświetla");
        //}
        System.out.format("%-15s%-15s%-15s%-15s\n", "ID", "Price", "Quanity", "Name");

        for (int i = 0;i<idList.size();i++) {
            System.out.format("%-15d%-15f%-15d%-15s\n", idList.get(i), priceList.get(i), quanityList.get(i), nameList.get(i));
        }
        viewSum();
    }


    public double sumOrderPrice(double sum, List priceList, List nameList ) {
        System.out.println("Podaj ile produktów sumujesz");
        System.out.println("Ile sumujesz? Jeśli wprowadzisz 0 zsumuje wszystko!");
        int choice = s.nextInt();
        if(choice == 0) {
            System.out.println("Sumuje Wszystko !");
            for(int i = 0;i<priceList.size();i++) {
                sum = sum + (double) priceList.get(i);
            }
            System.out.println("Razem: " + sum);
            sumPrice.add(sum);
            return sum;
        }
        for(int i = 0;i<choice;i++) {
            System.out.println("Wybierz ID:");
            choice = s.nextInt();
            System.out.println("Dodaje wartość dla: " + nameList.get(choice));
            sum+= (double) priceList.get(choice);
        }
        System.out.println("Razem: " + sum);
        sumPrice.add(sum);
        return sum;
    }

    public int sumOrderQuanity(int sum, List quanityList, List nameList) {
        System.out.println("Podaj ile produktów sumujesz");
        System.out.println("Ile sumujesz? Jeśli wprowadzisz 0 zsumuje wszystko!");
        int choice = s.nextInt();

        if(choice == 0) {
            System.out.println("Sumuje Wszystko !");
            for(int i = 0;i<quanityList.size();i++) {
                sum = sum + (int) quanityList.get(i);
            }
            System.out.println("Razem: " + sum);
            sumQuanity.add(sum);
            return sum;
        }

        for(int i = 0;i<choice;i++) {
            System.out.println("Wybierz ID:");
            choice = s.nextInt();
            System.out.println("Dodaje wartość dla: " + nameList.get(choice));
            sum = sum + (int) quanityList.get(i);
        }
        System.out.println("Razem: " + sum);
        sumQuanity.add(sum);
        return sum;
    }

    public void viewSum() {
        System.out.println("Ilość:" + sumQuanity);
        System.out.println("Wartości:" + sumPrice);
    }

    public void clearSum(List list, String name) {

        for(int i = list.size() - 1;i>=0;i--) {
            list.remove(list.get(i));
        }
        System.out.println("Usunięto!" + name);

    }

    public void readSave(List idList, List priceList, List quanityList, List nameList) throws FileNotFoundException {
        File plik  = new File("id.txt");
        File plik2  = new File("price.txt");
        File plik3  = new File("quanity.txt");
        File plik4  = new File("name.txt");
        Scanner in = new Scanner(plik);
        Scanner in2 = new Scanner(plik2);
        Scanner in3 = new Scanner(plik3);
        Scanner in4 = new Scanner(plik4);
        for(int i = 0;i<=1;i++) {

                idList.add(Integer.parseInt(in.nextLine()));
                priceList.add(Double.parseDouble(in2.nextLine()));
                quanityList.add(Integer.parseInt(in3.nextLine()));
                nameList.add(in4.nextLine());

        }
        System.out.println(idList);
        System.out.println(priceList);
        System.out.println(quanityList);
        System.out.println(nameList);
    }

    public void saveData(List idList, List priceList, List quanityList, List nameList) throws FileNotFoundException {
        PrintWriter saveiD = new PrintWriter("id.txt");
        PrintWriter savePrice = new PrintWriter("price.txt");
        PrintWriter saveQuanity = new PrintWriter("quanity.txt");
        PrintWriter saveName = new PrintWriter("name.txt");
        //for (int i = 0;i<idList.size();i++) {
        //    save.format("%-15d%-15f%-15d%-15s\n", idList.get(i), priceList.get(i), quanityList.get(i), nameList.get(i));
        //}
        for(int i = 0;i<idList.size();i++) {
            saveiD.println(idList.get(i));
            savePrice.println(priceList.get(i));
            saveQuanity.println(quanityList.get(i));
            saveName.println(nameList.get(i));
        }
        saveiD.close();
        savePrice.close();
        saveQuanity.close();
        saveName.close();
        System.out.println("Zapisano");
    }

}
