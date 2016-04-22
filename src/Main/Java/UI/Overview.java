package main.java.UI;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.control.Label;

/**
 * Created by Spiks on 2016-04-22.
 */
public class Overview {
    private VBox root = new VBox(10);
    private Label title = new Label("Buss Deluxe");

    public VBox init(){
        Button btn = new Button();
        btn.setText("Say 'Hello World'");
        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Hello World!");
            }
        });

        title.getStyleClass().add("custom-title");
        title.setId("custom-title");
        root.getChildren().addAll(title,btn);
        return root;
    }

}


