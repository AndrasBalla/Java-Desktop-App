package main.java.UI.staticElements;

import javafx.scene.control.Button;
import javafx.scene.layout.HBox;

/**
 * Created by Spiks on 2016-04-22.
 * In the project Buss_System
 */

/**
 * The menu bar is a permanent resident of the UI found at the top of the screen.
 */
public class MenuBar {

    public void setMenu(HBox menu){
        Button system = new Button();
        Button settings = new Button();
        Button help = new Button();

        system.setText("System");
        settings.setText("Settings");
        help.setText("Help");

        menu.getChildren().addAll(system,settings,help);
        menu.getStyleClass().add("custom-menu");
        menu.setId("custom-menu");

        system.setOnAction(event -> {
            System.out.println("System Overview");
            //TODO:Add System options.
        });

        settings.setOnAction(event -> {
            System.out.println("Settings Window");
            //TODO:Add settings.
        });

        help.setOnAction(event -> {
            System.out.println("Help Window");
            //TODO: Add some help text.
        });
    }
}
