/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import datamanager.DataManager;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import pos.*;

/**
 * FXML Controller class
 *
 * @author Elliot
 */
public class POSChoiceController implements Initializable {

    private GUI application;
    public POS temp;
    int saleUserID;

 
    
    public POS getPOS() {
        return temp;
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        saleUserID = 1;
        temp = new POS(saleUserID);
    }

    public void setApp(GUI application) {
       
        this.application = application;

    }
    
    @FXML
    public void EXIT2(ActionEvent event){
        application.closeGUI();
    }

    @FXML
    private void handlePOSNewSale(ActionEvent event) {
        temp.newSale();
        application.goToPOSNewSale();
    }

    @FXML
    private void handlePOSReturnSale(ActionEvent event) {
        //application.goToPOSReturnSale();
        application.goToPOSEditSale();
    }

    @FXML
    private void handlePOSEditSale(ActionEvent event) {
        application.goToPOSEditSale();
    }

    @FXML
    private void handlePOSVoidSale(ActionEvent event) {
        //temp.voidSale();
        application.goToPOSVoidSale();
    }

    @FXML
    private void handlePOSReprintReceipt(ActionEvent event) {
        // temp.reprintSale();
        application.goToPOSReprintReceipt();
    }

    @FXML
    private void handlePOSHelp(ActionEvent event) {
        application.goToPOSHelp();
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
    Label labelUserName;
}
