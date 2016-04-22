package main.java.UI;

import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

/**
 * Created by Spiks on 2016-04-22.
 */
public class VerticalButtonBar extends VBox{
    public VerticalButtonBar(){
        setFillWidth(true);
    }

    public void addButton(Button button){
        button.setMaxWidth(Double.MAX_VALUE);
        getChildren().add(button);
    }
}
