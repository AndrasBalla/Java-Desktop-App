package main.java.UI;

import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

/**
 * Created by Spiks on 2016-04-22.
 */

/**
 * The NavBar is always on the left side of the screen providing buttons that will navigate trough the application.
 */
public class NavBar {
    private VerticalButtonBar bar;
    private Button overview;
    private Button garage;
    private Button personnel;
    private Button line;
    private Button tickets;
    private Button bok;

    public void init(VBox menu){
        bar = new VerticalButtonBar();
        overview = new Button("Overview");
        garage = new Button("Garage");
        personnel = new Button("Personnel");
        line = new Button("Buss Lines");
        tickets = new Button("Tickets");
        bok = new Button("Book ticket");

        bar.addButton(overview);
        bar.addButton(garage);
        bar.addButton(personnel);
        bar.addButton(line);
        bar.addButton(tickets);
        bar.addButton(bok);
        menu.getChildren().addAll(bar);
    }
}
