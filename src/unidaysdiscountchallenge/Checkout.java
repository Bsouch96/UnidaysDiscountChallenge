package unidaysdiscountchallenge;

import java.util.HashMap;

/**
 * <h1>Calculate Pricing</h1>
 * This "Checkout" class is used to add customer items to their basket and calculate their total price.
 * @author Ben Souch
 * @version #1.0
 * @since #1.0
 */
public class Checkout
{
    private StringBuilder purchases;
    private HashMap<String, Double> prices;
    
    /**
     * The Checkout constructor is used to to initialise the prices HashMap with the prices parameter and the purchases to an empty StringBuilder.
     * @param prices This parameter contains a key to value pairing of ItemIDs to prices. If the HashMap itself is null, a String key is null or the HashMap is empty then
     * an IllegalArgumentException is thrown.
     * @throws IllegalArgumentException thrown if the HashMap itself is null, a String key is null or the HashMap is empty.
     * @see IllegalArgumentException
     * @since #1.0
     */
    Checkout(HashMap prices)
    {
        if(prices == null || prices.containsKey(null) || prices.isEmpty())
        {
            throw new IllegalArgumentException("Please ensure the constructor argument is neither empty or null!");
        }
        
        this.prices = prices;
        purchases = new StringBuilder();
    }
    
    /**
     * This method adds valid items to the customers basket. Here we expect the method to reject the item parameter if it is null or doesn't match the regex of [ABCDE].
     * @param item This parameter represents the item the customer wishes to add to their basket. It will be rejected if null or doesn't match the regex of [ABCDE].
     * @return This method returns a String confirming the addition to the customer's basket or rejection of the item request.
     * @since #1.0
     */
    public String addToBasket(String item)
    {
        if(item == null || !item.matches("[ABCDE]"))
        {
            return "Please choose an item of: A, B, C, D or E";
        }
        
        purchases.append(item);
        return "Added to basket!";
    }
    
    /**
     * This method calculates the price based upon the customer additions to the purchases field.
     * @return This method will return immediately if the purchases field is empty to avoid any processing or, after calculations, will return the total price
     * of all the customer items.
     * @since #1.0
     */
    public String calculateTotalPrice()
    {
        if(purchases.length() == 0)
        {
            return "0.00";
        }
        
        double deliveryCharge = 7.00;
        
        //Running total of the number of specific items to apply price logic accordingly in the switch case.
        int itemB = 0;
        int itemC = 0;
        int itemD = 0;
        int itemE = 0;
        double totalPrice = 0;
        
        //Loops through each char in purchases and increments the total accordingly based on the char found in the specified element.
        for (int i = 0; i < purchases.length(); i++)
        {
            switch(purchases.charAt(i))
            {
                case 'A':
                    totalPrice += 8.00;
                    break;
                case 'B':
                    itemB++;
                    if(itemB == 2)
                    {
                        totalPrice += 8.00;
                        itemB = 0;
                    }
                    else
                    {
                        totalPrice += prices.get("B");
                    }
                    break;
                case 'C':
                    itemC++;
                    if(itemC == 3)
                    {
                        totalPrice += 2.00;
                        itemC = 0;
                    }
                    else
                    {
                        totalPrice += prices.get("C");
                    }
                    break;
                case 'D':
                    itemD++;
                    if(itemD == 2)
                    {
                        itemD = 0;
                    }
                    else
                    {
                        totalPrice += prices.get("D");
                    }
                    break;
                case 'E':
                    itemE++;
                    if(itemE == 3)
                    {
                        itemE = 0;
                    }
                    else
                    {
                        totalPrice += prices.get("E");
                    }
                    break;
            }
        }
        
        if(totalPrice < 50.00)
        {
            System.out.println("Delivery charge: £" + String.format("%.2f", deliveryCharge));
            System.out.println("Total item price: £" + String.format("%.2f", totalPrice));
            totalPrice += deliveryCharge;
        }
        else
        {
            System.out.println("Delivery charge: £0.00");
            System.out.println("Total item price: £" + String.format("%.2f", totalPrice));
        }
        
        return String.format("%.2f", totalPrice);
    }
}
