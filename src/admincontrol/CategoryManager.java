
package admincontrol;

import datamanager.DataManager;
import java.util.ArrayList;
import java.util.List;

/**
 * Class will manage categories, categories put into array list called strings1
 * 
 */
public class CategoryManager {

    private static List<String> strings1 = new ArrayList<>();
    //sets categories with new category addedto the arraylist
    public static void setCategory(String newCat) {
        strings1.add(newCat);
    }
    //will remove the mataching category in the parameter
    public static void deleteCategory(String deleteCat) {
        strings1.remove(deleteCat);
    }
    //getter for returning the list of categories
    public static List<String> getCategories() {
        return strings1;
    }
    //searches for category name in the arrray list using the constains method
    public static void searchCat(String searchFor) {
        strings1.contains(searchFor);
    }
}
