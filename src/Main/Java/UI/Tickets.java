package main.java.UI;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import javafx.scene.text.Text;
import main.java.Buss_lines.TicketDatabase;
import main.java.Objekt.Stop;
import main.java.Objekt.Ticket;
import main.java.Objekt.javaFxObjects.TicketTable;

/**
 * Created by Spiks on 2016-05-03.
 * In the project Buss_System
 */
public class Tickets {
    private TicketDatabase database = new TicketDatabase();
    private final TableView<TicketTable> table = new TableView<>();
    private Label label = new Label("Tickets");
    private final ObservableList<TicketTable> data = FXCollections.observableArrayList();
    private HBox hb = new HBox();

    public VBox init(){
        tableSetup();
        setupDelete();
        database.updateTicket(data);
        final VBox vbox = new VBox();
        hb.setSpacing(5);
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10, 0, 0, 10));
        vbox.getChildren().addAll(label, table, hb);

        return vbox;
    }

    private Ticket test(){
        Ticket ticket = new Ticket();
        ticket.setId("0002");
        ticket.setPassengerName("Andras Balla");
        ticket.setCost("100");
        ticket.setLineId("12");
        ticket.setPurchaseDate("2016-05-03");
        ticket.setFareDate("2016-05-10");
        ticket.setSource(new Stop("01","Source","Neverland"));
        ticket.setDestination(new Stop("05","Dest","Wonderlanad"));
        return ticket;
    }

    private void setupDelete(){
        final TextField addId = new TextField("Id");
        addId.setPromptText("Buss Id");
        addId.setMaxWidth(75);

        Button remove = new Button("Remove");
        remove.setOnAction(event -> {
            database.removeTicket(addId.getText());
        });
        hb.getChildren().addAll(addId,remove);
    }

    private void tableSetup(){
        table.setEditable(true);

        TableColumn<TicketTable,SimpleStringProperty> idCol = new TableColumn<>("Ticket id");
        idCol.setCellValueFactory(new PropertyValueFactory<>("id"));

        TableColumn<TicketTable,SimpleStringProperty> nameCol = new TableColumn<>("Passenger Name");
        nameCol.setCellValueFactory(new PropertyValueFactory<>("passengerName"));
        nameCol.setMinWidth(150);

        TableColumn<TicketTable,SimpleStringProperty> costCol = new TableColumn<>("Ticket cost");
        costCol.setCellValueFactory(new PropertyValueFactory<>("cost"));

        TableColumn<TicketTable,SimpleStringProperty> lineIdCol = new TableColumn<>("Buss line id");
        lineIdCol.setCellValueFactory(new PropertyValueFactory<>("lineId"));

        TableColumn<TicketTable,SimpleStringProperty> purchaseDateCol = new TableColumn<>("Purchase date");
        purchaseDateCol.setCellValueFactory(new PropertyValueFactory<>("purchaseDate"));

        TableColumn<TicketTable,SimpleStringProperty> fareDateCol = new TableColumn<>("Fare date");
        fareDateCol.setCellValueFactory(new PropertyValueFactory<>("fareDate"));

        TableColumn<TicketTable,SimpleStringProperty> sourceCol = new TableColumn<>("Fare start");
        TableColumn<TicketTable,SimpleStringProperty> sourceId = new TableColumn<>("Id");
        sourceId.setCellValueFactory(new PropertyValueFactory<>("sourceId"));
        TableColumn<TicketTable,SimpleStringProperty> sourceLoc = new TableColumn<>("Location");
        sourceLoc.setCellValueFactory(new PropertyValueFactory<>("sourceLoc"));
        TableColumn<TicketTable,SimpleStringProperty> sourceName = new TableColumn<>("Name");
        sourceName.setCellValueFactory(new PropertyValueFactory<>("sourceName"));
        sourceCol.getColumns().addAll(sourceId,sourceLoc,sourceName);
        sourceCol.setMinWidth(250);

        TableColumn<TicketTable,SimpleStringProperty> destCol = new TableColumn<>("Destination");
        TableColumn<TicketTable,SimpleStringProperty> destinationId = new TableColumn<>("Id");
        destinationId.setCellValueFactory(new PropertyValueFactory<>("destId"));
        TableColumn<TicketTable,SimpleStringProperty> destinationLoc = new TableColumn<>("Location");
        destinationLoc.setCellValueFactory(new PropertyValueFactory<>("destLoc"));
        TableColumn<TicketTable,SimpleStringProperty> destinationName = new TableColumn<>("Name");
        destinationName.setCellValueFactory(new PropertyValueFactory<>("destName"));
        destCol.getColumns().addAll(destinationId,destinationLoc,destinationName);
        destCol.setMinWidth(250);

        table.setItems(data);
        table.setPrefWidth(250);
        table.setMinHeight(550);
        table.getColumns().addAll(idCol, nameCol, costCol, lineIdCol, purchaseDateCol, fareDateCol, sourceCol, destCol);
    }

}
