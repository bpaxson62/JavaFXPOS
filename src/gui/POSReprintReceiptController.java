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
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Elliot
 */
public class POSReprintReceiptController implements Initializable {

    private GUI application;
    private GUI ParentGui;

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
    private void handleGetOrder(ActionEvent event) {
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

    @FXML Label labelCompanyName;
    @FXML Label labelUserName;
	@FXML Label labelReceiptPrice;
	@FXML ListView listViewReceipt;
	@FXML TextField textFieldSaleID;
}
