/* ****************************************************************
 * Author: William Disotell 
 * Date: 11/12/2013 
 * Assignment: POS SnowFlake 
 * Class:CEN 3031 
 * Professor: Dr. Anna Koufakou 
 * University: Florida Gulf Coast University
 * xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx 
 * Purpose: Sale Class for DataManager
 * ****************************************************************
 */
package datamanager;

import java.io.Serializable;
import java.util.List;

public class Sale extends File implements Serializable {

    private static final long serialVersionUID = 2798387520218345205L;

    /**
     * ***** Class Constructors ******
     */
    // Default Constructor
    Sale() {

    }

    // Constructor for New Sale or File Creation
    Sale(int saleId, int saleDate, List<int[]> itemsSold, User saleUser, int totalSale, int saleTime) {

        this();
        this.saleId = saleId;
        this.saleDate = saleDate;
        this.itemsSold = itemsSold;
        this.saleUser = saleUser;
        this.totalSale = totalSale;
        this.saleTime = saleTime;

    }

    /**
     * ***** Instance Variables ******
     */
    int saleId; // Sales unique Identifier
    int saleDate; // Date Of Sale
    List<int[]> itemsSold; //Items Sold in the Sale
    User saleUser; //User who Conducted the sale
    int totalSale; // Total Sale Price
    int saleTime; // Time of sale
    //

    /**
     * ***** Instance Methods ******
     */
    // Gets Sale Id
    int getSaleId() {
        return this.saleId;
    }

    // Sets Sale ID
    void setSaleId(int saleId) {
        this.saleId = saleId;
    }

    // Gets Sale Date
    int getSaleDate() {
        return this.saleDate;
    }

    // Sets Sale Date
    void setSaleDate(int saleDate) {
        this.saleDate = saleDate;
    }

    // Gets Items Sold 
    List<int[]> getSaleItemsSold() {
        return this.itemsSold;
    }

    //Gets User who Conducted the sale
    User getSaleUser() {
        return this.saleUser;
    }

    //Sets User who Conducted the sale
    void setSaleUser(User saleUser) {
        this.saleUser = saleUser;
    }

    // Gets Sale Date
    int getTotalSale() {
        return this.totalSale;
    }

    // Sets Sale Date
    void setTotalSale(int totalSale) {
        this.totalSale = totalSale;
    }

    // Gets Sale Time
    int getSaleTime() {
        return this.saleTime;
    }

    // Sets Sale Time
    void setSaleTime(int saleTime) {
        this.saleTime = saleTime;
    }

}
