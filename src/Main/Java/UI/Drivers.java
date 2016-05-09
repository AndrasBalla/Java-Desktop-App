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
import main.java.Buss_lines.DriverDatabase;
import main.java.Objekt.Driver;
import main.java.Objekt.javaFxObjects.DriverTable;

/**
 * Created by Spiks on 2016-04-28.
 * In the project Buss_System
 */
public class Drivers {
    private DriverDatabase database = new DriverDatabase();
    private final TableView<DriverTable> table = new TableView<>();
    private Label label = new Label("Drivers");
    private TableColumn<DriverTable,SimpleStringProperty> driverId;
    private TableColumn<DriverTable,SimpleStringProperty> id;
    private TableColumn<DriverTable,SimpleStringProperty> name;
    private HBox hb = new HBox();
    private final ObservableList<DriverTable> data = FXCollections.observableArrayList(
            new DriverTable("25879", "910612-2011","Andreas Johanson")
    );

    public VBox init(){
        tableSetup();
        database.updateDriver(data);
        setupButtons();

        hb.setSpacing(5);
        table.sort();
        final VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10, 0, 0, 10));
        vbox.getChildren().addAll(label, table, hb);

        return vbox;
    }

    private void tableSetup(){
        table.setEditable(true);

        driverId = new TableColumn<>("Driver Id");
        driverId.setMinWidth(300);
        driverId.setCellValueFactory(new PropertyValueFactory<>("driverId"));

        id = new TableColumn<>("Personal Id");
        id.setMinWidth(300);
        id.setCellValueFactory(new PropertyValueFactory<>("id"));

        name = new TableColumn<>("Name");
        name.setMinWidth(300);
        name.setCellValueFactory(new PropertyValueFactory<>("name"));

        table.setItems(data);
        table.setPrefWidth(250);
        table.setMinHeight(550);
        table.getColumns().addAll(driverId, id, name);
    }

    private void setupButtons(){
        final Text warn = new Text("Invalid input! Please try again");
        warn.getStyleClass().add("custom-redTitle");

        final Text duplicate = new Text("Duplicate input! Please try again");
        duplicate.getStyleClass().add("custom-redTitle");

        final TextField addDriverId = new TextField();
        addDriverId.setPromptText("Driver Id");
        addDriverId.setMinWidth(driverId.getPrefWidth());

        final TextField addId = new TextField();
        addId.setPromptText("Personal Id");
        addId.setMinWidth(id.getPrefWidth());

        final TextField addName = new TextField();
        addName.setPromptText("Name");
        addName.setMinWidth(name.getPrefWidth());

        setupAddButton(addDriverId,addId,addName,warn,duplicate);
        setupDeleteButton(addDriverId);
    }


    /**
     * Adds 3 TextFields one for each value and then adds a Add and remove button.
     * Also holds two text fields to provide feedback to the user when providing bad input.
     */
    private void setupAddButton(TextField addDriverId, TextField addId, TextField addName, Text warn, Text duplicate){
        Button addButton = new Button("Add");
        addButton.setOnAction((event) -> {
            if (checkInput(addDriverId.getText(),addName.getText(),addId.getText()) && checkForDuplicates(addId.getText(),addDriverId.getText(),addName.getText())){
                database.saveDriver(new Driver(addDriverId.getText(),addId.getText(),addName.getText()));

                hb.getChildren().remove(warn);
                hb.getChildren().remove(duplicate);
                addDriverId.clear();
                addId.clear();
                addName.clear();
            }else if (!(checkInput(addDriverId.getText(),addName.getText(),addId.getText()))){
                hb.getChildren().remove(duplicate);
                if (!(hb.getChildren().contains(warn))){
                    hb.getChildren().add(warn);
                }
            }else {
                hb.getChildren().remove(warn);
                if (!(hb.getChildren().contains(duplicate))){
                    hb.getChildren().add(duplicate);
                }
            }
        });

        hb.getChildren().addAll(addDriverId, addId, addName, addButton);
    }

    private void setupDeleteButton(TextField addDriverId){
        Button removeButton = new Button("Remove");
        removeButton.setOnAction((event) -> {
            for (int i = 0; i < data.size(); i++){
                if(data.get(i).getDriverId().equals(addDriverId.getText())){
                    database.deleteDriver(data.get(i).getName());
                    data.remove(i);
                    addDriverId.clear();
                }
            }
        });
        hb.getChildren().addAll(removeButton);
    }

    /**
     * Checks the validity of the user input.
     * @param driverId A string with 5 digits.
     * @param name A string containing a name.
     * @param id A string with a swedish personal id
     * @return True if all tests pass else false.
     */
    private boolean checkInput(String driverId, String name, String id){
        Driver checkId = new Driver();
        boolean check;
        check = driverId.length() == 5 && name.length() > 0 && id.length() == 11;

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

    /**
     * Checks the user input for duplicates in the database.
     * @return true if no matches are found else false.
     */
    private boolean checkForDuplicates(String id, String driverId, String name){
        for (DriverTable driver: data){
            if (driver.getId().equals(id) || driver.getDriverId().equals(driverId) || driver.getName().equals(name)){
                return false;
            }
        }
        return true;
    }
}
