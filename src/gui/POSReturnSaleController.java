/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import datamanager.DataManager;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

/**
 * FXML Controller class
 *
 * @author Elliot
 */
public class POSReturnSaleController implements Initializable {

    private GUI application;
    private GUI ParentGui;
    private int ID;
    private ObservableList<String> cartItems = FXCollections.observableArrayList();

    public void setParent(GUI temp) {
        ParentGui = temp;
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    public void setApp(GUI application) {
        this.application = application;
    }

    @FXML
    ListView ReturnSaleCart;
    @FXML
    Label ReturnSaleId;

    @FXML
    private void handleCheckout(ActionEvent event) {

    }

    @FXML
    private void handleGetOrder(ActionEvent event) {
        int SaleId = -1;
        try {
            SaleId = Integer.parseInt(ReturnSaleId.getText());
            if (DataManager.getSaleIdIndex(SaleId) != -1) {
                ParentGui.CCpos.getPOS().editSale(SaleId);
                populateCartList(ReturnSaleCart);
                updateTotals();
            } else {
                //ReturnSaleId.setText("Sale Does Not Exist");
            }
        } catch (NumberFormatException e) {
            //ReturnSaleId.setText("Non-Valid Input");
        }
    }

    @FXML
    private void handleRemoveFromReturn(ActionEvent event) {
        // TODO get item id from selected item
        ParentGui.CCpos.getPOS().workingCurrentSale.getCart().removeItemFromCart(ID);
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

    public void populateCartList(ListView temp) {
        ListView myListView = temp;
        cartItems.clear();
        myListView.getItems().clear();
        for (int i = 0; i < ParentGui.CCpos.getPOS().workingCurrentSale.getCart().getItemsInCart().size(); i++) {
            String stringSpacer = "                                                        ";
            int k = (int) DataManager.getItemName(ParentGui.CCpos.getPOS().workingCurrentSale.getCart().getItemsInCart().get(i)[0]).length();
            k = (int) (k * 1.35);
            for (int j = 0; j < k; j++) {
                stringSpacer = stringSpacer.substring(0, stringSpacer.length() - 1);
            }
            cartItems.add(ParentGui.CCpos.getPOS().workingCurrentSale.getCart().getItemsInCart().get(i)[1] + "x                      " + DataManager.getItemName(ParentGui.CCpos.getPOS().workingCurrentSale.getCart().getItemsInCart().get(i)[0]) + stringSpacer + "$" + DataManager.getItemPrice(ParentGui.CCpos.getPOS().workingCurrentSale.getCart().getItemsInCart().get(i)[0]));
        }
        myListView.getItems().addAll(cartItems);
    }

    @FXML
    Label subTotalReturn;
    @FXML
    Label taxReturn;
    @FXML
    Label totalReturn;

    public void updateTotals() {
        subTotalReturn.setText(Double.toString(ParentGui.CCpos.getPOS().workingCurrentSale.getCart().getSubTotal()));
        taxReturn.setText(Double.toString(ParentGui.CCpos.getPOS().workingCurrentSale.getCart().getTax()));
        totalReturn.setText(Double.toString(ParentGui.CCpos.getPOS().workingCurrentSale.getCart().getTotal()));
    }
}
