package main.java.UI;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import main.java.Buss_lines.BussDatabase;
import main.java.Objekt.Buss;
import main.java.Objekt.javaFxObjects.BussTable;

import java.util.ArrayList;

/**
 * Created by Spiks on 2016-04-23.
 */

/**
 * Garage Window used to present the busses that are registered in the system. On this screen you can view, add and remove Buss objects.
 */
public class Garage {
    private BussDatabase database = new BussDatabase();
    private final TableView<BussTable> table = new TableView();
    final Label label = new Label("Garage");
    private TableColumn idCol;
    private TableColumn activeCol;
    private TableColumn regCol;
    private HBox hb = new HBox();
    private final ObservableList<BussTable> data = FXCollections.observableArrayList();

    /**
     * Initial Setup of the Garage window.
     * First Builds the Table then populates the list with content and adds Buttons to the bottom.
     * @return VBox containing the garage content.
     */
    public VBox init(){
        table.setEditable(true);

        idCol = new TableColumn("Buss Id");
        idCol.setMinWidth(250);
        idCol.setCellValueFactory(
                new PropertyValueFactory<>("id")
        );

        activeCol = new TableColumn("Active");
        activeCol.setMinWidth(250);
        activeCol.setCellValueFactory(
                new PropertyValueFactory<>("active")
        );

        regCol = new TableColumn("Registration nr.");
        regCol.setMinWidth(250);
        regCol.setCellValueFactory(
                new PropertyValueFactory<>("regId")
        );

        getList();
        setupAddButtons();

        table.setItems(data);
        table.setPrefWidth(250);
        table.setMinHeight(550);
        table.getColumns().addAll(idCol, activeCol, regCol);
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
        ArrayList<Buss> list = database.getBuss();
        for (int i = 0; i < list.size(); i++){
            data.add(new BussTable(list.get(i).getId(),list.get(i).getRegId(),list.get(i).getActive() + ""));
        }
    }

    /**
     * Adds 3 TextFields one for each value and then adds a Add and remove button.
     */
    private void setupAddButtons(){
        final TextField addId = new TextField();
        addId.setPromptText("Buss Id");
        addId.setMaxWidth(idCol.getPrefWidth());

        final TextField addActive = new TextField();
        addActive.setPromptText("Active");
        addActive.setMaxWidth(activeCol.getPrefWidth());

        final TextField addRegId = new TextField();
        addRegId.setPromptText("Reg number");
        addRegId.setMaxWidth(regCol.getPrefWidth());

        Button addButton = new Button("Add");
        addButton.setOnAction((event) -> {
            data.add(new BussTable(
                    addId.getText(),
                    addRegId.getText().toUpperCase(),
                    addActive.getText()));
            database.saveBuss(new Buss(addId.getText(),addRegId.getText().toUpperCase(),addActive.getText().toLowerCase()));
            addId.clear();
            addActive.clear();
            addRegId.clear();
        });

        Button removeButton = new Button("Remove");
        removeButton.setOnAction((event) -> {
            for (int i = 0; i < data.size(); i++){
                if(data.get(i).getId().toString().equals(addId.getText())){
                    database.deleteBuss(data.get(i).getRegId().toString());
                    data.remove(i);
                }
            }
        });

        hb.getChildren().addAll(addId, addActive, addRegId, addButton, removeButton);
    }

    private boolean checkInput(String driverId, String name, String id){
        boolean check = false;
        if (driverId.length() == 5 && name.length() > 0 && id.length() == 11){
            check = true;
        }
        for (int i = 0; i < driverId.length(); i++){
            if(!(Character.isDigit(driverId.charAt(i)))){
                return false;
            }
        }
        return check;
    }

}
