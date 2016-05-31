package main.java.UI.staticElements;

import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import main.java.UI.*;

/**
 * Created by Spiks on 2016-04-22.
 * In the project Buss_System
 */

/**
 * The NavBar is always on the left side of the screen providing buttons that will navigate trough the application.
 */
public class NavBar {

    public void init(VBox menu, BorderPane borderPane){
        VerticalButtonBar bar = new VerticalButtonBar();
        Button overview = new Button("Overview");
        Button garage = new Button("Garage");
        Button personnel = new Button("Personnel");
        Button line = new Button("Buss Lines");
        Button tickets = new Button("Tickets");
        Button book = new Button("Book ticket");

        bar.addButton(overview);
        bar.addButton(garage);
        bar.addButton(personnel);
        bar.addButton(line);
        bar.addButton(tickets);
        bar.addButton(book);
        menu.getChildren().addAll(bar);

        overview.setOnAction((event) -> {
            Overview overviewPage = new Overview();
            borderPane.setCenter(overviewPage.init());
        });

        garage.setOnAction((event) -> {
            Garage garagePane = new Garage();
            borderPane.setCenter(garagePane.init());
        });

        personnel.setOnAction(event -> {
            Drivers drivers = new Drivers();
            borderPane.setCenter(drivers.init());
        });

        line.setOnAction(event -> {
            BussLines lines = new BussLines();
            borderPane.setCenter(lines.init());
        });

        tickets.setOnAction((event) -> {
            Tickets ticket = new Tickets();
            borderPane.setCenter(ticket.init());
        });

        book.setOnAction(event -> {
            BookTicket bookTicket = new BookTicket();
            borderPane.setCenter(bookTicket.init());
        });
    }
}
