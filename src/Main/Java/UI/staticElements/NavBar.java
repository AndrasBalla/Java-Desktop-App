package main.java.UI.staticElements;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import main.java.UI.Drivers;
import main.java.UI.Garage;
import main.java.UI.Overview;
import main.java.UI.VerticalButtonBar;

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

    public void init(VBox menu, BorderPane borderPane){
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

        overview.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Overview overviewPage = new Overview();
                borderPane.setCenter(overviewPage.init());
            }
        });

        garage.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Garage garage = new Garage();
                borderPane.setCenter(garage.init());
            }
        });

        personnel.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Drivers drivers = new Drivers();
                borderPane.setCenter(drivers.init());
            }
        });
    }
}
