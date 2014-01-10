package pos;

import datamanager.DataManager;

import java.util.List;

public class Driver {

    static POS tempPOS;
    static double cashEntered;
    static int creditNumber;
    static String cashOrCredit;
    static int saleId;
    static List<int[]> tempArrList;
    //CurrentSale tempCurrentSale;

    public static int getSaleId() {
        return saleId;
    }

    public static double getCashEntered() {
        return cashEntered;
    }

    public static String getCashOrCredit() {
        return cashOrCredit;
    }

    public static int getCreditNumber() {
        return creditNumber;
    }

    static void printCartContents() {

        System.out.println("There are " + tempPOS.getWorkingCurrentSale().getCart().getNumberOfItemsInCart() + " items in the cart");
        for (int i = 0; i < tempPOS.getWorkingCurrentSale().getCart().getItemsInCart().size(); i++) {
            System.out.println("Name: " + DataManager.getItemName(tempPOS.getWorkingCurrentSale().getCart().getItemsInCart().get(i)[0]));
            System.out.println("Item: " + (tempPOS.getWorkingCurrentSale().getCart().getItemsInCart().get(i)[0]));
            System.out.println("Number in Cart: " + tempPOS.getWorkingCurrentSale().getCart().getItemsInCart().get(i)[1]);
            System.out.println("Price Per Item: $" + DataManager.getItemPrice(tempPOS.getWorkingCurrentSale().getCart().getItemsInCart().get(i)[0]));
            System.out.println();

        }
        //System.out.println("Subtotal Price for Cart: $" + tempPOS.getWorkingCurrentSale().getCart().getSubTotal());
        //System.out.println("Tax: $" + tempPOS.getWorkingCurrentSale().getCart().getTax());
        //System.out.println("Total Price for Cart: $" + tempPOS.getWorkingCurrentSale().getCart().getTotal());
        //System.out.println("Money Due: $" + tempPOS.getWorkingCurrentSale().getCart().getMoneyDue());
    }

    static void printTotalContents() {
        System.out.println("There are " + tempPOS.getWorkingCurrentSale().getCart().getNumberOfItemsInCart() + " items in the cart");

        System.out.println("Subtotal Price for Cart: $" + tempPOS.getWorkingCurrentSale().getCart().getSubTotal());
        System.out.println("Tax: $" + tempPOS.getWorkingCurrentSale().getCart().getTax());
        System.out.println("Total Price for Cart: $" + tempPOS.getWorkingCurrentSale().getCart().getTotal());
        System.out.println("Money Due: $" + tempPOS.getWorkingCurrentSale().getCart().getMoneyDue());
        System.out.println();
    }

    static void printCheckoutDetails() {
        tempPOS.getWorkingCurrentSale().getCart().getCalcCart();
        if (Driver.getCashOrCredit().equals("credit")) {
            System.out.println("Credit Cart Entered " + tempPOS.getWorkingCurrentSale().getCart().getCalcCart().getCreditCard());
        } else if (Driver.getCashOrCredit().equals("cash")) {
            System.out.println("Cash Recieved " + tempPOS.getWorkingCurrentSale().getCart().getCalcCart().getCashReceived());
        }
        System.out.println("Change Due " + tempPOS.getWorkingCurrentSale().getCart().getCalcCart().getChangeDue());
    }

    public static void main(String[] args) {

        //int itemId, String category, String picture,
        //double price, String itemName, String itemDescription
        DataManager.makeItem(1111, "tempCategory", "tempPicture", 1, "Item1", "tempDescription");
        DataManager.makeItem(1112, "tempCategory", "tempPicture", 2, "Item2", "tempDescription");
        DataManager.makeItem(1113, "tempCategory", "tempPicture", 3, "Item3", "tempDescription");
        DataManager.makeItem(1114, "tempCategory", "tempPicture", 4, "Item4", "tempDescription");
        DataManager.makeItem(1115, "tempCategory", "tempPicture", 5, "Item5", "tempDescription");

        tempPOS = new POS(3);
        tempPOS.newSale();
		//tempPOS.editSale();
        //printTotalContents();

        ////////////////////
        //Add Cart testing//
        ////////////////////
        //Cart.removeItemFromCart(1111);
        //printTotalContents();
        tempPOS.getWorkingCurrentSale().getCart().addItemToCart(1111);

        tempPOS.getWorkingCurrentSale().getCart().addItemToCart(1112);

        tempPOS.getWorkingCurrentSale().getCart().addItemToCart(1113);
        tempPOS.getWorkingCurrentSale().getCart().addItemToCart(1113);
        tempPOS.getWorkingCurrentSale().getCart().removeItemFromCart(1111);
        printCartContents();

        ////////////////////
        //Checkout testing//
        ////////////////////
        System.out.println();

        cashOrCredit = "cash";
        cashEntered = 10.0;
        tempPOS.getWorkingCurrentSale().getCart().checkout();
        printCheckoutDetails();

    }

}
