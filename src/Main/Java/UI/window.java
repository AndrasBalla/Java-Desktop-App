package Main.java.UI;/**
 * Created by Spiks on 2016-04-16.
 */

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class window extends Application {

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

        BorderPane border = new BorderPane();
        VBox nav = new VBox();
        HBox menu = new HBox();
        NavBar navBar = new NavBar();
        navBar.init(nav);
        setMenu(menu);
        border.setTop(menu);
        border.setLeft(nav);
        border.setCenter(btn);

        StackPane root = new StackPane();
        root.getChildren().add(border);
        primaryStage.setScene(new Scene(root, 500, 450));
        primaryStage.show();
    }

    private void setMenu(HBox menu){
        Button system = new Button();
        Button settings = new Button();
        Button help = new Button();
        system.setText("System");
        settings.setText("Settings");
        help.setText("Help");
        menu.getChildren().addAll(system,settings,help);

        system.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("System Overview");
            }
        });

        settings.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Settings Window");
            }
        });

        help.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Help Window");
            }
        });
    }
}
