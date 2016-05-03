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
import main.java.Buss_lines.LineDatabase;
import main.java.Objekt.javaFxObjects.StopTable;

/**
 * Created by Spiks on 2016-05-03.
 * In the project Buss_System//TODO finish implementing this class.
 */
public class DetailedBussLine {
    private LineDatabase database = new LineDatabase();
    private final TableView<StopTable> table = new TableView<>();
    private HBox hb = new HBox();
    private ObservableList<StopTable> data = FXCollections.observableArrayList();
    private TableColumn<StopTable,SimpleStringProperty> idCol;
    private TableColumn<StopTable,SimpleStringProperty> nameCol;
    private TableColumn<StopTable,SimpleStringProperty> locationCol;

    public VBox init(){
        tableSetup();
        //database.updateLine(data);
        setupButtons();

        hb.setSpacing(5);
        final VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10, 0, 0, 10));
        vbox.getChildren().addAll(table, hb);

        return vbox;
    }

    private void tableSetup(){
        idCol = new TableColumn<>("Stop id");
        idCol.setMinWidth(250);
        idCol.setCellValueFactory(new PropertyValueFactory<>("id"));

        nameCol = new TableColumn<>("Stop name");
        nameCol.setMinWidth(250);
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));

        locationCol = new TableColumn<>("Stop location");
        locationCol.setMinWidth(250);
        locationCol.setCellValueFactory(new PropertyValueFactory<>("location"));

        table.setItems(data);
        table.setPrefWidth(250);
        table.setMinHeight(550);
        table.getColumns().addAll(idCol,nameCol, locationCol);
    }

    private void setupButtons(){
        final Text warn = new Text("Invalid input! Please try again");
        warn.getStyleClass().add("custom-redTitle");

        final Text duplicate = new Text("Duplicate input! Please try again");
        duplicate.getStyleClass().add("custom-redTitle");

        final TextField addId = new TextField();
        addId.setPromptText("Line Id");
        addId.setMaxWidth(idCol.getPrefWidth());

        final TextField addName = new TextField();
        addName.setPromptText("Line Name");
        addName.setMaxWidth(nameCol.getPrefWidth());

        final TextField addLoc = new TextField();
        addLoc.setPromptText("Line Location");
        addLoc.setMaxWidth(locationCol.getPrefWidth());

        setupAddButton(addId,addName,addLoc,warn,duplicate);
        setupDeleteButton(addId);
    }

    private void setupAddButton(TextField addId, TextField addName,TextField addLoc, Text warn, Text duplicate) {
        Button addButton = new Button("Add");
        addButton.setOnAction((event) -> {

        });
        hb.getChildren().addAll(addId, addName,addLoc, addButton);
    }

    private void setupDeleteButton(TextField addId){
        Button removeButton = new Button("Remove");
        removeButton.setOnAction((event) -> {
            /*for (int i = 0; i < data.size(); i++){
                if(data.get(i).getId().equals(addId.getText())){
                    database.deleteLine(data.get(i).getId());
                    Buss removed = new Buss(data.get(i).getBussId(),data.get(i).getRegId(),"false");
                    bussDatabase.saveBuss(removed);
                    addBuss.getItems().add(removed.getId());
                    data.remove(i);
                    addId.clear();
                }
            }*/
        });
        hb.getChildren().add(removeButton);
    }
}
