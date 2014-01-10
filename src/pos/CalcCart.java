package pos;

import datamanager.DataManager;

public class CalcCart {

    /**
     * ***** Class Variables ******
     */
    /**
     * ***** Class Constructors ******
     */
    CalcCart(Cart parentCartTemp) {
        creditCard = 0;
        cashReceived = 0.0;
        changeDue = 0.0;
        parentCart = parentCartTemp;
    }

    /**
     * ******* Class Methods *********
     */
    /**
     * **** Instance Variables ****
     */
    private int creditCard;
    private double cashReceived;
    private double changeDue;
    private Cart parentCart;

    /**
     * ***** Instance Methods ******
     */
    protected void checkoutCredit() {
        setCreditCard(Driver.getCreditNumber());
        setChangeDue(0);
    }

    protected void finalizePayment() {
        //need a gui switch that says cash or credit
        if (Driver.getCashOrCredit().equals("credit")) {
            checkoutCredit();
        } else if (Driver.getCashOrCredit().equals("cash")) {
            checkoutCash();
        }
        //return values to POS to make the sale
    }

    protected void checkoutCash() {
        setCashReceived(Driver.getCashEntered());
        setChangeDue(Math.round((cashReceived - parentCart.getMoneyDue()) * 100.0) / 100.0);
    }

    protected void updatingMath() {
        updateSubTotal();
        updateTotal();
        updateMoneyDue();
    }

    protected void updateSubTotal() {
        double temp = 0.0;
        for (int i = 0; i < parentCart.getItemsInCart().size(); i++) {
            temp += DataManager.getItemPrice(parentCart.getItemsInCart().get(i)[0]) * parentCart.getItemsInCart().get(i)[1];
        }
        parentCart.setSubTotal(temp);
    }

    protected void updateTotal() {
        double temp = 0.0;
        temp = parentCart.getSubTotal() + (parentCart.getSubTotal() * parentCart.getTax());
        parentCart.setTotal(temp);
    }

    protected void updateMoneyDue() {

        if (parentCart.getOldTotal() == 1) {
            parentCart.setMoneyDue(parentCart.getTotal());
        } else {
            parentCart.setMoneyDue((Math.round((parentCart.getTotal() - parentCart.getOldTotal()) * 100.0) / 100.0));
        }
    }

    /////////////////////////////////////////////////////////
    /////////////////////Instance Methods////////////////////
    ////////////////////Setters and Getters//////////////////
    /////////////////////////////////////////////////////////
    public int getCreditCard() {
        return creditCard;
    }

    public void setCreditCard(int creditCard) {
        this.creditCard = creditCard;
    }

    public double getCashReceived() {
        return cashReceived;
    }

    public void setCashReceived(double cashReceived) {
        this.cashReceived = cashReceived;
    }

    public double getChangeDue() {
        return changeDue;
    }

    public void setChangeDue(double changeDue) {
        this.changeDue = changeDue;
    }
}
