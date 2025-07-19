package org.example.models;

import java.util.*;


public class Grocery {
    public static List<String> groceryList = new ArrayList<>();
    public static final Scanner scanner = new Scanner(System.in);
    public static void addItems(String input) {
        String[] items = input.split(",");
        for(String item : items) {
            String trimmed = item.trim().toLowerCase();
            if (!trimmed.isEmpty() && !checkItemIsInList(trimmed)) {
                groceryList.add(trimmed);
            } else {
                System.out.println("'" + trimmed + "' zaten listede var veya geçersiz giriş.");
            }
        }
        printSorted();
    }
    public static void removeItems(String input) {
        String[] items = input.split(",");
        for (String item : items) {
            String trimmed = item.trim().toLowerCase();
            if (checkItemIsInList(trimmed)) {
                groceryList.remove(trimmed);
            } else {
                System.out.println("'" + trimmed + "' listede bulunamadı.");
            }
        }
        printSorted();
    }
    public static void printSorted() {
        List<String> sortedList = new ArrayList<>(new HashSet<>(groceryList));
        Collections.sort(sortedList);
        groceryList = sortedList;
        System.out.println("Güncel Liste: " + groceryList);
    }
    public static boolean checkItemIsInList(String product) {
        return groceryList.contains(product.toLowerCase().trim());
    }
    public static void startGrocery(){
        boolean running = true;
    while(running){
        int choice = Integer.parseInt(scanner.nextLine());
        System.out.println("Lütfen bir seçenek giriniz:");
        System.out.println("0 - Uygulamayı kapat");
        System.out.println("1 - Ürün ekle");
        System.out.println("2 - Ürün çıkar");
        switch(choice){
            case 0:
                running = false;
                break;
            case 1:
                System.out.print("Eklemek istediğiniz ürünleri giriniz.");
                String addInput = scanner.nextLine();
                addItems(addInput);
                break;
            case 2:
                System.out.print("Çıkarmak istediğiniz ürünleri giriniz.");
                String removeInput = scanner.nextLine();
                removeItems(removeInput);
                break;
            default:
                System.out.println("Geçersiz seçim. Lütfen 0, 1 veya 2 giriniz.");
        }
        printSorted();
    }
    }

}
