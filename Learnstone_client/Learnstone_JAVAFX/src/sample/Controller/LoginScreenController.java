package sample.Controller;


import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import sample.Main;

import java.io.IOException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

/**
 * Created by Morgadow on 26/05/2017.
 */
public class LoginScreenController extends Main implements Initializable{

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
    private void Connection_Auth() throws IOException {

        //Authentification Request Here..
//        boolean result = checklogs(UserInput, UserInput.getText(), PasswordInput, PasswordInput.getText());
//            if (result) {
//                System.out.println("Connexion with username : " + UserInput.getText() + " succesfull.");
//                MainModelPage = GenerateMainPageModel(PREF_HEIGHT_MAINPAGE, PREF_WIDTH_MAINPAGE);
//                MainWindow.setScene(MainModelPage);
//                MainWindow.show();
//            } else {
//                System.out.println("Connexion failed.");
//            }

        MainModelPage = GenerateMainPageModel(PREF_HEIGHT_MAINPAGE, PREF_WIDTH_MAINPAGE);
        MainWindow.setScene(MainModelPage);
//        MainWindow.show();
    }
}
