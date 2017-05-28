package sample.Controller;


import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.DropShadowBuilder;

import java.net.URL;
import java.security.PrivateKey;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

import static java.awt.Color.WHITE;

/**
 * Created by Morgadow on 26/05/2017.
 */
public class LoginScreenController implements Initializable{

    @FXML
    private Button ButtonConnection;
    @FXML
    private Label DayDateLabel;
    @FXML
    private PasswordField PasswordInput;
    @FXML
    private TextField UserInput;

    @Override
    public void initialize (URL location, ResourceBundle resources) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        DayDateLabel.setText(date.toString());

//        ButtonConnection.setOnMouseDragOver(event ->ShadowOnHoverButton(event));
    }

    @FXML
    public void ShadowOnHoverButton(Event E){
        System.out.println("OnHoverButton");
        System.out.println(E.getSource());

//        btn.setEffect(DropShadowBuilder("color="WHITE" height="52.1" radius="20.105" width="30.32"");
    }

    @FXML
    private void Connection_Auth(){

    }
}
