package sample;

/**
 * Created by Morgado William on 26/04/2017.
 */

import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.*;

import java.awt.event.KeyEvent;

public  class AlertBox{

    private String title;
    private String message;
    private Stage window;
    private Scene scene;
    private Image logo;
    private int MinH;
    private int MinW;

    public AlertBox(String m, Stage w){
        this.title = "Learnstone";
        this.message = m;
        this.window = w;
        this.logo = new Image("file:ressources/images/logo.png");
        this.MinH = 100;
        this.MinW = 250;
//        this.scene = new Scene();
    }

    public void init(){
//        Image Img = new Image(Main.class.getResourceAsStream("logo.png"));
        window.getIcons().add(logo);
        window.setMinHeight(MinH);
        window.setMinWidth(MinW);
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(title);
    }
    public void display(){
        window = new Stage();
        init();
        HBox hbox = new HBox();
        VBox layout = new VBox(10);
        layout.setAlignment(Pos.CENTER);

        Label label = new Label(message);

        Button btn = new Button("OK");
        btn.setOnAction(event -> window.close());

        //Setting Label and button on Vbox
        layout.getChildren().addAll(label,btn);
        //Setting our scene with the layout
        scene = new Scene(layout);

//        scene.addEventFilter(KeyEvent.KEY_RELEASED, event -> {
//            if (event.getCode) {
//
//            }
//            window.close();
//        });
        scene.getStylesheets().add(Main.class.getResource("style.css").toExternalForm());

        //Putting the scene on the window
        window.setScene(scene);
        window.showAndWait();

    }
}
