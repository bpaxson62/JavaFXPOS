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
import javafx.scene.control.TextField;
import datamanager.DataManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

/**
 * FXML Controller class
 *
 * @author Elliot
 */
public class POSEditSaleController implements Initializable {

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
    }

    public void setApp(GUI application) {
        this.application = application;
    }

    @FXML
    private void handleCheckout(ActionEvent event) {
        ParentGui.CCpos.getPOS().workingCurrentSale.getCart().checkout();
    }

    @FXML
    TextField EditSaleId;
    @FXML
    ListView EditSaleCart;

    @FXML
    private void handleGetOrder(ActionEvent event) {
        int SaleId = -1;
        try {
            SaleId = Integer.parseInt(EditSaleId.getText());
            if (DataManager.getSaleIdIndex(SaleId) != -1) {
                ParentGui.CCpos.getPOS().editSale(SaleId);
                populateCartList(EditSaleCart);
                updateTotals();
            } else {
                EditSaleId.setText("Sale Does Not Exist");
            }
        } catch (NumberFormatException e) {
            EditSaleId.setText("Non-Valid Input");
        }

    }

    @FXML
    private void handleRemoveFromSale(ActionEvent event) {
        int selectedItemInCart = EditSaleCart.getSelectionModel().getSelectedIndex();
        if (selectedItemInCart != -1) {
            int Id = ParentGui.CCpos.getPOS().workingCurrentSale.getCart().getItemsInCart().get(selectedItemInCart)[0];
            ParentGui.CCpos.getPOS().workingCurrentSale.getCart().removeItemFromCart(Id);
            populateCartList(EditSaleCart);
            updateTotals();
        }
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
    Label subTotalEdit;
    @FXML
    Label taxEdit;
    @FXML
    Label totalEdit;
    @FXML
    Label labelCompanyName;
    @FXML
    Label labelUserName;

    public void updateTotals() {
        subTotalEdit.setText(Double.toString(ParentGui.CCpos.getPOS().workingCurrentSale.getCart().getSubTotal()));
        taxEdit.setText(Double.toString(ParentGui.CCpos.getPOS().workingCurrentSale.getCart().getTax()));
        totalEdit.setText(Double.toString(ParentGui.CCpos.getPOS().workingCurrentSale.getCart().getTotal()));
    }
}
