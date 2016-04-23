package main.java.UI;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;

/**
 * Created by Spiks on 2016-04-22.
 */

/**
 * The menu bat is a permanent resident of the UI found at the top of the screen.
 */
public class MenuBar {
    private Button system;
    private Button settings;
    private Button help;

    public void setMenu(HBox menu){
        system = new Button();
        settings = new Button();
        help = new Button();

        system.setText("System");
        settings.setText("Settings");
        help.setText("Help");

        menu.getChildren().addAll(system,settings,help);
        menu.getStyleClass().add("custom-menu");
        menu.setId("custom-menu");

        system.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("System Overview");
                //TODO:Add System options.
            }
        });

        settings.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Settings Window");
                //TODO:Add settings.
            }
        });

        help.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Help Window");
                //TODO: Add some help text.
            }
        });
    }
}
