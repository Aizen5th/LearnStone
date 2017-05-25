package sample.refractor;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Morgadow on 24/05/2017.
 */
public class MainModelPageController implements Initializable{

    @FXML
    private Label Welcome;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Welcome.setText("Salut");
    }

    @FXML
    public void OnclickButton1(){
        Welcome.setText("ça va ?");
    }
}
