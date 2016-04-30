package main.java.UI;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import main.java.Buss_lines.BussDatabase;
import main.java.Objekt.Buss;
import main.java.Objekt.javaFxObjects.BussTable;

/**
 * Created by Spiks on 2016-04-29.
 */
public class Garage {
    private BussDatabase database = new BussDatabase();
    private final TableView<BussTable> table = new TableView();
    private Label label = new Label("Garage");
    private TableColumn idCol;
    private TableColumn activeCol;
    private TableColumn regCol;
    private HBox hb = new HBox();
    private ObservableList<BussTable> data = FXCollections.observableArrayList();

    /**
     * Initial Setup of the Garage window.
     * First Builds the Table then populates the list with content and adds Buttons to the bottom.
     * @return VBox containing the garage content.
     */
    public VBox init(){
        tableSetup();
        database.updateBuss(data);
        setupButtons();

        hb.setSpacing(5);
        final VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10, 0, 0, 10));
        vbox.getChildren().addAll(label, table, hb);

        return vbox;
    }

    private void tableSetup(){
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

        table.setItems(data);
        table.setPrefWidth(250);
        table.setMinHeight(550);
        table.getColumns().addAll(idCol, activeCol, regCol);
    }

    /**
     * Sets up two texts for user feedback and three textfields for user input.
     */
    private void setupButtons(){
        final Text warn = new Text("Invalid input! Please try again");
        warn.getStyleClass().add("custom-redTitle");

        final Text duplicate = new Text("Duplicate input! Please try again");
        duplicate.getStyleClass().add("custom-redTitle");

        final TextField addId = new TextField();
        addId.setPromptText("Buss Id");
        addId.setMaxWidth(idCol.getPrefWidth());

        final ComboBox comboBox = new ComboBox();
        comboBox.getItems().addAll("true","false");

        final TextField addRegId = new TextField();
        addRegId.setPromptText("Reg number");
        addRegId.setMaxWidth(regCol.getPrefWidth());

        setupAddButton(addId,addRegId,comboBox,warn,duplicate);
        setupDeleteButton(addId);
    }

    /**
     * Adds 3 TextFields one for each value and then adds a Add and remove button.
     * Also holds two text fields to provide feedback to the user when providing bad input.
     */
    private void setupAddButton(TextField addId, TextField addRegId, ComboBox comboBox, Text warn, Text duplicate){
        Button addButton = new Button("Add");
        addButton.setOnAction((event) -> {
            if (checkInput(addId.getText(),addRegId.getText(),comboBox) && checkForDuplicates(addId.getText(),addRegId.getText().toUpperCase())){
                database.saveBuss(new Buss(addId.getText(),addRegId.getText().toUpperCase(),comboBox.getValue().toString()));
                hb.getChildren().remove(warn);
                hb.getChildren().remove(duplicate);
                addId.clear();
                addRegId.clear();
            }else if (!(checkInput(addId.getText(),addRegId.getText(),comboBox))){
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

        hb.getChildren().addAll(addId, comboBox, addRegId, addButton);
    }

    private void setupDeleteButton(TextField addId){
        Button removeButton = new Button("Remove");
        removeButton.setOnAction((event) -> {
            for (int i = 0; i < data.size(); i++){
                if(data.get(i).getId().equals(addId.getText())){
                    database.deleteBuss(data.get(i).getId());
                    data.remove(i);
                    addId.clear();
                }
            }
        });
        hb.getChildren().add(removeButton);
    }

    private boolean checkInput(String id, String regId, ComboBox active){
        boolean check = false;
        if (id.length() == 3 && regId.length() == 6 && active.getValue() != null){
            check = true;
        }else {
            return false;
        }

        for (int i = 0; i < id.length(); i++){
            if(!(Character.isDigit(id.charAt(i)))){
                return false;
            }
        }
        if (Character.isLetter(regId.charAt(0)) && Character.isLetter(regId.charAt(1))&& Character.isLetter(regId.charAt(2)) &&
                Character.isDigit(regId.charAt(3)) && Character.isDigit(regId.charAt(4)) && Character.isDigit(regId.charAt(5))){
            check = true;
        }else {
            check = false;
        }
        return check;
    }

    private boolean checkForDuplicates(String id, String regId){
        for (int i = 0; i < data.size(); i++){
            if (data.get(i).getId().equals(id) || data.get(i).getRegId().equals(regId)){
                return false;
            }
        }
        return true;
    }
}
