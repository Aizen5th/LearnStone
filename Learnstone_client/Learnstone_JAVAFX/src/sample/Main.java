package sample;

import javafx.application.*;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;

import java.io.IOException;
import java.util.*;

public class Main extends Application {
    public Stage MainWindow = new Stage();
    private Scene LoginScreen, MainModelPage, WelcomePage, LessonPage, TestPage, QuizzPage;
    public Image logo;
    private String[] accountusername = {"Antoine", "Maxime", "Patrick", "Steven", "Louis"};
    private final int MAXACCOUNT = accountusername.length;
    private final int PREF_HEIGHT = 675;
    private final int PREF_WIDTH = 900;
    private String[] accountpwd = new String[MAXACCOUNT];
    private AlertBox WOP;
    private AlertBox LogFail;
    private ConfirmBoxMultipleChoice ExitProgram;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception{

        WOP = new AlertBox("Work in progress !", new Stage());
        LogFail = new AlertBox("Wrong login or password... ", new Stage());


        ExitProgram = new ConfirmBoxMultipleChoice("Are you sure to exit the application ?", "YES", "NO", new Stage());


        LoginScreen = generateLoginScreen();
        MainModelPage = generatePageModel(PREF_HEIGHT, PREF_WIDTH);


        // Initialisation of the  MainWindow
        initwindowRes(primaryStage);
        // Initialisation of the  logo
        initlogo(this.MainWindow, this.logo);

        // Generation of the log (local database simulation)
        for (int i = 0; i < MAXACCOUNT; i++) {
            accountpwd[i] = generatepwd(6);
            System.out.println(accountusername[i] + " : " + accountpwd[i]);
        }


        //Confirmation to close the application
        MainWindow.setOnCloseRequest(event -> {
            event.consume();
            closeProgram(ExitProgram);
        });

        //Setup a transparent style
//        MainWindow.initStyle(StageStyle.TRANSPARENT);
//        MainWindow.setResizable(true);

        //Display Loginscreen at first
        MainWindow.setScene(LoginScreen);
        MainWindow.show();
    }

    private Scene generateLoginScreen() {
        //SCENE GRIDPANE LOGIN SCREEN ==============================//

        GridPane gridPanel = new GridPane();
        gridPanel.setPadding(new Insets(10, 10, 10, 10));
        gridPanel.setVgap(8);
        gridPanel.setHgap(10);
        gridPanel.setId("gridpanelogin");

        // Username
        Label nameLabel = new Label("Username : ");
        nameLabel.setId("fontloginscreen");

        GridPane.setConstraints(nameLabel, 0, 0);
        TextField nameinput = new TextField();


        nameLabel.setLabelFor(nameinput);
        GridPane.setConstraints(nameinput, 1, 0);

        // Password
        Label passlabel = new Label("Password : ");
        passlabel.setId("fontloginscreen");


        GridPane.setConstraints(passlabel, 0, 1);
        PasswordField passinput = new PasswordField();
        passinput.setPromptText("password");
        passlabel.setLabelFor(passinput);
        GridPane.setConstraints(passinput, 1, 1);

        // Button Login
        Button Login = new Button("Login");
        GridPane.setConstraints(Login, 1, 2);
        // Button Exit
        Button Exit = new Button("Exit");
        GridPane.setConstraints(Exit, 1, 3);


        Login.setOnAction(event -> {
            boolean result = checklogs(nameinput, nameinput.getText(), passinput, passinput.getText());
            if (result) {
                System.out.println("Connexion with username : " + nameinput.getText() + " succesfull.");
                MainWindow.setMinWidth(PREF_WIDTH-1);
                MainWindow.setMinHeight(PREF_HEIGHT-1);
                MainWindow.setMaxWidth(PREF_WIDTH);
                MainWindow.setMaxHeight(PREF_HEIGHT);
                MainWindow.setScene(MainModelPage);
                MainWindow.show();

            } else {
                LogFail.display();
            }
        });


        Exit.setOnAction(event -> {
            event.consume();
            closeProgram(ExitProgram);
        });
        gridPanel.setAlignment(Pos.CENTER);
        gridPanel.getChildren().addAll(nameLabel, nameinput, passlabel, passinput, Login, Exit);

        LoginScreen = new Scene(gridPanel);
//        LoginScreen.getStylesheets().add(Main.class.getResource("file:ressources/Stylesheets/style.css").toExternalForm());
//        LoginScreen.getStylesheets().add(getClass().getResource("/stylesheets/style.css").toExternalForm());

        // Keybinding for login screen

        LoginScreen.addEventFilter(KeyEvent.KEY_RELEASED, event -> {
            // KEY ENTER INPUT EVENT
            if (event.getCode().equals(KeyCode.ENTER)) {
                boolean result = checklogs(nameinput, nameinput.getText(), passinput, passinput.getText());
                if (result) {
                    System.out.println("Connexion with username : " + nameinput.getText() + " succesfull.");
//                MainWindow.setScene(WelcomePage);
                } else {
                    LogFail.display();
                }
            }
            // KEY ESCAPE INPUT EVENT
            if(event.getCode().equals(KeyCode.ESCAPE)){
                closeProgram(ExitProgram);
            }


        });
        return LoginScreen;
    }
        //===========================================================/

    private Scene generatePageModel(int Height, int Width) throws IOException {

//        // MODEL PAGE ===============================================/
//        BorderPane MainMenu = new BorderPane();
//        Label username = new Label("Antoine");
//        ImageView TOPimage = new ImageView("file:ressources/images/images.jpg");
//        HBox TOP = new HBox(username, TOPimage);
//        MainMenu.setTop(TOP);
//        //MainModelPage = new Scene(Insert top element);//
//        MainModelPage.getStylesheets().add(Main.class.getResource("style.css").toExternalForm());
//        //===========================================================/


        //Load the PageModel from an fxml file ! :)
        Parent root = FXMLLoader.load(getClass().getResource("fxml_page/MainModelPage.fxml"));
        Scene scene = new Scene(root, Height, Width);
        return scene;
    }


    private boolean checklogs(TextField nameinput, String username, PasswordField passinput, String password) {
        int id = 0;
        System.out.println(username);
        for(int i = 0 ; i < accountusername.length; i++){
            if(Objects.equals(accountusername[i], nameinput.getText())){
                id = i;
//                System.out.println(username + " do exist on the database");
                break;
            }
        }
//        System.out.println(accountpwd[id] + " " + password);
        return Objects.equals(accountpwd[id], passinput.getText());
    }

    private void initwindowRes(Stage primaryStage) {

        MainWindow = primaryStage;
        MainWindow.setMinWidth(449);
        MainWindow.setMinHeight(450);
        MainWindow.setMaxWidth(449);
        MainWindow.setMaxHeight(450);

    }

    private void closeProgram(ConfirmBoxMultipleChoice ExitProgram) {
        boolean result = ExitProgram.display();
        if (result) {
            MainWindow.close();
        }
    }

    public void initlogo(Stage WindoW, Image Img) {
//        Img = new Image(Main.class.getResourceAsStream("logo.png"));
        Img = new Image("file:ressources/images/logo.png");
        WindoW.setTitle("Learnstone");
        WindoW.getIcons().add(Img);
    }

    public String generatepwd(int length) {
        String chars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        String pass = "";
        for (int x = 0; x < length; x++) {
            int i = (int) Math.floor(Math.random() * 62); //
            pass += chars.charAt(i);
        }
//        System.out.println(pass);
        String passlower = pass.toLowerCase();
        return passlower;

    }
}