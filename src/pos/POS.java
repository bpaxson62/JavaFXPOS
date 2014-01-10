package pos;

import datamanager.DataManager;

public class POS {

    /**
     * ***** Class Variables ******
     */
    public static int[] catalog;

    /**
     * ***** Class Constructors ******
     */
    public POS(int saleUserId) {
        catalog = DataManager.getAllItemIdIndex();
    }

    /**
     * ******* Class Methods *********
     */
    public static boolean itemExists(int Id) {
        boolean check = false;
        for (int i = 0; i < catalog.length; i++) {
            if (catalog[i] == Id) {
                check = true;
            }
        }
        return check;
    }

    static void passSaleFile() {
        /**
         * **NOTE: TODO DATE AS STRING NOT INT *
         */

        /**
         * **NOTE: TODO Sending my List<int[]> *
         */
        //(int saleId, int saleDate, Vector<Item> itemsSold, User saleUser, int totalSale, int saleTime)
        //DataManager.makeSale(workingCurrentSale.getSaleId(),workingCurrentSale.getDate(),workingCurrentSale.get);
    }

    /**
     * **** Instance Variables ****
     */
    private int saleUserId;
    private int saleId;
    private int workingSaleType;
    public CurrentSale workingCurrentSale;

    /**
     * ***** Instance Methods ******
     */
    public void newSale() {
        saleId = Driver.getSaleId() + 1;
        workingSaleType = 1;
        workingCurrentSale = new CurrentSale(saleId, saleUserId);
    }

    public void editSale(int Id) {
        saleId = Id;
        workingSaleType = 2;
        workingCurrentSale = new CurrentSale(saleId, DataManager.getSaleUserId(saleId), DataManager.getSaleItemsSold(saleId));
    }

    public void returnSale(int Id) {
        workingSaleType = 3;
        int oldSaleId = Id;
        workingCurrentSale = new CurrentSale(oldSaleId, DataManager.getSaleUserId(oldSaleId), DataManager.getSaleItemsSold(oldSaleId));
    }

    public void voidSale() {
        // int oldSaleId = GUI.readBox();
        DataManager.voidSale(Driver.getSaleId());
    }

    public void reprintSale() {
        saleId = Driver.getSaleId();
        //workingCurrentSale = Driver.getSale(saleId); //returns sale object of saleId with parentPOS set to this
        workingCurrentSale.printReceit();
    }

    /////////////////////////////////////////////////////////
    ////////////////////Setters and Getters//////////////////
    /////////////////////////////////////////////////////////
    public int getWorkingSaleType() {
        return workingSaleType;
    }

    public CurrentSale getWorkingCurrentSale() {
        return workingCurrentSale;
    }

}
