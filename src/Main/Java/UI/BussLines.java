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
import main.java.Buss_lines.BussDatabase;
import main.java.Buss_lines.LineDatabase;
import main.java.Objekt.Buss;
import main.java.Objekt.Line;
import main.java.Objekt.javaFxObjects.LineTable;

import java.util.ArrayList;

/**
 * Created by Spiks on 2016-04-30.
 * In the project Buss_System
 */
public class BussLines {
    private LineDatabase database = new LineDatabase();
    private BussDatabase bussDatabase = new BussDatabase();
    private final TableView<LineTable> table = new TableView<>();
    private Label label = new Label("Buss Lines");
    private TableColumn<LineTable,SimpleStringProperty> idCol;
    private TableColumn<LineTable,SimpleStringProperty> bussCol;
    private TableColumn<LineTable,SimpleStringProperty> sourceCol;
    private TableColumn<LineTable,SimpleStringProperty> destinationCol;
    private HBox hb = new HBox();
    private ObservableList<LineTable> data = FXCollections.observableArrayList();
    private ArrayList<Buss> buses = new ArrayList<>();

    public VBox init(){
        tableSetup();
        database.updateLine(data);
        setupButtons();

        hb.setSpacing(5);
        final VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10, 0, 0, 10));
        vbox.getChildren().addAll(label, table, hb);

        return vbox;
    }

    /**
     * Replace this with 1 table with 2 arrays as a base. Array 1 will show a list with all the buss lines with ids, start and end stop while
     * array 2 will present a single line with the option to add stops and edit fields.
     */
    private void tableSetup(){
        table.setEditable(true);

        idCol = new TableColumn<>("Line Id");
        idCol.setMinWidth(250);
        idCol.setCellValueFactory(new PropertyValueFactory<>("id"));

        bussCol = new TableColumn<>("Buss");
        bussCol.setMinWidth(250);
        bussCol.setCellValueFactory(new PropertyValueFactory<>("buss"));

        TableColumn<LineTable,SimpleStringProperty> bussId = new TableColumn<>("Buss Id");
        bussId.setCellValueFactory(new PropertyValueFactory<>("bussId"));

        TableColumn<LineTable,SimpleStringProperty> bussRegId = new TableColumn<>("Buss Registration");
        bussRegId.setCellValueFactory(new PropertyValueFactory<>("regId"));

        TableColumn<LineTable,SimpleStringProperty> bussActive = new TableColumn<>("Buss State");
        bussActive.setCellValueFactory(new PropertyValueFactory<>("active"));

        bussCol.getColumns().addAll(bussId,bussRegId,bussActive);

        sourceCol = new TableColumn<>("Starting station");
        sourceCol.setMinWidth(250);

        TableColumn<LineTable,SimpleStringProperty> sourceId = new TableColumn<>("Id");
        sourceId.setCellValueFactory(new PropertyValueFactory<LineTable,SimpleStringProperty>("sourceId"));
        TableColumn<LineTable,SimpleStringProperty> sourceLoc = new TableColumn<>("Location");
        sourceLoc.setCellValueFactory(new PropertyValueFactory<>("sourceLoc"));
        TableColumn<LineTable,SimpleStringProperty> sourceName = new TableColumn<>("Name");
        sourceName.setCellValueFactory(new PropertyValueFactory<>("sourceName"));
        sourceCol.getColumns().addAll(sourceId,sourceLoc,sourceName);

        destinationCol = new TableColumn<>("End station");
        destinationCol.setMinWidth(250);

        TableColumn<LineTable,SimpleStringProperty> destinationId = new TableColumn<>("Id");
        destinationId.setCellValueFactory(new PropertyValueFactory<>("destinationId"));
        TableColumn<LineTable,SimpleStringProperty> destinationLoc = new TableColumn<>("Location");
        destinationLoc.setCellValueFactory(new PropertyValueFactory<>("destinationLoc"));
        TableColumn<LineTable,SimpleStringProperty> destinationName = new TableColumn<>("Name");
        destinationName.setCellValueFactory(new PropertyValueFactory<>("destinationName"));
        destinationCol.getColumns().addAll(destinationId,destinationLoc,destinationName);

        table.setItems(data);
        table.setPrefWidth(250);
        table.setMinHeight(550);
        table.getColumns().addAll(idCol, bussCol, sourceCol, destinationCol);
    }

    private void setupButtons(){
        final Text warn = new Text("Invalid input! Please try again");
        warn.getStyleClass().add("custom-redTitle");

        final Text duplicate = new Text("Duplicate input! Please try again");
        duplicate.getStyleClass().add("custom-redTitle");

        final TextField addId = new TextField();
        addId.setPromptText("Line Id");
        addId.setMaxWidth(idCol.getPrefWidth());

        final ComboBox<String> addBuss = new ComboBox<>();
        bussDatabase.getBussForLine(addBuss,buses);

        setupAddButton(addId,addBuss,warn,duplicate);
        setupDeleteButton(addId,addBuss);
    }

    private void setupAddButton(TextField addId, ComboBox addBuss, Text warn, Text duplicate){
        Button addButton = new Button("Add");
        addButton.setOnAction((event) -> {
            if (checkInput(addId.getText()) && checkForDuplicates(addId.getText())){
                database.saveLine(new Line(addId.getText(),getBuss(addBuss.getValue().toString())));
                addBuss.getItems().remove(addBuss.getValue());
                hb.getChildren().remove(warn);
                hb.getChildren().remove(duplicate);
                addId.clear();
            }else if (!(checkInput(addId.getText()))){
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

        hb.getChildren().addAll(addId, addBuss, addButton);
    }

    private void setupDeleteButton(TextField addId, ComboBox<String> addBuss){
        Button removeButton = new Button("Remove");
        removeButton.setOnAction((event) -> {
            for (int i = 0; i < data.size(); i++){
                if(data.get(i).getId().equals(addId.getText())){
                    database.deleteLine(data.get(i).getId());
                    Buss removed = new Buss(data.get(i).getBussId(),data.get(i).getRegId(),"false");
                    bussDatabase.saveBuss(removed);
                    addBuss.getItems().add(removed.getId());
                    data.remove(i);
                    addId.clear();
                }
            }
        });
        hb.getChildren().add(removeButton);
    }

    private boolean checkInput(String id){
        if (id.length() != 2){
            return false;
        }else if (Character.isDigit(id.charAt(0)) || Character.isDigit(id.charAt(1))){
            return true;
        }else {
            return false;
        }
    }

    private boolean checkForDuplicates(String id){
        for (int i = 0; i < data.size(); i++){
            if (data.get(i).getId().equals(id)){
                return false;
            }
        }
        return true;
    }

    private Buss getBuss(String id){
        for (int i = 0; i < buses.size(); i++){
            if (buses.get(i).getId().equals(id)){
                buses.get(i).setActive("true");
                bussDatabase.saveBuss(buses.get(i));
                return buses.get(i);
            }
        }
        return null;
    }
}
