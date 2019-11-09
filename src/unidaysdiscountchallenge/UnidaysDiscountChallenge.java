package unidaysdiscountchallenge;

import java.util.HashMap;
import java.util.Scanner;

/**
 * <h1>Main Class Exercises Checkout</h1>
 * This class is used to exercise the "Checkout" class.
 * @author Souchys
 * @since #1.0
 * @version #1.0
 */
public class UnidaysDiscountChallenge
{

    /**
     * <h1>Main Method</h1>
     * This method is used to exercise the "Checkout" class. Here we request to add theoretical items to a basket and request the total for our items.
     * @since #1.0
     */
    public static void main(String[] args)
    {   
        //Create HashMap of items to prices.
        HashMap<String, Double> map = new HashMap<>();
        map.put("A", 8.00);
        map.put("B", 12.00);
        map.put("C", 4.00);
        map.put("D", 7.00);
        map.put("E", 5.00);
        
        Checkout checkout = new Checkout(map);
        Scanner keyboard = new Scanner(System.in);
        boolean quit = false;
        
        //Customer menu.
        do
        {
            System.out.println("Press:\n1. Shop\n2. Calculate Total and quit");
            String menuChoice = keyboard.next();
            
            switch(menuChoice)
            {
                case "1":
                    System.out.println("Please choose an item from the menu:");
                    System.out.println("Item: A\tPrice: 8.00");
                    System.out.println("Item: B\tPrice: 12.00");
                    System.out.println("Item: C\tPrice: 4.00");
                    System.out.println("Item: D\tPrice: 7.00");
                    System.out.println("Item: E\tPrice: 5.00\n");
                    String shopChoice = keyboard.next();
                    System.out.println(checkout.addToBasket(shopChoice));
                    break;
                case "2":
                    System.out.println("Thankyou for shopping with us today! Your total is: £" + checkout.calculateTotalPrice());
                    quit = true;
                    break;
                default:
                    System.out.println("Please choose an appropriate menu choice!");
            }
        }while(quit == false);
    }
    
}
