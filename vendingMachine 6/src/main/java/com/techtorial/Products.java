package com.techtorial;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Products {

    /*
	 * Please add more vending machine features
	 * - Buy a product
	 * - Search for a product
	 * - Get list of products
	 */

    private static String[] products  = new String[] {"Monitor", "Mouse", "Keyboard", "USB cable", "Charger", "Mouse pad"};
    private static int[]    prices    = new int[] {100, 70, 89, 17, 99, 5};
    private static int[]    inventory = new int[] {4, 10, 5, 10, 5, 7};

      public static List<String> getListOfProducts(){
          List<String> listOfProducts = new ArrayList<>();
          Collections.addAll(listOfProducts, products);
          System.out.println(listOfProducts);
    return listOfProducts;
}
    public static String[] getAllPrices() {
        System.err.println("Product: price");
        for (int j = 0; j < products.length; j++) {
            System.out.println(products[j] + ": $" + prices[j]);
        }
        return products;
    }

    public static int getProductPrice(String productName) {
        int index = 0;
        for (String s : products) {
            if (productName.equalsIgnoreCase(s)) {
                return prices[index];
            }
            index++;
        }
        System.out.println("Sorry the product you entered is not available");
        return -1;
    }

    public static void selectProduct(String productName) {

    	//loop over the product list to find out if it is available in our vending machine
		//if yes find the price (tip: call a specific method)
		//and verify this product is available in inventory
		//ask if customer wants to buy it -> if yes call another method to buy a product
//											-> if no call method to cancel it

        int index = 0;
        for (String s : products) {
            if (productName.equalsIgnoreCase(s)) {
                System.out.println( "Price for the " + products[index] +" is " + getProductPrice(productName));
                if (inventory[index]>0){
                    System.out.println("Do you want to buy ? Yes/No");
                    Scanner scanner = new Scanner(System.in);
                    String answer = scanner.nextLine();
                    if(answer.equalsIgnoreCase("yes")){
                        buyAProduct(productName);
                    }else {
                        selectProduct(productName);
                    }
                }
            }
            index++;
        }
        System.out.println("Sorry the product you entered is not available");
    }

    public static void buyAProduct(String productName) {

        /*
        Apply payment logic.
        Apply give back change logic
        Apply inventory update logic: if someone buys an item, we should decrement number of available items.
         */
        Scanner scanner = new Scanner(System.in);
        System.out.println("How much money you insert?");
        int budget = 0;
        while (budget<getProductPrice(productName)){
            System.out.println("Please pay $" + (getProductPrice(productName) - budget));
            budget += scanner.nextInt();
        }
        int change = budget - getProductPrice(productName);
        System.out.println("Your change - $" + change);

        int index =0;
        for (String s : products) {
            if (productName.equalsIgnoreCase(s)) {
                inventory[index]-=1;
            }
            index++;
        }

    }

    public static void getProductInfo(String productName){
         int index = 0;
          for (String s : products){
              if (productName.equalsIgnoreCase(s)){
                  if(inventory[index]>0){
                      System.out.println("Item is available. " + inventory[index] + " -  left. ");
                  }else {
                      System.out.println("Item is not available at this time");
                  }
              }
              index++;
          }
        System.out.println("Price is : " + getProductPrice(productName) );
    }

    public static List<String> setPriceRange(int money){
          List<String> availableItems = new ArrayList<>();
          int index = 0;
          for (String s : products){
              if(prices[index]<money){
                  availableItems.add(s);
              }
              index++;
          }
          if(availableItems.isEmpty()){
              System.out.println("There are no available items for this price");
          }else {
              System.out.println("For this price you buy " + availableItems); }
          return availableItems;
    }
}
