# UnidaysDiscountChallenge
 Unidays Placement Application
 
 
---CHALLENGE OVERVIEW---
Implement a class that processes customer item requests and calculates the total price of all items with due consideration to SOLID principles.


# ---APPROACH---
Initial thoughts:
Implement a menu for choosing items.
Possible multi-dimensional array for the item/price/discount (price rules).
I took some time to think of the simplest way I could implement the price rules whilst maintaining one eye on expandability.
Some consideration for potential edge and corner cases such as null Strings for customer items.


---SOLUTION---
Main Class:
  I decided that implementing a menu for the customer would be the simplest way to navigate the program at runtime where the user could continue to add items to their basket until they decided to pay.
Checkout Class:
  Then I decided upon a HashMap because this appeared to me to be the logical way to maintain items with their respective prices and I could implement the discounts inside of the calculate price once I had all the items the customer wanted.
  Storing the customer items I simply appended to a StringBuilder variable because it is more efficient than using Strings when appending new values which then allowed me to loop through each index as a char and apply the price logic based upon each item I iterated over using the HashMap for the original price.
  Using the HashMap allows for expansion as you can simply add new items to the end of the map.
  Inputs to the "Checkout" class have been validated for edge and corner cases.


---RUNNING---
This solution was implemented in Netbeans using Java.
From command line:
Change directory to the directory that contains the programs source files
To compile: javac *.java
To run: java UnidaysDiscountChallenge


---AUTHOR---
Ben Souch - bksouch96@gmail.com
