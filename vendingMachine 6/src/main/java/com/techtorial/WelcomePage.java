package com.techtorial;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

import static com.techtorial.Instructions.getInstructions;

/*
 * This is your main page where the vending machine application is going to be triggered and
 * all inputs being accepted.
 */
public class WelcomePage {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to Code AI sponsored vending machine!");
        System.out.println("What is your name?");

        String name = scanner.next();
        System.out.println("Nice to meet you, " + name);
        System.out.println("Please press 0 for available options...");

        int allOptions = getIntegerInput(scanner, new Integer[] {0});
        getInstructions(allOptions);

        scanner = new Scanner(System.in);
        System.out.println("Enter what you want to do: ");
        switch (getIntegerInput(scanner, new Integer[] {1, 2, 3, 4, 5, 6, 7, 8})) {
            case 1:
                Products.getListOfProducts();
                break;
            case 2:
                System.out.println("Enter product name: ");
                Products.getProductInfo(scanner.next());
                break;
            case 3:
                System.out.println("Enter product name: ");
                Products.selectProduct(scanner.next());
                break;
            case 4:
                System.out.println("Enter product name: ");
                System.out.println(Products.getProductPrice(scanner.next()));
                break;
            case 5:
                Products.getAllPrices();
                break;
            case 6:
                System.out.println("Please enter how much you want to spend: ");
                Products.setPriceRange(scanner.nextInt());
                break;
            case 7:
                break;
            case 8:
                System.out.println("Please enter product name: ");
                Products.buyAProduct(scanner.next());
                break;
        }


        System.out.println("Thanks for shopping with us");

    }

    private static int getIntegerInput(Scanner scanner, Integer[] expected) {
        int allOptions = -1;
        for (int i = 1; i <= 3; i++) {
            scanner = new Scanner(System.in);
            int input;
            try {
                input = scanner.nextInt();

                if (!Arrays.asList(expected).contains(input)) {
                    throw new IOException();
                }
            } catch (Exception e) {
                if (i < 3) {
                    System.out.println("Please enter 0");
                    System.out.printf("You have %d more retries", 3 - i);
                    System.out.println();
                } else {
                    System.out.println("Sorry, try next time");
                    System.exit(1);
                }
                continue;
            }
            allOptions = input;
            break;
        }
        return allOptions;
    }
}
