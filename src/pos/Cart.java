package pos;

import datamanager.DataManager;
import java.util.*;

public class Cart {

    /**
     * ***** Class Variables ******
     */
    /**
     * ***** Class Constructors ******
     */
    Cart() {
        returning = false;
        subTotal = 0.0;
        total = 0.0;
        tax = 0.06;
        itemsInCart = new ArrayList<int[]>();
        numberOfItemsInCart = 0;
        cc = new CalcCart(this);
    }

    Cart(List<int[]> recievedList) {
        returning = true;
        tax = 0.06;
        itemsInCart = new ArrayList<int[]>();

        for (int j = 0; j < recievedList.size(); j++) {
            itemsInCart.add(new int[]{DataManager.getSaleItemsSold(1).get(j)[0], DataManager.getSaleItemsSold(1).get(j)[1]});
        }

        cc = new CalcCart(this);
        calcNumberOfItemsInCart();
        cc.updatingMath();
    }

    /**
     * ******* Class Methods *********
     */
    /**
     * **** Instance Variables ****
     */
    private double subTotal;
    private double total;
    private double moneyDue;
    private double tax;
    private int numberOfItemsInCart;
    private List<int[]> itemsInCart;
    private CalcCart cc;
    private double oldTotal;
    private boolean returning; //set if return process which will change gui stuff

    /**
     * ******** Instance Methods **********
     */
    public void checkout() {
        //This does gui based stuff
        //switch to a payment screen
    }

    public void clearCart() {
        itemsInCart.clear();
        cc.updatingMath();
        calcNumberOfItemsInCart();
    }

    public void removeItemFromCart(int ID) {
        if (itemsInCart.get(searchCart(ID))[1] == 1) {
            itemsInCart.remove(searchCart(ID));
        } else {
            itemsInCart.get(searchCart(ID))[1]--;
        }
        cc.updatingMath();
        calcNumberOfItemsInCart();
    }

    public void addItemToCart(int ID) {
        if (itemsInCart.size() != 0) { //checks if cart is currently empty
            for (int i = 0; i < itemsInCart.size(); i++) {
                if (itemsInCart.get(i)[0] == ID) { //checks to see if item is already in cart 
                    itemsInCart.get(i)[1] = itemsInCart.get(i)[1] + 1;
                    cc.updatingMath();
                    calcNumberOfItemsInCart();
                    return;
                }
            }
        }
        if (POS.itemExists(ID)) {
            itemsInCart.add(new int[]{ID, 1});
            calcNumberOfItemsInCart();
            cc.updatingMath();
        }
    }

    protected int searchCart(int ID) {
        int i = 0;
        while (i < itemsInCart.size()) {
            if (itemsInCart.get(i)[0] == ID) {
                break;
            }
            i++;
        }
        return i;
    }

    protected void calcNumberOfItemsInCart() {
        int i = 0;
        int total = 0;
        while (i < itemsInCart.size()) {
            total += itemsInCart.get(i)[1];
            i++;
        }
        this.setNumberOfItemsInCart(total);
        return;
    }

    /////////////////////////////////////////////////////////
    /////////////////////Instance Methods////////////////////
    ////////////////////Setters and Getters//////////////////
    /////////////////////////////////////////////////////////
    public void setSubTotal(double value) {
        this.subTotal = value;
    }

    public double getSubTotal() {
        return this.subTotal;
    }

    public double getTax() {
        return tax;
    }

    public void setTotal(double value) {
        this.total = value;
    }

    public double getTotal() {
        return this.total;
    }

    public void setNumberOfItemsInCart(int value) {
        this.numberOfItemsInCart = value;
    }

    public int getNumberOfItemsInCart() {
        return this.numberOfItemsInCart;
    }

    public boolean getReturning() {
        return this.returning;
    }

    public CalcCart getCalcCart() {
        return this.cc;
    }

    public double getOldTotal() {
        return oldTotal;
    }

    public void setOldTotal(double oldTotalTemp) {
        oldTotal = oldTotalTemp;
    }

    public double getMoneyDue() {
        return moneyDue;
    }

    public void setMoneyDue(double moneyDue) {
        this.moneyDue = moneyDue;
    }

    public List<int[]> getItemsInCart() {
        return itemsInCart;
    }

    public void setItemsInCart(List<int[]> itemsInCart) {
        this.itemsInCart = itemsInCart;
    }

}
