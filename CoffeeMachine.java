package machine;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CoffeeMachine {

    public static final Scanner input = new Scanner(System.in);
    private static int waterML = 400, milkML = 540, coffeeBeans = 120, disposableCups = 9, money =550;

    public static void main(String[] args) {
        actionMenu();
    }

    public static int shopInterface(){
        String choice = null;
        try{
            do {
                System.out.println("\nWrite action (buy, fill, take, remaining, exit):");
                choice = input.nextLine();
            } while (!choice.equals("buy") && !choice.equals("fill") && !choice.equals("take") &&
            !choice.equals("remaining") && !choice.equals("exit"));
        }catch(InputMismatchException ex){
            System.out.println(ex);
            input.nextLine();
        }
        switch (choice) {
            case "buy":
                return 1;
            case "fill":
                return 2;
            case "take":
                return 3;
            case "remaining":
                return 4;
            case "exit":
                return 5;
            default:
                return shopInterface();
        }
    }

    public static void machineStatus(){
        System.out.println("\nThe coffee machine has:\n" +
                waterML + " of water\n" +
                milkML + " of milk\n" +
                coffeeBeans + " of coffee beans\n" +
                disposableCups + " of disposable cups\n" +
                "$" + money + " of money\n");
    }

    public static void actionMenu(){
        String choice;
        loop: while(true){
            switch(shopInterface()) {
                case 1:
                    System.out.println("\nWhat do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu::");
                    choice = input.nextLine();
                    buy(choice);
                    break;
                case 2:
                    fill();
                    break;
                case 3:
                    take();
                    break;
                case 4:
                    machineStatus();
                    break;
                case 5:
                    System.out.print("Closing coffee machine....\nHave a good day!");
                    break loop;
            }
        }
    }

    public static void fill(){
        System.out.println("Write how many ml of water do you want to add:");
        waterML += input.nextInt();
        System.out.println("Write how many ml of milk do you want to add:");
        milkML += input.nextInt();
        System.out.println("Write how many grams of coffee beans do you want to add: ");
        coffeeBeans += input.nextInt();
        System.out.println("Write how many disposable cups of coffee do you want to add:");
        disposableCups += input.nextInt();
        input.nextLine();
    }

    public static void buy(String i){
        switch(i){
            case "1":
                espresso();
                break;
            case "2":
                latte();
                break;
            case "3":
                cappuccino();
                break;
            case "back":
                break;
        }
    }

    public static void espresso(){

        if(waterML >= 250 && coffeeBeans >= 16) {
            System.out.println("I have enough resources, making you a coffee!");
            waterML -= 250;
            coffeeBeans -= 16;
            money += 4;
            disposableCups--;
        }
        else if(waterML < 250) System.out.println("Sorry, not enough water!");
        else System.out.println("Sorry, not enough coffee beans!");

    }

    public static void latte(){
        if(waterML >= 350 && milkML >= 75 && coffeeBeans >= 20) {
            System.out.println("I have enough resources, making you a coffee!");
            waterML -= 350;
            milkML -= 75;
            coffeeBeans -= 20;
            money += 7;
            disposableCups--;
        }
        else if(waterML < 250) System.out.println("Sorry, not enough water!");
        else if(coffeeBeans < 20) System.out.println("Sorry, not enough coffee beans!");
        else System.out.println("Sorry not enough milk!");
    }

    public static void cappuccino(){
        if(waterML >= 200 && milkML>= 100 && coffeeBeans >= 12) {
            System.out.println("I have enough resources, making you a coffee!");
            waterML -= 200;
            milkML -= 100;
            coffeeBeans -= 12;
            money += 6;
            disposableCups--;
        }
        else if(waterML < 250) System.out.println("Sorry, not enough water!");
        else if(coffeeBeans < 12) System.out.println("Sorry, not enough coffee beans!");
        else System.out.println("Sorry, not enough milk!");
    }

    public static void take(){
        System.out.println("I gave you $" + money + "\n");
        money = 0;
    }
}
