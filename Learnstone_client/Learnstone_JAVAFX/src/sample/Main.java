package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.image.Image;
import javafx.scene.control.*;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.*;

public class Main extends Application {
    public Stage MainWindow = new Stage();
    private Scene LoginScreen, MainModelPage, WelcomePage, LessonPage, TestPage, QuizzPage;
    public Image logo;
    private String[] accountusername = {"Antoine", "Maxime", "Patrick", "Steven", "Louis"};
    private final int MAXACCOUNT = accountusername.length;
    private final int PREF_HEIGHT_MAINPAGE = 675;
    private final int PREF_WIDTH_MAINPAGE = 900;
    private final int PREF_HEIGHT_LOGINSCREEN = 580;
    private final int PREF_WIDTH_LOGINSCREEN = 600;
    private String[] accountpwd = new String[MAXACCOUNT];
    private AlertBox WOP;
    private AlertBox LogFail;
    private ConfirmBoxMultipleChoice ExitProgram;

    public static void main(String[] args) {
        Application.launch(Main.class, args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception{

        MainWindow = primaryStage;
        // Initialisation of the  logo
        Initlogo();
        WOP = new AlertBox("Work in progress !", new Stage());
        LogFail = new AlertBox("Wrong login or password... ", new Stage());
        ExitProgram = new ConfirmBoxMultipleChoice("Are you sure to exit the application ?", "YES", "NO", new Stage());

        LoginScreen = generateLoginScreen(PREF_HEIGHT_LOGINSCREEN, PREF_WIDTH_LOGINSCREEN);
//        Initlogo();
        MainWindow.setScene(LoginScreen);
        MainWindow.show();


//      LOGIN SCREEN A REFAIRE EN FXML
//        LoginScreen = generateLoginScreen();
//       MainModelPage = generatePageModel(PREF_HEIGHT_MAINPAGE, PREF_WIDTH_MAINPAGE);



        // Generation of the log (local database simulation)
//        for (int i = 0; i < MAXACCOUNT; i++) {
//            accountpwd[i] = generatepwd(6);
//            System.out.println(accountusername[i] + " : " + accountpwd[i]);
//        }


//        //Confirmation to close the application
//        MainWindow.setOnCloseRequest(event -> {
//            event.consume();
//            closeProgram(ExitProgram);
//        });


        //Display Loginscreen at first

    }

    private Scene generateLoginScreen(int Height, int Width) throws IOException {


        Parent root = FXMLLoader.load(getClass().getResource("resource/fxml_page/LoginScreenPage.fxml"));
        Scene scene = new Scene(root, Width, Height);
        initwindowRes();
        return scene;

//        Login.setOnAction(event -> {
//            boolean result = checklogs(nameinput, nameinput.getText(), passinput, passinput.getText());
//            if (result) {
//                System.out.println("Connexion with username : " + nameinput.getText() + " succesfull.");
//                MainWindow.setMinWidth(PREF_WIDTH-1);
//                MainWindow.setMinHeight(PREF_HEIGHT_MAINPAGE-1);
//                MainWindow.setMaxWidth(PREF_WIDTH);
//                MainWindow.setMaxHeight(PREF_HEIGHT_MAINPAGE);
//                MainWindow.setScene(MainModelPage);
//                MainWindow.show();
//
//            } else {
//                LogFail.display();
//            }
//        });
//
//
//        Exit.setOnAction(event -> {
//            event.consume();
//            closeProgram(ExitProgram);
//        });
//        gridPanel.setAlignment(Pos.CENTER);
//        gridPanel.getChildren().addAll(nameLabel, nameinput, passlabel, passinput, Login, Exit);
//
//        LoginScreen = new Scene(gridPanel);
//        LoginScreen.getStylesheets().add(Main.class.getResource("style.css").toExternalForm());
//
//        // Keybinding for login screen
//
//        LoginScreen.addEventFilter(KeyEvent.KEY_RELEASED, event -> {
//            // KEY ENTER INPUT EVENT
//            if (event.getCode().equals(KeyCode.ENTER)) {
//                boolean result = checklogs(nameinput, nameinput.getText(), passinput, passinput.getText());
//                if (result) {
//                    System.out.println("Connexion with username : " + nameinput.getText() + " succesfull.");
////                MainWindow.setScene(WelcomePage);
//                } else {
//                    LogFail.display();
//                }
//            }
//            // KEY ESCAPE INPUT EVENT
//            if(event.getCode().equals(KeyCode.ESCAPE)){
//                closeProgram(ExitProgram);
//            }
//
//
//        });
//        return LoginScreen;
    }


    private void generatePageModel(int Height, int Width) throws IOException {

//        // MODEL PAGE ===============================================/
//        BorderPane MainMenu = new BorderPane();
//        Label username = new Label("Antoine");
//        ImageView TOPimage = new ImageView("file:ressources/images/images.jpg");
//        HBox TOP = new HBox(username, TOPimage);
//        MainMenu.setTop(TOP);
//        //MainModelPage = new Scene(Insert top element);//
//        MainModelPage.getStylesheets().add(Main.class.getResource("style.css").toExternalForm());
//        //===========================================================/


//        //Load the PageModel from an fxml file ! :)
//        Parent root = FXMLLoader.load(getClass().getResource("fxml_page/MainModelPage.fxml"));
//        Scene scene = new Scene(root, Height, Width);
//        return scene;
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

    private void initwindowRes() {

        MainWindow.setMinWidth(PREF_WIDTH_LOGINSCREEN-1);
        MainWindow.setMinHeight(PREF_HEIGHT_LOGINSCREEN-1);
        MainWindow.setMaxWidth(PREF_WIDTH_LOGINSCREEN);
        MainWindow.setMaxHeight(PREF_HEIGHT_LOGINSCREEN);

    }

    private void closeProgram(ConfirmBoxMultipleChoice ExitProgram) {
        boolean result = ExitProgram.display();
        if (result) {
            MainWindow.close();
        }
    }

    public void Initlogo() {
        MainWindow.getIcons().add(new Image("https://raw.githubusercontent.com/Aizen5th/LearnStone/DEV_Will/Learnstone_client/Learnstone_JAVAFX/resource/images/logo.png"));
        MainWindow.setTitle("Learnstone");
        MainWindow.setTitle("Learnstone");
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