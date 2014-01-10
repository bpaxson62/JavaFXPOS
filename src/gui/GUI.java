/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import datamanager.DataManager;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import login.Login;

/**
 * *
 *
 * @author Brian
 */
public class GUI extends Application {

    private Stage stage;
    public Dimension d;
    public POSChoiceController CCpos;
    public POSNewSaleController NSCpos;

    @Override
    public void start(Stage stage1) throws Exception {
        //Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
        //Scene scene = new Scene(root);
        stage = stage1;
        //stage.setScene(scene);
        //stage.setMinWidth(MINIMUM_WINDOW_WIDTH);
        //stage.setMinHeight(MINIMUM_WINDOW_HEIGHT);
        //stage.setFullScreen(true);
        Toolkit tk = Toolkit.getDefaultToolkit();
        d = tk.getScreenSize();
        stage.show();
        //DataManager.readAllFiles();
        DataManager.makeUser(1, "1", true, "1");
        //DataManager.readAllFiles();
        goToLogin();
        /*
        DataManager.makeItem(1111, "tempCategory", "tempPicture", 1, "This is Item 1", "tempDescription");
        DataManager.makeItem(1112, "tempCategory", "tempPicture", 2, "Item 2", "tempDescription");
        DataManager.makeItem(1113, "tempCategory", "tempPicture", 3, "Item 3", "tempDescription");
        DataManager.makeItem(1114, "tempCategory", "tempPicture", 4, "Item4", "tempDescription");
        DataManager.makeItem(1115, "tempCategory", "tempPicture", 5, "Item5", "tempDescription");
        */
        List<int[]> tempArray = new ArrayList<int[]>();
        tempArray.add(new int[]{1111, 2});
        tempArray.add(new int[]{1113, 5});
        DataManager.makeSale(1, 12092013, tempArray, 1, 10, 107);
        //DataManager.makeSale(saleId, saleDate, null, null, totalSale, saleTime); 
    }

     
    public void goToLogin() {
        try {
            LoginController login = (LoginController) replaceSceneContent("Login.fxml");
            login.setApp(this);
        } catch (Exception e) {
        }
    }

    public void goToPOS() {
        try {           
            CCpos = (POSChoiceController) replaceSceneContent("POSChoice.fxml");
            CCpos.setApp(this);
        } catch (Exception e) {
        }
    }

    public void goToPOSNewSale() {
        try {
            NSCpos = (POSNewSaleController) replaceSceneContent("POSNewSale.fxml");
            NSCpos.setParent(this);
            NSCpos.setApp(this);
        } catch (Exception e) {
        }
    }

    public void goToPOSReturnSale() {
        try {
            POSReturnSaleController pos = (POSReturnSaleController) replaceSceneContent("POSReturnSale.fxml");
            pos.setParent(this);
            pos.setApp(this);
        } catch (Exception e) {
        }
    }

    public void goToPOSEditSale() {
        try {
            POSEditSaleController pos = (POSEditSaleController) replaceSceneContent("POSEditSale.fxml");
            pos.setParent(this);
            pos.setApp(this);
        } catch (Exception e) {
        }
    }

    public void goToPOSVoidSale() {
        try {
            POSVoidSaleController pos = (POSVoidSaleController) replaceSceneContent("POSVoidSale.fxml");
            pos.setApp(this);
        } catch (Exception e) {
        }
    }

    public void goToPOSReprintReceipt() {
        try {
            POSReprintReceiptController pos = (POSReprintReceiptController) replaceSceneContent("POSReprintReceipt.fxml");
            pos.setParent(this);
            pos.setApp(this);
        } catch (Exception e) {
        }
    }

    public void goToPOSHelp() {
        try {
            POSHelpController pos = (POSHelpController) replaceSceneContent("POSHelp.fxml");
            pos.setApp(this);
        } catch (Exception e) {
        }
    }

    public void goToAdmin() {
        try {
            if(Login.userType){
                AdminController admin = (AdminController) replaceSceneContent("Admin.fxml");
                admin.setApp(this);
            }
        } catch (Exception e) {
        }
    }
    
    public void closeGUI(){
        datamanager.DataManager.writeAllFiles();
        stage.close();
    }

    private Initializable replaceSceneContent(String fxml) throws Exception {
        FXMLLoader loader = new FXMLLoader();
        InputStream in = GUI.class.getResourceAsStream(fxml);
        loader.setBuilderFactory(new JavaFXBuilderFactory());
        loader.setLocation(GUI.class.getResource(fxml));
        AnchorPane page;

        try {
            page = (AnchorPane) loader.load(in);
        } finally {
            in.close();
        }

        if ("Login.fxml".equals(fxml)) {
            stage.setFullScreen(true);
            Scene scene = new Scene(page/*, 600, 400*/);
            stage.setScene(scene);
            stage.sizeToScene();
        } else {
            Scene scene = new Scene(page, d.width, d.height/*, 1550, 700*/);
            stage.setScene(scene);
            //stage.sizeToScene();

            stage.setFullScreen(true);
            stage.sizeToScene();
        }
        return (Initializable) loader.getController();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
