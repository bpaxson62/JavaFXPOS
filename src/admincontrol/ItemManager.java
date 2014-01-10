/****************************************************************
 * Author: Geoffrey Kuhn 
 * Date: 11/7/2013 
 * Assignment: POS SnowFlake 
 * Class:CEN 3031 
 * Professor: Dr. Anna Koufakou 
 * University: Florida Gulf Coast University
 * xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx 
 * Purpose: Category Manager for admin control class
 * ****************************************************************
 */
package admincontrol;

import gui.AdminController;
import datamanager.DataManager;
import java.util.ArrayList;
import java.util.List;

public class ItemManager {

    ItemManager(String description, String ItemName, double price, String picture, String category, int idNumber) {
        //empty constructor for initialization
    }

    public static void createItem(String ItemDescription, String ItemName, double ItemPrice, String Picture, String ItemCategory, int ItemId) {
        // calls the database will set paramets with the fx:id in Java FX
        DataManager.makeItem(ItemId, ItemCategory, Picture, ItemPrice, ItemName, ItemDescription);
    }

    public static void editItem(String ItemDescription, String ItemName, double ItemPrice, String Picture, String ItemCategory, int ItemId) {

        //DataManager.edititem(ItemId,ItemCategory, Picture,ItemPrice,ItemName,ItemDescription);//edit items needs ot be implemented
    }

    public static void search(String searchFor) {

        //DataManager.searchItem(searchFor);
    }

    public static void deleteItem(String deleteThis) {
        //DataManager.searchItem(deleteThis);
    }
}
