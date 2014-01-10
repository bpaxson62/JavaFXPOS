/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import datamanager.DataManager;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;

/**
 * FXML Controller class
 *
 * @author Elliot
 */
public class POSHelpController implements Initializable {

    private GUI application;
    private ObservableList<String> helpItems = FXCollections.observableArrayList();
    private int selectedItem;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        listViewHelp.getSelectionModel().selectedItemProperty().addListener(
                new ChangeListener<String>() {
                    @Override
                    public void changed(ObservableValue<? extends String> ov, String t, String t1) {
                        String temp = "";
                        System.out.println(listViewHelp.getSelectionModel().getSelectedIndex());
                        switch (listViewHelp.getSelectionModel().getSelectedIndex()){
                            case 0: 
                                temp = "To add an item to the cart, first start a new sale. Next, choose the item"
                                        + " you wish to have by clicking on it in the catalog. In the right pane, "
                                        + "choose the add item button. The cart can be viewed by selecting the "
                                        + "'View Cart' tab.";
                                break;
                            case 1:
                                temp = "Enter the Sale ID in the text box and press the Get Order button. "
                                        + "You can remove items from the order by selecting them and pressing the Remove Selected "
                                        + "button. The new values for price will be reflected at the bottom of the screen. "
                                        + "Press the Checkout button to finalize the order.";
                                break;


                            case 2:
                                temp = "Enter the Sale ID in the text box and press the Get Order button. "
                                        + "You can remove items from the order by selecting them and pressing the Remove Selected "
                                        + "button. The new values for price will be reflected at the bottom of the screen. "
                                        + "Press the Checkout button to finalize the order.";
                                break;

                            case 3:
                                temp = "Sorry, Void Sale not implimented.";
                                break;
                            case 4:
                                temp = "To print a receipt enter the sale ID of the order and press the Get Order button. "
                                        + "Press the print button to print the receipt.";
                                break;
                            case 5:
                                
                        }
                        textAreaHelp.setText(temp);
                    }
                });
    }

    public void setApp(GUI application) {
        this.application = application;
        populateHelpList(listViewHelp);
    }

    @FXML
    private void handleLogOff(ActionEvent event) {
        application.goToLogin();
    }

    @FXML
    private void handleAdmin(ActionEvent event) {
        application.goToAdmin();
    }

    @FXML
    private void handleBackToPOS(ActionEvent event) {
        application.goToPOS();
    }
    
    public void populateHelpList(ListView temp) {
        ListView myListView = temp;
        helpItems.clear();
        myListView.getItems().clear();
     
        helpItems.add("How to Add an Item to Cart");
        helpItems.add("How to Edit a Sale");
        helpItems.add("How to Return an Item");
        helpItems.add("How to Void a Sale");
        helpItems.add("Print a Reciept");
        
        myListView.getItems().addAll(helpItems);
    }
    
    @FXML Label labelCompanyName;
    @FXML Label labelUserName;
	@FXML ListView listViewHelp;
	@FXML TextArea textAreaHelp;
}
