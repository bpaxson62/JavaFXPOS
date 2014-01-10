
/****************************************************************
 * Author: William Disotell 
 * Date: 11/12/2013 
 * Assignment: POS SnowFlake 
 * Class:CEN 3031 
 * Professor: Dr. Anna Koufakou 
 * University: Florida Gulf Coast University
 * xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx 
 * Purpose: Item Class for DataManager
 * ****************************************************************
 */
package datamanager;

import java.io.Serializable;

public class Item extends File implements Serializable {

    private static final long serialVersionUID = 2354166442148645961L;

    /**
     * ***** Class Constructors ******
     */
    // Default Constructor
    Item() {

    }

    // Constructor for New Item or File Creation
    Item(int itemId, String category, String picture, double price,
            String itemName, String itemDescription) {

        this();
        this.itemId = itemId;
        this.category = category;
        this.picture = picture;
        this.price = price;
        this.itemName = itemName;
        this.itemDescription = itemDescription;
    }

    /**
     * ***** Instance Variables ******
     */
    int itemId; // Items unique Identifier
    String category; // Items category
    String picture; // Items picture address
    double price; // Items Price
    String itemName; // Items Name
    String itemDescription; // Items Description

    /**
     * ***** Instance Methods ******
     */
    // Gets Item Id
    int getItemId() {
        return this.itemId;
    }

    // Sets Items ID
    void setItemId(int itemId) {
        this.itemId = itemId;
    }

    // Sets Items Category
    void setItemCategory(String category) {
        this.category = category;
    }

    // Gets Items Category
    String getItemCategory() {
        return this.category;
    }

    // Sets Items Picture
    void setItemPicture(String picture) {
        this.picture = picture;
    }

    // Gets Items picture
    String getItemPicture() {
        return this.picture;
    }

    // Sets Items Price
    void setItemPrice(double price) {
        this.price = price;
    }

    // Gets Items Price
    double getItemPrice() {
        return this.price;
    }

    // Sets Items Name
    void setItemName(String itemName) {
        this.itemName = itemName;
    }

    // Gets Items Name
    String getItemName() {
        return this.itemName;
    }

    // Sets Items Description
    void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }

    // Gets Items Description
    String getItemDescription() {
        return this.itemDescription;
    }

    //iTEM TOSTRING
    String itemString() {
        return this.toString();
    }

}
