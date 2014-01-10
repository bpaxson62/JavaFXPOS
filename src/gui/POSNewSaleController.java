/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;
//

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

//
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
import javafx.scene.control.TextArea;
import pos.POS;

/**
 * FXML Controller class
 *
 * @author Elliot
 */
public class POSNewSaleController implements Initializable {

    private GUI application;
    private GUI ParentGui;
    private int ID;
    private ObservableList<String> catalogItems = FXCollections.observableArrayList();
    private ObservableList<String> cartItems = FXCollections.observableArrayList();
    private int selectedItem;

    public void setParent(GUI temp) {
        ParentGui = temp;
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        listViewNewSaleCatalog.getSelectionModel().selectedItemProperty().addListener(
                new ChangeListener<String>() {
                    @Override
                    public void changed(ObservableValue<? extends String> ov, String t, String t1) {
                        if (true) {
                            selectedItem = listViewNewSaleCatalog.getSelectionModel().getSelectedIndex();
                            labelItemName.setText(DataManager.getItemName(pos.POS.catalog[selectedItem]));
                            labelItemCategory.setText(DataManager.getItemCategory(pos.POS.catalog[selectedItem]));
                            labelItemPrice.setText(String.valueOf(DataManager.getItemPrice(pos.POS.catalog[selectedItem])));
                            textAreaItemDescription.setText(DataManager.getItemDescription(pos.POS.catalog[selectedItem]));
                        }
                        return;
                    }
                });
    }

    public void setApp(GUI application) {
        this.application = application;
        populateCatalogList();
    }

    @FXML
    private void handleAddToCart(ActionEvent event) {
        ParentGui.CCpos.getPOS().workingCurrentSale.getCart().addItemToCart(POS.catalog[selectedItem]);
        populateCartList(listViewNewSaleCart);
        updateTotals();
    }

    @FXML
    private void handleClearCart(ActionEvent event) {
        ParentGui.CCpos.getPOS().workingCurrentSale.getCart().clearCart();
        populateCartList(listViewNewSaleCart);
        updateTotals();
    }

    @FXML
    private void handleRemoveFromCart(ActionEvent event) {
        int selectedItemInCart = listViewNewSaleCart.getSelectionModel().getSelectedIndex();
        if (selectedItemInCart != -1) {
            int Id = ParentGui.CCpos.getPOS().workingCurrentSale.getCart().getItemsInCart().get(selectedItemInCart)[0];
            ParentGui.CCpos.getPOS().workingCurrentSale.getCart().removeItemFromCart(Id);
            populateCartList(listViewNewSaleCart);
            updateTotals();
        }
    }

    @FXML
    private void handleCheckout(ActionEvent event) {
        ParentGui.CCpos.getPOS().workingCurrentSale.getCart().checkout();
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

    @FXML
    ListView listViewNewSaleCatalog;
    @FXML
    ListView listViewNewSaleCart;
    @FXML
    Label labelItemName;
    @FXML
    Label labelItemCategory;
    @FXML
    Label labelItemPrice;
    @FXML
    Label subTotal;
    @FXML
    Label tax;
    @FXML
    Label total;
    @FXML
    TextArea textAreaItemDescription;
    @FXML
    Label labelCompanyName;
    @FXML
    Label labelUserName;

    public void populateCatalogList() {
        catalogItems.clear();
        listViewNewSaleCatalog.getItems().clear();
        for (int i = 0; i < pos.POS.catalog.length; i++) {
            catalogItems.add(DataManager.getItemName(pos.POS.catalog[i]));
        }
        listViewNewSaleCatalog.getItems().addAll(catalogItems);
    }

    public void populateCartList(ListView temp) {
        ListView myListView = temp;
        cartItems.clear();
        myListView.getItems().clear();
        for (int i = 0; i < ParentGui.CCpos.getPOS().workingCurrentSale.getCart().getItemsInCart().size(); i++) {
            String stringSpacer = "                                                                 ";
            int k = (int) DataManager.getItemName(ParentGui.CCpos.getPOS().workingCurrentSale.getCart().getItemsInCart().get(i)[0]).length();
            k = (int) (k * 1.35);
            for (int j = 0; j < k; j++) {
                stringSpacer = stringSpacer.substring(0, stringSpacer.length() - 1);
            }
            cartItems.add(ParentGui.CCpos.getPOS().workingCurrentSale.getCart().getItemsInCart().get(i)[1] + "x                      " + DataManager.getItemName(ParentGui.CCpos.getPOS().workingCurrentSale.getCart().getItemsInCart().get(i)[0]) + stringSpacer + "$" + DataManager.getItemPrice(ParentGui.CCpos.getPOS().workingCurrentSale.getCart().getItemsInCart().get(i)[0]));
        }
        myListView.getItems().addAll(cartItems);
    }

    public void updateTotals() {
        subTotal.setText(Double.toString(ParentGui.CCpos.getPOS().workingCurrentSale.getCart().getSubTotal()));
        tax.setText(Double.toString(ParentGui.CCpos.getPOS().workingCurrentSale.getCart().getTax()));
        total.setText(Double.toString(ParentGui.CCpos.getPOS().workingCurrentSale.getCart().getTotal()));
    }

}
