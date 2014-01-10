
package admincontrol;

import datamanager.DataManager;

/**
 * Class will manage reports, constructor takes in parameters to set the reports fields
 * 
 */

public class ReportsManager {

    ReportsManager(int date, int saleID, String[] itemsSold, String[] salesUser, int saleTotal, int timeOfSale) {
        ReportsManager ReportsManager_obj = null;
        ReportsManager_obj.reports(date, saleID, itemsSold, salesUser, saleTotal, timeOfSale);
    }

    public void dateSold() {

    }

    public void sales() {

    }

    public void userSales() {

    }

    public void reports(int date1, int saleID1, String[] itemsSold1, String[] salesUser1, int saleTotal1, int timeOfSale1) {
        int date = date1;
        int saleID = saleID1;
        String[] itemsSold = itemsSold1;
        String[] salesUser = salesUser1;
        int salesTotal1 = saleTotal1;
        int timeOfsale = timeOfSale1;

    }
}
