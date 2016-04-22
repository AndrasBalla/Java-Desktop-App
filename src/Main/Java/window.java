package main.java;

/**
 * Created by Spiks on 2016-04-16.
 */

import main.java.UI.MenuBar;
import main.java.UI.NavBar;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Window extends Application {
    private MenuBar menuBar = new MenuBar();
    private NavBar navBar = new NavBar();
    private VBox nav;
    private HBox menu;
    private BorderPane border;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Hello World!");
        Button btn = new Button();
        btn.setText("Say 'Hello World'");
        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Hello World!");
                System.out.println("javafx.runtime.version: " + System.getProperties().get("javafx.runtime.version"));
            }
        });

        intiSetup(btn);
        StackPane root = new StackPane();
        root.getChildren().add(border);
        Scene scene = new Scene(root, 500, 450);
        //scene.getStylesheets().add("style.css");//Line for Gradle
        scene.getStylesheets().add("main/resources/style.css");//line for run with intelj.
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void intiSetup(Button btn){
        border = new BorderPane();
        nav = new VBox();
        menu = new HBox();

        navBar.init(nav);
        menuBar.setMenu(menu);
        border.setTop(menu);
        border.setLeft(nav);
        border.setCenter(btn);
        nav.getStyleClass().add("custom-border");
        nav.setId("custom-border");
        System.out.println(System.getProperty("user.dir"));
    }

}
