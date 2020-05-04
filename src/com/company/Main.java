package com.company;

import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main {
    //do zrobienia listy w klasie inventory bo nie wykrywaja
    //zmienic list do main i za pomoca parametrow w metodzie wywolywac zmiany!
    public static void main(String[] args) throws FileNotFoundException {
        int choice;
        List<Integer> idList = new LinkedList<>();
        List<Double> priceList = new LinkedList<>();
        List<Integer> quanityList = new LinkedList<>();
        List<String> nameList = new LinkedList<>();
        Scanner s = new Scanner(System.in);
        System.out.println("Witaj w programie Inventory!\n" +
                "Zaczyanmy od dodania produktu");
        Product product = new Product();
        Inventory inventory = new Inventory();
        try {
            inventory.readSave(idList, priceList, quanityList, nameList);
        }
        catch (NoSuchElementException e) {
            System.out.println("Uruchamiam z pustego pliku!");
        }
        for (int i = 0; ; i++) {
            //Podawanie wartości
            if (idList.size() > 0) {
                i = idList.size();
            }
            System.out.println("Id: " + i);
            System.out.println("Podaj nazwe produktu");
            String name = s.nextLine();
            System.out.println("Podaj cene");
            double price = s.nextDouble();
            System.out.println("Podaj ilość");
            int quanity = s.nextInt();
            s.nextLine();
            //Dodanie wartości


            product.setData(i, price, quanity, name);

            product.readData();
            product.addProduct(idList, priceList, quanityList, nameList);


            //Wybór
            System.out.println("Wybierz opcje:");
            System.out.println("1. Wybierz produkt przez id");
            System.out.println("2. Zmień wartość");
            System.out.println("3. Wyświetl całą listę produktów");
            System.out.println("4. Zsumuj wartość wszystkich produktów");
            System.out.println("5. Zsumuj ilość");
            System.out.println("6. Zapisz");
            System.out.println("7. Kontynuuj");
            System.out.println("8. Usuń zsumowane dane");
            System.out.println("9. Zakończ program");

            choice = s.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Podaj id do wyświetlenia:");
                    choice = s.nextInt();
                    product.selectWithID(choice, idList, priceList, quanityList, nameList);
                    break;
                case 2:
                    System.out.println("Podaj id do zmiany:");
                    choice = s.nextInt();
                    product.setValueWithID(choice, idList, priceList, quanityList, nameList);
                    break;
                case 3:
                    inventory.viewInventory(idList, priceList, quanityList, nameList);
                    break;
                case 4:
                    inventory.sumOrderPrice(0, priceList, nameList);
                    break;
                case 5:
                    inventory.sumOrderQuanity(0, quanityList, nameList);
                    break;
                case 6:
                    inventory.saveData(idList, priceList, quanityList, nameList);
                    break;
                case 8:

                    break;
                    case 9:
                    System.exit(0);
                    break;
                default:
                    break;
            }
            s.nextLine();
            //Mechanizm kontynuacji
            if (choice != 7) {
                System.out.println("Czy chcesz kontynuować ?\n dowolnt klawisz : tak\n n lub N : nie");
                String key = s.nextLine();
                if (key.equals("n") || key.equals("N")) {
                    System.out.println("Zatrzymanie programu");
                    break;
                }
            }
            System.out.println("Kontynuacja");
        }
    }
}
