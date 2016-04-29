package main.java.UI;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import main.java.Buss_lines.DriverDatabase;
import main.java.Objekt.Driver;
import main.java.Objekt.javaFxObjects.DriverTable;

import java.util.ArrayList;

/**
 * Created by Spiks on 2016-04-28.
 */
public class Drivers {
    private DriverDatabase database = new DriverDatabase();
    private final TableView<DriverTable> table = new TableView();
    final Label label = new Label("Drivers");
    private TableColumn driverId;
    private TableColumn id;
    private TableColumn name;
    private HBox hb = new HBox();
    private final ObservableList<DriverTable> data = FXCollections.observableArrayList(
            new DriverTable("25879", "910612-2011","Andreas Johanson")
    );

    public VBox init(){
        table.setEditable(true);

        driverId = new TableColumn("Driver Id");
        driverId.setMinWidth(300);
        driverId.setCellValueFactory(new PropertyValueFactory<>("driverId"));

        id = new TableColumn("Personal Id");
        id.setMinWidth(300);
        id.setCellValueFactory(new PropertyValueFactory<>("id"));

        name = new TableColumn("Name");
        name.setMinWidth(300);
        name.setCellValueFactory(new PropertyValueFactory<>("name"));

        getList();
        setupAddButtons();

        table.setItems(data);
        table.setPrefWidth(250);
        table.setMinHeight(550);
        table.getColumns().addAll(driverId, id, name);
        hb.setSpacing(5);
        final VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10, 0, 0, 10));
        vbox.getChildren().addAll(label, table, hb);

        return vbox;
    }

    /**
     * Loads in information from firebase to populate the Table.
     */
    private void getList(){
        ArrayList<Driver> list = database.getDriverList();
        for (int i = 0; i < list.size(); i++){
            data.add(new DriverTable(list.get(i).getDriverId(),list.get(i).getId(),list.get(i).getName()));
        }
    }


    /**
     * Adds 3 TextFields one for each value and then adds a Add and remove button.
     */
    private void setupAddButtons(){
        final Text warn = new Text("Invalid input! Please try again");
        warn.getStyleClass().add("custom-redTitle");
        warn.setId("custom-redTitle");

        final TextField addDriverId = new TextField();
        addDriverId.setPromptText("Driver Id");
        addDriverId.setMinWidth(driverId.getPrefWidth());

        final TextField addId = new TextField();
        addId.setPromptText("Personal Id");
        addId.setMinWidth(id.getPrefWidth());

        final TextField addName = new TextField();
        addName.setPromptText("Name");
        addName.setMinWidth(name.getPrefWidth());

        Button addButton = new Button("Add");
        addButton.setOnAction((event) -> {
            if (checkInput(addDriverId.getText(),addName.getText(),addId.getText())){
                data.add(new DriverTable(
                        addDriverId.getText(),
                        addId.getText(),
                        addName.getText()));
                database.saveDriver(new Driver(addDriverId.getText(),addId.getText(),addName.getText()));
                if (hb.getChildren().contains(warn)){
                    hb.getChildren().remove(warn);
                }
                addDriverId.clear();
                addId.clear();
                addName.clear();
            }else {
                hb.getChildren().add(warn);
            }
        });

        Button removeButton = new Button("Remove");
        removeButton.setOnAction((event) -> {
            for (int i = 0; i < data.size(); i++){
                if(data.get(i).getDriverId().toString().equals(addDriverId.getText())){
                    database.deleteDriver(data.get(i).getName().toString());
                    data.remove(i);
                }
            }
        });

        hb.getChildren().addAll(addDriverId, addId, addName, addButton, removeButton);
    }

    private boolean checkInput(String driverId, String name, String id){
        Driver checkId = new Driver();
        boolean check = false;
        if (driverId.length() == 5 && name.length() > 0 && id.length() == 11){
            check = true;
        }else {
            return false;
        }
        for (int i = 0; i < driverId.length(); i++){
            if(!(Character.isDigit(driverId.charAt(i)))){
                return false;
            }
        }
        if (checkId.checkId(id)){
            check = true;
        }
        return check;
    }
}
