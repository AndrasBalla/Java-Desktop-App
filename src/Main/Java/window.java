package main.java;

/**
 * Created by Spiks on 2016-04-16.
 * In the project Buss_System
 */

import javafx.geometry.Pos;
import main.java.Buss_lines.LineDatabase;
import main.java.UI.staticElements.DigitalClock;
import main.java.UI.staticElements.MenuBar;
import main.java.UI.staticElements.NavBar;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import main.java.UI.Overview;

public class Window extends Application {
    private MenuBar menuBar = new MenuBar();
    private NavBar navBar = new NavBar();
    private Overview overview = new Overview();
    private BorderPane border;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Buss Deluxe");
        intiSetup();
        StackPane root = new StackPane();
        root.getChildren().add(border);
        Scene scene = new Scene(root, 1250, 750);
        scene.getStylesheets().add("style.css");//Line for Gradle
        //scene.getStylesheets().add("main/resources/style.css");//line for run with intelj.
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * Initial Setup of the UI.
     */
    private void intiSetup(){
        border = new BorderPane();
        VBox nav = new VBox();
        HBox menu = new HBox();
        HBox time = new HBox();
        DigitalClock clock = new DigitalClock();

        navBar.init(nav, border);
        menuBar.setMenu(menu);
        time.getChildren().add(clock);
        time.setAlignment(Pos.BOTTOM_RIGHT);
        time.getStyleClass().add("custom-footer");
        time.setId("custom-footer");
        clock.getStyleClass().add("custom-timer");
        clock.setId("custom-timer");

        border.setTop(menu);
        border.setLeft(nav);
        border.setCenter(overview.init());
        border.setBottom(time);
        nav.getStyleClass().add("custom-border");
        nav.setId("custom-border");
    }

}
