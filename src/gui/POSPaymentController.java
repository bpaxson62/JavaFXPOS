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
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author elliot
 */
public class POSPaymentController implements Initializable {

    private GUI application;

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
    private void handleFinalizeSale(ActionEvent event) {
    }

    @FXML
    private void handleCash(ActionEvent event) {
    }

    @FXML
    private void handleCredit(ActionEvent event) {
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
    Label labelCompanyName;
    @FXML
    Label labelUserName;
    @FXML
    TextField textFieldCash;
    @FXML
    TextField textFieldCreditCard;
    @FXML
    Label labelAmountPaid;
    @FXML
    Label labelChangeOwed;
}
