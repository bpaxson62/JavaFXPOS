/* ****************************************************************
 * Author: William Disotell 
 * Date: 11/12/2013 
 * Assignment: POS SnowFlake 
 * Class:CEN 3031 
 * Professor: Dr. Anna Koufakou 
 * University: Florida Gulf Coast University
 * xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx 
 * Purpose:  Login Program -  For SnowFlake POS
 * ****************************************************************
 */
package login;

import datamanager.DataManager;

public class Login {
    public static boolean userType;
   
    Login() {

    }

    public static boolean checkPW(String password, String userIdString) {
        boolean validCheck = false;
        String realPassword = null;
        
        int userId;

        if (DataManager.numberOfUsers() == 0) {
            DataManager.makeUser(1, "1", true,"Admin");
            
            validCheck = true;
            return validCheck;
            
        }

        try {
            userId = Integer.parseInt(userIdString);
            userType = datamanager.DataManager.getUserType(userId);
            
            realPassword = DataManager.getUserPassword(userId);
            if (realPassword.equals(password)) {
                validCheck = true;
            }
        } catch (NumberFormatException e) {
        }

        return validCheck;
    }

}
