package main.java.UI;

import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

/**
 * Created by Spiks on 2016-04-22.
 */
public class NavBar {


    public void init(VBox menu){
        VerticalButtonBar bar = new VerticalButtonBar();
        Button overview = new Button("Overview");
        Button garage = new Button("Garage");
        Button personnel = new Button("Personal");
        Button line = new Button("Linjer");
        Button tickets = new Button("Tickets");
        Button bok = new Button("Book ticket");
        bar.addButton(garage);
        bar.addButton(personnel);
        bar.addButton(line);
        bar.addButton(tickets);
        bar.addButton(bok);
        bar.addButton(overview);
        menu.getChildren().addAll(bar);
    }
}
