package main.java.UI.staticElements;

import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

/**
 * Created by Spiks on 2016-04-22.
 * In the project Buss_System
 */

/**
 * A simple class that holds the navigation buttons in a vertical list.
 */
class VerticalButtonBar extends VBox{

    VerticalButtonBar(){
        setFillWidth(true);
    }

    void addButton(Button button){
        button.setMaxWidth(Double.MAX_VALUE);
        getChildren().add(button);
    }
}
