package pos;

import java.util.List;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class CurrentSale {

    /**
     * ********** Class Variables ***********
     */
    /**
     * ********** Class Constructors **********
     */
    CurrentSale(int saleIdTemp, int saleUserTemp) {
        saleId = saleUserTemp;
        saleUserId = saleIdTemp;
        saleTotal = 0;
        saleCart = new Cart();
    }

    CurrentSale(int saleIdTemp, int saleUserTemp, List<int[]> itemsSoldTemp) {
        saleId = saleUserTemp;
        saleUserId = saleIdTemp;
        itemsSold = itemsSoldTemp;
        saleCart = new Cart(itemsSold);
        saleCart.getCalcCart().updatingMath();
        saleCart.setOldTotal(saleCart.getTotal());
    }

    /**
     * ************ Class Methods **************
     */
    /**
     * ********* Instance Variables *********
     */
    private int saleId;
    private int saleUserId;
    private int typeOfSale;
    private int date;
    private int time;
    private List<int[]> itemsSold;
    private double saleTotal;
    private Cart saleCart;

    /**
     * ********** Instance Methods ***************
     */
    protected void printReceit() {
        // Print to GUI screen eventually
        //System.out.printf("Date: %d %nTime: %d %nSale ID: %d %nEmployee: %s%n %nSale Total: %f %n",
        //	date, timeOfSale, saleID, saleUser, saleTotal);
    }

    public void finalizeSale() {
        saleCart.getCalcCart().finalizePayment();
        try {
            DateFormat dateFormat = new SimpleDateFormat("MMddyyyy");
            date = Integer.parseInt(dateFormat.format(new Date()));
            DateFormat timeFortmat = new SimpleDateFormat("HH:mm");
            time = Integer.parseInt(timeFortmat.format(new Date()));
        } catch (Exception e) {
            System.out.println("Error parsing date");
        }
        itemsSold = saleCart.getItemsInCart();

        POS.passSaleFile();
    }

    /////////////////////////////////////////////////////////
    /////////////////////Instance Methods////////////////////
    ////////////////////Setters and Getters//////////////////
    /////////////////////////////////////////////////////////
    public Cart getCart() {
        return saleCart;
    }

    public int getDate() {
        return date;
    }

    protected void setDate(int date) {
        this.date = date;
    }

    public int getSaleId() {
        return saleId;
    }

    protected void setSaleId(int saleId) {
        this.saleId = saleId;
    }

    public List<int[]> getItemsSold() {
        return itemsSold;
    }

    protected void setItemsSold(List<int[]> itemsSold) {
        this.itemsSold = itemsSold;
    }

    public int getSaleUserId() {
        return saleUserId;
    }

    protected void setSaleUserId(int saleUserId) {
        this.saleUserId = saleUserId;
    }

    public double getSaleTotal() {
        return saleTotal;
    }

    protected void setSaleTotal(double saleTotal) {
        this.saleTotal = saleTotal;
    }

    public int getTypeOfSale() {
        return typeOfSale;
    }

    protected void setTypeOfSale(int typeOfSale) {
        this.typeOfSale = typeOfSale;
    }

}
