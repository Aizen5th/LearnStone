package sample;

/**
 * Created by Morgado William on 26/04/2017.
 */
import javafx.scene.image.Image;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.*;

public class ConfirmBoxMultipleChoice{

    static boolean answer;
    private String title;
    private String message;
    private String choice1;
    private String choice2;
    private Stage window;
    private Image logo;
    private Image img;
    private int MinH;
    private int MinW;

    public ConfirmBoxMultipleChoice(String m, String nc1, String nc2, Stage w){
        this.title = "Learnstone";
        this.message = m;
        this.choice1 = nc1;
        this.choice2 = nc2;
        this.window = w;
        this.MinH = 100;
        this.MinW = 250;
        this.logo = new Image("file:ressources/images/logo.png");
        this.img = new Image("file:ressources/images/minionhs.png");


    }
    public void init(){
        // Image Img = new Image(Main.class.getResourceAsStream("logo.png"));
        window.setTitle(title);
        window.getIcons().add(logo);
        window.setMinHeight(MinH);
        window.setMinWidth(MinW);
        window.initModality(Modality.APPLICATION_MODAL);

    }
        public boolean display() {

        window = new Stage();
        init();

        Label label = new Label(message);

        // Creation of BTN
        Button BTN_Ch1 = new Button(choice1);
        Button BTN_Ch2 = new Button(choice2);

        BTN_Ch1.setOnAction(event -> {
            answer = true;
            window.close();
        });

        BTN_Ch2.setOnAction(event -> {
            answer = false;
            window.close();
        });


        // Ordering and placement of the things
        HBox split = new HBox(10);
        VBox layout = new VBox(10);
        HBox choice = new HBox(40);
        layout.setAlignment(Pos.CENTER);
        choice.setAlignment(Pos.CENTER);
        choice.getChildren().addAll(BTN_Ch1,BTN_Ch2);
        layout.getChildren().addAll(label, choice);
//        split.getChildren().addAll(img ,layout);


        //Setting the layout on the scene
        Scene scene = new Scene(layout);
        scene.getStylesheets().add(Main.class.getResource("style.css").toExternalForm());

        //Setting the scene on the window
        window.setScene(scene);
        window.showAndWait();

        return answer;
    }
}