/* ****************************************************************
 * Author: William Disotell 
 * Date: 11/12/2013 
 * Assignment: POS SnowFlake 
 * Class:CEN 3031 
 * Professor: Dr. Anna Koufakou 
 * University: Florida Gulf Coast University
 * xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx 
 * Purpose:  DataManager -  For SnowFlake POS
 * ****************************************************************
 */
package datamanager;

import java.io.*;
import java.nio.file.*;

import java.util.Vector;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class DataManager implements Serializable {

    /**
     * ***** Class Variables ******
     */
    // Path for Storing and Reading Files
    static String fileName = "null" + ".ser";
    static Path file = Paths.get(System.getProperty("user.home")).resolve("Desktop").resolve("POSFiles");

    //Vectors of each file type
    public static Vector<Sale> saleObjects = new Vector<Sale>();
    public static Vector<Item> itemObjects = new Vector<Item>();
    public static Vector<User> userObjects = new Vector<User>();

    /**
     * ****File R/W Methods*********
     */
    // All Object Vectors Read/Write 
    public static void readAllFiles() {
        readFiles("users");
        readFiles("items");
        readFiles("sales");
    }

    public static void writeAllFiles() {
        writeFiles("users");
        writeFiles("items");
        writeFiles("sales");
    }

    //userObjects Read/Write 
    public static void readUserFiles() {
        readFiles("users");
    }

    public static void writeUserFiles() {
        writeFiles("users");
    }

    //itemObjects Read/Write 
    public static void readItemFiles() {
        readFiles("items");
    }

    public static void writeItemFiles() {
        writeFiles("items");
    }

    //saleObjects Read/Write 
    public static void readSaleFiles() {
        readFiles("sales");
    }

    public static void writeSaleFiles() {
        writeFiles("sales");
    }

    //General R/W
    static void writeFiles(String type) {

        fileName = type + ".ser";
        file.resolve(fileName);

        try {
            Files.createDirectories(file.getParent());
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }

        try {
            ObjectOutputStream Out = new ObjectOutputStream(
                    new BufferedOutputStream(Files.newOutputStream(file)));
            switch (type) {
                case "users":
                    Out.writeObject(userObjects);
                    break;
                case "items":
                    Out.writeObject(itemObjects);
                    break;
                case "sales":
                    Out.writeObject(saleObjects);
                    break;
                default:
                    break;
            }

            Out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    static void readFiles(String type) {

        fileName = type + ".ser";

        //adds fileName to Path
        file.resolve(fileName);
        try {
            ObjectInputStream objectIn = new ObjectInputStream(
                    new BufferedInputStream(Files.newInputStream(file)));
            switch (type) {
                case "users":
                    userObjects = (Vector<User>) objectIn.readObject();
                    break;
                case "items":
                    itemObjects = (Vector<Item>) objectIn.readObject();
                    break;
                case "sales":
                    saleObjects = (Vector<Sale>) objectIn.readObject();
                    break;
                default:
                    break;
            }
            objectIn.close();
        } catch (ClassNotFoundException e) {
            System.err.println("Class not found.");
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * ****Object Deletion Methods*********
     */
    public static void deleteUser(int userId) {
        userObjects.remove(getUserIdIndex(userId));
    }

    public static void deleteItem(int itemId) {
        itemObjects.remove(getItemIdIndex(itemId));
    }

    public static void deleteSale(int saleId) {
        saleObjects.remove(getSaleIdIndex(saleId));
    }

    /**
     * ****Object Creation Methods*********
     */
    // Creates New Item object and stores it in itemObjects Vector
    public static void makeItem(int itemId, String category, String picture,
            double price, String itemName, String itemDescription) {

        itemObjects.add(new Item(itemId, category, picture, price, itemName,
                itemDescription));
        writeItemFiles();
    }

    // Creates New User object and stores it in userObjects Vector
    public static void makeSale(int saleId, int saleDate,
            List<int[]> itemsSold, int saleUserId, int totalSale, int saleTime) {

        saleObjects.add(new Sale(saleId, saleDate, itemsSold, userObjects.get(getUserIdIndex(saleUserId)),
                totalSale, saleTime));
        writeSaleFiles();
    }

    // Creates New Sale object and stores it in saleObjects Vector
    public static void makeUser(int userId, String userPassword,
            boolean userType, String userName) {
        userObjects.add(new User(userId, userPassword, userType, userName));
        writeUserFiles();
    }

    /**
     * ****Object Index Methods*********
     */
    //Single id
    //Id sent index of UserObject Returned 
    public static int getUserIdIndex(int id) {

        int index = -1;
        for (int i = 0; i < userObjects.size(); i++) {
            if (id == userObjects.get(i).getUserId()) {
                index = i;
                break;
            }
        }
        return index;
    }

    //Id sent index of itemObject Returned 
    public static int getItemIdIndex(int id) {

        int index = -1;
        for (int i = 0; i < itemObjects.size(); i++) {
            if (id == itemObjects.get(i).getItemId()) {
                index = i;
                break;
            }
        }
        return index;
    }

    //Id sent index of saleObject Returned 
    public static int getSaleIdIndex(int id) {

        int index = -1;
        for (int i = 0; i < saleObjects.size(); i++) {
            if (id == saleObjects.get(i).getSaleId()) {
                index = i;
                break;
            }
        }
        return index;
    }

    // returns an array of all ID's
    public static int[] getAllUserIdIndex() {
        int[] temp = new int[userObjects.size()];
        for (int i = 0; i < temp.length; i++) {
            temp[i] = userObjects.get(i).getUserId();
        }
        return temp;
    }

    public static int[] getAllItemIdIndex() {
        int[] temp = new int[itemObjects.size()];
        for (int i = 0; i < temp.length; i++) {
            temp[i] = itemObjects.get(i).getItemId();
        }
        return temp;
    }

    public static int[] getAllSaleIdIndex() {
        int[] temp = new int[saleObjects.size()];
        for (int i = 0; i < temp.length; i++) {
            temp[i] = saleObjects.get(i).getSaleId();
        }
        return temp;
    }

    /**
     * ****Number of each Vector Type*********
     */
    public static int numberOfUsers() {
        return userObjects.size();
    }

    public static int numberOfItems() {
        return itemObjects.size();
    }

    // Gets numberOfSales
    public static int getNumberofSales() {
        return saleObjects.size();
    }

    /**
     * ****GET/SET User instance Variables*********
     */
    // Set/Get User Name
    public static String getUserName(int Id) {
        return userObjects.get(getUserIdIndex(Id)).getUserName();
    }

    public static void setUserName(int Id, String name) {
        userObjects.get(getUserIdIndex(Id)).setUserName(name);
    }

    // Set/Get User Name
    public static String getUserPassword(int Id) {
        return userObjects.get(getUserIdIndex(Id)).getUserPassword();
    }

    public static void setUserPassword(int Id, String password) {
        userObjects.get(getUserIdIndex(Id)).setUserPassword(password);
    }

    // Set/Get User Name
    public static boolean getUserType(int Id) {
        return userObjects.get(getUserIdIndex(Id)).getUserType();
    }

    public static void setUserType(int Id, boolean type) {
        userObjects.get(getUserIdIndex(Id)).setUserType(type);
    }

    /**
     * ****GET/SET Item instance Variables*********
     */
    // Set/Get Item Price
    public static double getItemPrice(int Id) {
        return itemObjects.get(getItemIdIndex(Id)).getItemPrice();
    }

    public static void setItemPrice(int Id, double price) {
        itemObjects.get(getItemIdIndex(Id)).setItemPrice(price);
    }

    // Set/Get Item Name
    public static String getItemName(int Id) {
        return itemObjects.get(getItemIdIndex(Id)).getItemName();
    }

    public static void setItemName(int Id, String name) {
        itemObjects.get(getItemIdIndex(Id)).setItemName(name);
    }

    // Set/Get Item Category
    public static String getItemCategory(int Id) {
        return itemObjects.get(getItemIdIndex(Id)).getItemCategory();
    }

    public static void setItemCategory(int Id, String category) {
        itemObjects.get(getItemIdIndex(Id)).setItemCategory(category);
    }

    // Set/Get Item Picture
    public static String getItemPicture(int Id) {
        return itemObjects.get(getItemIdIndex(Id)).getItemPicture();
    }

    public static void setItemPicture(int Id, String picture) {
        itemObjects.get(getUserIdIndex(Id)).setItemPicture(picture);
    }

    // Set/Get Item Description
    public static String getItemDescription(int Id) {
        return itemObjects.get(getItemIdIndex(Id)).getItemDescription();
    }

    public static void setItemDescription(int Id, String discript) {
        itemObjects.get(getUserIdIndex(Id)).setItemDescription(discript);
    }

    /**
     * ****GET/SET Sale instance Variables*********
     */
    // Set/Get Sale Date
    public static int getSaleDate(int Id) {
        return saleObjects.get(getSaleIdIndex(Id)).getSaleDate();
    }

    public static void setSaleDate(int Id, int date) {
        saleObjects.get(getSaleIdIndex(Id)).setSaleDate(date);
    }

    // Set/Get Sale Time
    public static int getSaleTime(int Id) {
        return saleObjects.get(getSaleIdIndex(Id)).getSaleTime();
    }

    public static void setSaleTime(int Id, int time) {
        saleObjects.get(getSaleIdIndex(Id)).setSaleTime(time);
    }

    // Set/Get Sale Total
    public static int getTotalSale(int Id) {
        return saleObjects.get(getSaleIdIndex(Id)).getTotalSale();
    }

    public static void setTotalSale(int Id, int total) {
        saleObjects.get(getSaleIdIndex(Id)).setTotalSale(total);
    }

    public static List<int[]> getSaleItemsSold(int Id) {
        List<int[]> temp;
        temp = saleObjects.get(getSaleIdIndex(Id)).getSaleItemsSold();
        return temp;
    }

    public static int getSaleUserId(int id) {
        return saleObjects.get(getSaleIdIndex(id)).getSaleUser().getUserId();
    }

    public static void voidSale(int id) {
        saleObjects.remove(getSaleIdIndex(id));
    }
}
