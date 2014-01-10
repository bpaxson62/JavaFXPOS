/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import admincontrol.*;
import java.io.IOException;
import javafx.stage.FileChooser;
import javafx.stage.Window;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javafx.beans.value.ChangeListener;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.Image;
import javax.imageio.ImageIO;
import datamanager.*;
import login.Login;

/**
 * FXML Controller class
 *
 * @author Brian
 */
public class AdminController extends AnchorPane implements Initializable {
    private GUI application;
    private Window stage;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    /*
     * Tab 1
     * Add Item
     */
/*
     * Tab 1
     * Add Item
     */

    @FXML TextField setItem;
    @FXML TextField setId;
    @FXML TextField setPrice;
    @FXML TextField setQuantity;
    @FXML TextArea  setDescription;
    @FXML ComboBox setCategoryList; 
    @FXML ImageView editImage;
    String Picture = null;
    @FXML Label addItemLabel1;
     

    //creates an item
    @FXML
    private void createItem(ActionEvent event) throws IOException {
        String ItemName;
        int ItemId;
        double ItemPrice;
        String ItemQuantity;
        String ItemCategory;
        String ItemDescription;       
        //File file1 = new File("myFile");
        
        
        try{
            addItemLabel1.setText("State: No change!");
            ItemName = (setItem.getText());
            ItemId = Integer.parseInt(setId.getText());
            ItemPrice = Double.parseDouble(setPrice.getText());
            //ItemQuantity = setQuantity.getText();
            ItemCategory = (String) setCategoryList.getValue();
            ItemDescription  = setDescription.getText();
            
            /*System.out.println(ItemDescription+" ItemDescription "+ ItemName+
                    " ItemName "+ ItemPrice+
                    " ItemPrice "+ Picture+" Picture "+ ItemCategory+
                    " ItemCategory "+ ItemId + " ItemId ");*/
            ItemManager.createItem( ItemDescription,  ItemName,  ItemPrice,  Picture,  ItemCategory,  ItemId);
            addItemLabel1.setText("State: Success!");
        }
        catch(NumberFormatException e){
            //getDescription.appendText("Please enter an integer or double in the number fields");
        }
    }
    

   //browse for image
    @FXML
    private void browseImages(ActionEvent event) {
        
        //ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        //String myPath = "SnowflakePOS/src/gui/pictures/";
        //String newPath = getClass().getClassLoader().getResource(myPath).getPath();
        //String filePath = servletRequest.getContextPath().getRealPath(myPath);
        //String path = classLoader.getResource("SnowflakePOS/src/gui/pictures").getPath();
        FileChooser fileChoose = new FileChooser();
        setPicturesOnly(fileChoose);
        fileChoose.setTitle("Open a picture");
        File file = fileChoose.showOpenDialog(stage);
        List<Image> image = new ArrayList<>();

        //Image image = new Image( file.getAbsolutePath()/*file.getPath()*/);
        //editImage.setImage(image.get(0));
       
            //\SnowflakePOS\Pictures\
        //  File newFile = fileChoose.showSaveDialog(stage);
            //File newFile = new File(newPath);
          // System.out.println(newFile.getAbsolutePath());
            if (file != null) {
                try {
                    Picture = file.getName();                
                    image.add(new Image("file:" + file.getAbsolutePath(), 200, 200, true, true));
                    editImage.setImage(image.get(0));
                    
                    File newFile = fileChoose.showSaveDialog(stage);
                    if(newFile != null){
                    //System.out.println(newFile.getAbsolutePath());
                        ImageIO.write(SwingFXUtils.fromFXImage(editImage.getImage(),
                            null), "jpg", newFile);
                     }
                }
                        catch (IOException ex) {
                        System.out.println(ex.getMessage());
                }
            }                         
    }
    
    
    private void setPicturesOnly(FileChooser fileChoose){
        fileChoose.setTitle("View Pictures");
        fileChoose.setInitialDirectory(new File(System.getProperty("user.home")));        
        
        fileChoose.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("All Images", "*.*"),
                new FileChooser.ExtensionFilter("JPG", "*.jpg"),
                new FileChooser.ExtensionFilter("PNG", "*.png")
            );
    }
    
    /* 
     * Tab 2
     * Edit Item
     */
    
    @FXML TextField getItem;
    @FXML TextField getId;
    @FXML TextField getPrice;
    @FXML TextField getQuantity;
    @FXML TextField searchBox;
    @FXML TextArea  getDescription;
    @FXML ComboBox getCategoryList; 
    @FXML ImageView editImage2;
    private int tempId;
    @FXML Label addItemLabel2;
    @FXML
    private void editItem(ActionEvent event) {
        try{
            tempId = Integer.parseInt(searchBox.getText());
            addItemLabel2.setText("State: No change!");
            datamanager.DataManager.setItemName(tempId, getItem.getText());
            datamanager.DataManager.setItemPrice(tempId, Double.parseDouble(getPrice.getText()));
            datamanager.DataManager.setItemDescription(tempId, getDescription.getText());
            datamanager.DataManager.setItemName(tempId, getItem.getText());
            //datamanager.DataManager.setItemCategory(tempId, (String) getCategoryList.getValue());
            addItemLabel2.setText("State: Success!");
        }
        catch(NumberFormatException e){addItemLabel2.setText("State: Please enter an int or double!"); }
    }

    @FXML
    private void searchItems(ActionEvent event) {
            
            try{
            System.out.println("4t34t34"+DataManager.numberOfItems());
            tempId = Integer.parseInt(searchBox.getText());
            getItem.setText(datamanager.DataManager.getItemName(tempId));
            getId.setText(String.valueOf(tempId));              
            getPrice.setText(String.valueOf(datamanager.DataManager.getItemPrice(tempId)));                           
            //getCategoryList.setValue(String.valueOf(datamanager.DataManager.getItemCategory(tempId)));   
            getDescription.setText(String.valueOf(datamanager.DataManager.getItemDescription(tempId)));
            }
            catch(NumberFormatException |ArrayIndexOutOfBoundsException e){
                
            }
            
    }

    @FXML
    private void deleteItem(ActionEvent event) {
        datamanager.DataManager.deleteItem(Integer.parseInt(getId.getText()));
    }
    
    @FXML
    private void browseImages2(ActionEvent event) {
        
        //ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        //String myPath = "SnowflakePOS/src/gui/pictures/";
        //String newPath = getClass().getClassLoader().getResource(myPath).getPath();
        //String filePath = servletRequest.getContextPath().getRealPath(myPath);
        //String path = classLoader.getResource("SnowflakePOS/src/gui/pictures").getPath();
        FileChooser fileChoose = new FileChooser();
        setPicturesOnly(fileChoose);
        fileChoose.setTitle("Open a picture");
        File file = fileChoose.showOpenDialog(stage);
        List<Image> image = new ArrayList<>();

        //Image image = new Image( file.getAbsolutePath()/*file.getPath()*/);
        //editImage.setImage(image.get(0));
       
            //\SnowflakePOS\Pictures\
        //  File newFile = fileChoose.showSaveDialog(stage);
            //File newFile = new File(newPath);
          // System.out.println(newFile.getAbsolutePath());
            if (file != null) {
                try {
                    Picture = file.getName();                
                    image.add(new Image("file:" + file.getAbsolutePath(), 200, 200, true, true));
                    editImage2.setImage(image.get(0));
                    
                    File newFile = fileChoose.showSaveDialog(stage);
                    if(newFile != null){
                    //System.out.println(newFile.getAbsolutePath());
                        ImageIO.write(SwingFXUtils.fromFXImage(editImage2.getImage(),
                            null), "jpg", newFile);
                     }
                }
                        catch (IOException ex) {
                        System.out.println(ex.getMessage());
                }
            }                         
    }

    /* 
     * Tab 3
     * Edit Users
     */
    @FXML TextField searchBox2;
    @FXML TextField getName;
    //@FXML TextField getUserId;
    @FXML PasswordField getPassword;
    @FXML CheckBox adminAccess;
    @FXML ListView userList;
    private int tempId2;
    @FXML Label addUserLabel1;
    @FXML TextField setUserId;
    
    @FXML
    private void searchUsers(){
        tempId2 = Integer.parseInt(searchBox2.getText());
        System.out.println("4t34t34"+DataManager.numberOfUsers());
        getName.setText(datamanager.DataManager.getUserName(tempId2));
        //getUserId.setText(null);
        getPassword.setText(datamanager.DataManager.getUserPassword(tempId2));
        boolean myBool = datamanager.DataManager.getUserType(tempId2);
        if(myBool == true){
            adminAccess.setSelected(true);
        }
        else{
            adminAccess.setSelected(false);
        }
        
        
    }
    
   @FXML
    private void createUser(ActionEvent event){
       try{
            addUserLabel1.setText("State: No change!");
            int id = Integer.parseInt(setUserId.getText());
            String userName = getName.getText();
            String pw = getPassword.getText();
            boolean bool = adminAccess.isSelected();
            datamanager.DataManager.makeUser( id, pw, bool, userName);
            addUserLabel1.setText("State: Success!");
       }
            catch(NumberFormatException e){addUserLabel1.setText("State: Error!!");}
   }
    
    @FXML
    private void saveUser(ActionEvent event) {
        try{
            tempId2 = Integer.parseInt(searchBox2.getText());
            addUserLabel1.setText("State: No change!");
            String name = getName.getText();
            //int id = Integer.parseInt(getUserId.getText());         
            String password = getPassword.getText();
            boolean privledges = adminAccess.isSelected();
            datamanager.DataManager.setUserName(tempId2, name);
            datamanager.DataManager.setUserPassword(tempId2, name);
            datamanager.DataManager.setUserType(tempId2, privledges);
           
            //datamanger.saveUser(name, id, privledges, password);
            addUserLabel1.setText("State: Success!");
        }
        catch (NumberFormatException e){ addUserLabel1.setText("State: Error!"); }
        
    }

    @FXML
    private void deleteUser(ActionEvent event) {
        try{
            datamanager.DataManager.deleteUser(Integer.parseInt(searchBox2.getText()));
            addUserLabel1.setText("State: Deleted!!");
        }
        catch(NumberFormatException | ArrayIndexOutOfBoundsException e){addUserLabel1.setText("State: Error!!"); }
    }
    
    /*
     * Tab 4
     * Create Category 
     */
    @FXML TextField getCatName;
    @FXML TextField getCatId;
    @FXML TextField searchBox3;
    @FXML ListView catList;
    //@FXML ComboBox getCategoryList;
    
     /*
     *save category 
     */
    
    
    @FXML
    private void saveCategory(ActionEvent event) {
        CategoryManager.setCategory(getCatName.getText());
        populateCatList();
    }
    
     /*
     * 
     */
    
    
    @FXML
    private void createCategory(ActionEvent event){
        
    }
    @FXML
    private void deleteCategory(ActionEvent event) {
        CategoryManager.deleteCategory(getCatName.getText());
        populateCatList();
    }

     /*
     * search for category 
     */
    
    
    @FXML
    private void searchCat(ActionEvent event) {
        
        getCatName.setText(datamanager.DataManager.getItemCategory(Integer.parseInt(searchBox3.getText())));
        getCatId.setText(searchBox3.getText());
        populateCatList();
        
       //String myString =  (String) catList.getSelectedItems();
       //System.out.println(myString);
    }
   
     /*
     *populates category list if implemented 
     */
    
    private void populateCatList(){
        
        //catList.clear();
        catList.getItems().clear();
        int[] myArray = datamanager.DataManager.getAllUserIdIndex();
        for (int i = 0; i < myArray.length; i++) {
        if(!catList.getItems().contains(DataManager.getItemCategory(myArray[i]))){  
            catList.getItems().add(DataManager.getItemCategory(myArray[i]));
        }
        }	
        
        setCategoryList.getItems().clear();
        //int[] myArray2 = datamanager.DataManager.getAllUserIdIndex();
        for (int i = 0; i < myArray.length; i++) {
        if(!setCategoryList.getItems().contains(DataManager.getItemCategory(myArray[i]))){  
            setCategoryList.getItems().add(DataManager.getItemCategory(myArray[i]));
        }
        }
        
         getCategoryList.getItems().clear();
        //int[] myArray2 = datamanager.DataManager.getAllUserIdIndex();
        for (int i = 0; i < myArray.length; i++) {
        if(!getCategoryList.getItems().contains(DataManager.getItemCategory(myArray[i]))){  
            getCategoryList.getItems().add(DataManager.getItemCategory(myArray[i]));
        }
        }
        
        
        
        /*
         * Code not implemented yet
         */
        
        //catList.getItems().addAll(catalogItems);
        
        /*catList.getItems().addAll(
            "Beep",
            "Bop Bop",
            "Badop Bope",
            "Bah Bah Bah Bee Bap Bap",
            "Baad dap Bope"  
        );
        setCategoryList.getItems().addAll(
            "Beep",
            "Bop Bop",
            "Badop Bope",
            "Bah Bah Bah Bee Bap Bap",
            "Baad dap Bope"  
        );
        for(int i =0; i<CategoryManager.getCategories().size(); i++){
            catList.getItems().add(i);//catList.getItems(getCategories())
        }*/
    }
     /*
     * Tab 5
     * View Inventory
     */
//    @FXML TextField itemId;
//    @FXML TextField itemName;
//    @FXML TextField itemCat;
//    @FXML ListView inventoryList;
//    
//    @FXML
//    private void searchInventory(ActionEvent event) {
//        
//    }
//    
//    private void populateInventory(){
//        /*for(int i =0; i<InventoryManager.getInventory().size(); i++){
//            inventoryList.getItems().add(i);
//        }*/
//    }
//     /*
//     * Tab 6
//     * Sales Reports
//     */
//    @FXML ComboBox salesDateBox;
//    @FXML TextArea salesReport;
//    
//    private void populateReport(){
//        
//    }
     /*
     * Tab 7
     * Store Info
     */
//    @FXML TextField setStoreName;
//    @FXML TextField setStoreId;
//    @FXML TextField setStoreTax;
//    @FXML Label companyName;
//    
//    @FXML
//    private void setStoreInfo(ActionEvent event) {
//        
//    }
    
    
    
     /*
     * Tab 8
     * Help
     */
//    @FXML ListView helpList;
    @FXML TextArea helpDisplay;
    @FXML
    public void selectUser(ActionEvent event){
        helpDisplay.setText("Helllo!");
    }
//    public void populateHelp(){
//        /*helpList.getItems().addAll(
//            "Beep",
//            "Bop Bop",
//            "Badop Bope",
//            "Bah Bah Bah Bee Bap Bap",
//            "Baad dap Bope"  
//        );*/
//        /*ObservableList<String> listViewData = FXCollections.observableArrayList();
//        helpList.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Person>() {
//        @Override
//        public void changed(ObservableValue<? extends Person> observable,
//          Person oldValue, Person newValue) {
//      
//      outputTextArea.appendText("ListView Selection Changed (newValue: " + newValue + ")\n");
//  }
//});*/
//    }
    /*
     * Main Admin Interface
     */

    /*
     * Exits program
     */
    
    @FXML
    private void EXIT(ActionEvent event){
        //datamanager.DataManager.writeAllFiles();
        application.closeGUI();
        //System.exit(1);
    }
    
    @FXML
    private void handlePOS(ActionEvent event) {
        application.goToPOS();
    }

    @FXML
    private void handleLogOff(ActionEvent event) {
        application.goToLogin();
    }
    
     void setApp(GUI aThis) {
        this.application = aThis;
        populateCatList();
       
        
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}