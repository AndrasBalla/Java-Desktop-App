package main.java.UI;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;

/**
 * Created by Spiks on 2016-04-22.
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
