package main.java.UI;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import main.java.Buss_lines.Database;
import main.java.Objekt.Buses;
import main.java.Objekt.Buss;

/**
 * Created by Spiks on 2016-04-23.
 */
public class Garage {
    private Database database = new Database();
    private final TableView<Buss> table = new TableView();
    final Label label = new Label("Garage");
    private final ObservableList<Buss> data = FXCollections.observableArrayList();

    public VBox init(){
        table.setEditable(true);

        TableColumn idCol = new TableColumn("Buss Id");
        idCol.setMinWidth(250);
        idCol.setCellValueFactory(
                new PropertyValueFactory<>("id")
        );

        TableColumn activeCol = new TableColumn("Active");
        activeCol.setMinWidth(250);
        activeCol.setCellValueFactory(
                new PropertyValueFactory<>("active")
        );

        TableColumn regCol = new TableColumn("Registration nr.");
        regCol.setMinWidth(250);
        regCol.setCellValueFactory(
                new PropertyValueFactory<>("regId")
        );

        getList();

        table.setItems(data);
        table.getColumns().addAll(idCol, activeCol, regCol);
        final VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10, 0, 0, 10));
        vbox.getChildren().addAll(label, table);

        return vbox;
    }

    private void getList(){
        Buses list = database.getBuss();
        System.out.println("Checking the list" + list.toString());
        for (int i = 0; i < list.getBuses().size(); i++){

            data.add(list.getBuses().get(i));
        }
    }

}
