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
import main.java.Objekt.Line;
import main.java.Objekt.Stop;
import main.java.Objekt.javaFxObjects.StopTable;

import java.util.ArrayList;

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
    private HBox choose = new HBox();
    private ArrayList<Line> lines = new ArrayList<>();
    private Line current = new Line();

    public VBox init(){
        tableSetup();
        setupButtons();
        setupLineChoice();

        hb.setSpacing(5);
        final VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10, 0, 0, 10));
        vbox.getChildren().addAll(choose,table, hb);

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
        addId.setPromptText("Stop Id");
        addId.setMaxWidth(idCol.getPrefWidth());

        final TextField addName = new TextField();
        addName.setPromptText("Stop Name");
        addName.setMaxWidth(nameCol.getPrefWidth());

        final TextField addLoc = new TextField();
        addLoc.setPromptText("Stop Location");
        addLoc.setMaxWidth(locationCol.getPrefWidth());

        setupAddButton(addId,addName,addLoc,warn,duplicate);
        setupDeleteButton(addId);
        tableEdit(addId,addName,addLoc);
    }

    private void tableEdit(TextField addId, TextField addName,TextField addLoc){
        Button edit = new Button("Edit");
        hb.getChildren().add(edit);

        final Text warn = new Text("Invalid input! Please try again");
        warn.getStyleClass().add("custom-redTitle");

        edit.setOnAction(event -> {
            if (checkInput(addId,addName,addLoc)){
                String id = addId.getText();
                hb.getChildren().remove(warn);
                for (StopTable stop: data){
                    if (stop.getId().equals(id)){
                        stop.setName(addName.getText());
                        stop.setLocation(addLoc.getText());
                        current.updateStop(id,addName.getText(),addLoc.getText());
                        current.setSource(current.getStops().get(0));
                        current.setDest(current.getStops().get(current.getStops().size()-1));
                        database.saveLine(current);
                    }
                }
                addId.clear();
                addName.clear();
                addLoc.clear();
            }else if (!(checkInput(addId,addName,addLoc))){
                if (!(hb.getChildren().contains(warn))){
                    hb.getChildren().add(warn);
                }
            }
        });
    }

    private void setupAddButton(TextField addId, TextField addName,TextField addLoc, Text warn, Text duplicate) {
        Button addButton = new Button("Add");
        addButton.setOnAction((event) -> {
            if (checkInput(addId,addName,addLoc) && checkForDuplicates(addId.getText())){
                Stop stop = new Stop(addId.getText(),addName.getText(),addLoc.getText());
                current.addStops(stop);
                current.setSource(current.getStops().get(0));
                current.setDest(current.getStops().get(current.getStops().size()-1));
                database.saveLine(current);
                hb.getChildren().remove(warn);
                hb.getChildren().remove(duplicate);
                addId.clear();
                addName.clear();
                addLoc.clear();
            }else if (!(checkInput(addId,addName,addLoc))){
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
        hb.getChildren().addAll(addId, addName,addLoc, addButton);
    }

    private void setupDeleteButton(TextField addId){
        Button removeButton = new Button("Remove");
        removeButton.setOnAction((event) -> {
            current.removeStop(addId.getText());
            current.setSource(current.getStops().get(0));
            current.setDest(current.getStops().get(current.getStops().size()-1));
            database.saveLine(current);
        });
        hb.getChildren().add(removeButton);
    }

    private void setupLineChoice(){
        Label label = new Label("Choose a Line");
        ComboBox<String> boxLines = new ComboBox<>();
        database.getLineIds(boxLines,lines);
        Button show = new Button("Show");

        show.setOnAction(event ->{
            data.clear();
            database.getStops(data,boxLines.getValue());
            lines.stream().forEach(line -> {
                if (line.getId().equals(boxLines.getValue())){
                    current = line;
                }
            });
        });
        hb.getChildren().addAll(label,boxLines,show);
    }

    private boolean checkInput(TextField addId, TextField addName,TextField addLoc){
        return !(addName.getText().equals("") || addLoc.getText().equals("") || addId.getText().equals("")) && addId.getText().length() == 2 && current.getId() != null;
    }

    private boolean checkForDuplicates(String id){
        for (StopTable stop:data) {
            if (stop.getId().equals(id)){
                return false;
            }
        }
        return true;
    }
}
