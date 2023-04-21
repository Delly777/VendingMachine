package com.techtorial;

import java.util.Scanner;

public class Instructions {


    public static void getInstructions(int input) {
        Scanner scanner = new Scanner(System.in);

        switch (input) {
            case 0:
                System.out.println("Press 0 to return to the menu+\nPress 1 to see all items+\nPress 2 to get item info+\nPress 3 to select a product+\n" +
                        "Press 4 to get item price+\nPress 5 to see list of all prices+\nPress 6 to set price range+\nPress 7 to Exit+\nPress 8 to Buy and item");

//            //case 1:     Products.getListOfProducts();
//               // break;
//            case 2:
//                System.out.println("Enter product name: ");
//                Products.getProductInfo(scanner.next());
//                break;
//            case 3:
//                System.out.println("Enter product name: ");
//                Products.selectProduct(scanner.next());
//                break;
//            case 4:
//                System.out.println("Enter product name: ");
//                Products.getProductPrice(scanner.next());
//                break;
//            case 5:
//                Products.getAllPrices();
//                break;
//            case 6:
//                System.out.println("Please enter how much you want to spend: ");
//                Products.setPriceRange(scanner.nextInt());
//                break;
//            case 7:
//                break;
//            case 8:
//                System.out.println("Please enter product name: ");
//                Products.buyAProduct(scanner.next());
//                break;
                /*
                 * Vending machine options are:
                 * 1 - List all items/products, names of products
                 * 2 - Get item/product info (details, availability), price and inventory number
                 * 3 - Select a product
                 * 4 - Get item/product price
                 * 5 - List all prices
                 * 6 - Set price range
                 * 7 - Exit
                 * 8 - Buy an item
                 */
            default:
                System.out.println("Please enter 0");
        }
    }

}
