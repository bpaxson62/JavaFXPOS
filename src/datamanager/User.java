 /* ****************************************************************
 * Author: William Disotell 
 * Date: 11/12/2013 
 * Assignment: POS SnowFlake 
 * Class:CEN 3031 
 * Professor: Dr. Anna Koufakou 
 * University: Florida Gulf Coast University
 * xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx 
 * Purpose: User Class for DataManager
 * ****************************************************************
 */
package datamanager;

import java.io.Serializable;
import java.util.Vector;

public class User extends File implements Serializable {

    private static final long serialVersionUID = 4687197442510181096L;

    /**
     * ***** Class Constructors ******
     */
    /**
     * ***** Default Constructor ******
     */
    User() {

    }

    // Constructor for Creation of Users from File 
    User(int userId, String userPassword, boolean userType, String userName, Vector<Sale> salesReports) {
        this();
        this.userId = userId;
        this.userPassword = userPassword;
        this.userType = userType;
        this.userName = userName;
        this.salesReports = salesReports;
    }

    // Constructor for New User
    User(int userId, String userPassword, boolean userType, String userName) {
        this();
        this.userId = userId;
        this.userPassword = userPassword;
        this.userType = userType;
        this.userName = userName;
    }

    /**
     * ***** Instance Variables ******
     */
    int userId; // Users unique Identifier
    String userPassword; // Password for user
    String userName; // Name of User

    // Determines if User is an Admin
    boolean userType; // (True=Admin User :: False=Regular User)

    // Used To Store All Sales that user conducts
    Vector<Sale> salesReports = new Vector<Sale>();

    int numberOfSales = this.salesReports.size();

    /**
     * ***** Instance Methods ******
     */
    // Sets User Id
    void setUserId(int userId) {
        this.userId = userId;
    }

    // Gets User Id
    public int getUserId() {
        return this.userId;
    }

    // Sets User Password
    void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    // Gets User Password
    String getUserPassword() {
        return this.userPassword;
    }

    // Sets User Type
    void setUserType(boolean userType) {
        this.userType = userType;
    }

    // Gets User Type
    boolean getUserType() {
        return this.userType;
    }

    // Sets User Name
    void setUserName(String userName) {
        this.userName = userName;
    }

    // Gets User Name
    String getUserName() {
        return this.userName;
    }

    // Adds Sale to salesReports
    void AddSale(Sale Sale) {
        this.salesReports.add(Sale);
    }

    // Gets User salesReports
    Vector<Sale> getUser() {
        return this.salesReports;
    }

    int getnumberOfSales() {
        return this.numberOfSales;
    }

}
