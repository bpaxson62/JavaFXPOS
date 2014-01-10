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
import javafx.scene.control.PasswordField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import login.Login;

/**
 * FXML Controller class
 *
 * @author WouldntULikeToKnow
 */
public class LoginController extends AnchorPane implements Initializable {

    private GUI application;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void handleLogIn(ActionEvent event) {
        String password = getPassword.getText();
        String userName = getUsername.getText();

        if (Login.checkPW(password, userName)) {
            application.goToPOS();
        } else {
            getPassword.setText("");
            getUsername.setText("InVaild Try Again");
        }

    }

    @FXML
    PasswordField getPassword;
    @FXML
    TextField getUsername;
    @FXML
    ImageView loginImage;

    void setApp(GUI aThis) {
        //loginImage.setFitHeight(application.d.height);
        // loginImage.setFitWidth(application.d.width);
        this.application = aThis;
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
