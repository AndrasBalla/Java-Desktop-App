package main.unused_classes;

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
        ArrayList<Buss> list = database.getBuss(data);
        for (int i = 0; i < list.size(); i++){
            BussTable buss = new BussTable(list.get(i).getId(),list.get(i).getRegId(),list.get(i).getActive() + "");
            if (!(data.contains(buss)))
            data.add(buss);
        }
        //database.updateBuss(data,table);
    }

    /**
     * Adds 3 TextFields one for each value and then adds a Add and remove button.
     * Also holds two text fields to provide feedback to the user when providing bad input.
     */
    private void setupAddButtons(){
        final Text warn = new Text("Invalid input! Please try again");
        warn.getStyleClass().add("custom-redTitle");

        final Text duplicate = new Text("Duplicate input! Please try again");
        duplicate.getStyleClass().add("custom-redTitle");

        final TextField addId = new TextField();
        addId.setPromptText("Buss Id");
        addId.setMaxWidth(idCol.getPrefWidth());

        final TextField addActive = new TextField();
        addActive.setPromptText("Active");
        addActive.setMaxWidth(activeCol.getPrefWidth());

        final ComboBox comboBox = new ComboBox();
        comboBox.getItems().addAll("true","false");
        //comboBox.setValue("false");

        final TextField addRegId = new TextField();
        addRegId.setPromptText("Reg number");
        addRegId.setMaxWidth(regCol.getPrefWidth());

        Button addButton = new Button("Add");
        addButton.setOnAction((event) -> {
            if (checkInput(addId.getText(),addRegId.getText(),comboBox) && checkForDuplicates(addId.getText(),addRegId.getText().toUpperCase(),comboBox)){
                data.add(new BussTable(
                        addId.getText(),
                        addRegId.getText().toUpperCase(),
                        comboBox.getValue().toString()));
                database.saveBuss(new Buss(addId.getText(),addRegId.getText().toUpperCase(),comboBox.getValue().toString()));

                hb.getChildren().remove(warn);
                hb.getChildren().remove(duplicate);
                addId.clear();
                addActive.clear();
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

        Button removeButton = new Button("Remove");
        removeButton.setOnAction((event) -> {
            for (int i = 0; i < data.size(); i++){
                if(data.get(i).getId().equals(addId.getText())){
                    database.deleteBuss(data.get(i).getId());
                    data.remove(i);
                }
            }
        });

        hb.getChildren().addAll(addId, comboBox, addRegId, addButton, removeButton);
    }

    /**
     * Checks the input values provided by the user.
     * @param id String id for a Buss. This has to be three digits.
     * @param regId Buss registration number this folows the swedish standard XXX000.
     * @param active Boolean value which shows if the buss is active or not.
     * @return Boolean value true if all tests pass else false.
     */
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

    /**
     * Checks the input provided by the user for duplicate elements in the database.
     * @param id Buss id of three digits no two buses can have the same id.
     * @param regId Registration number of a buss these are always unique.
     * @return Boolean value true if no matches found else false.
     */
    private boolean checkForDuplicates(String id, String regId, ComboBox active){
        /*ArrayList<Buss> list = database.getBuss(data);
        System.out.println(list.toString());
        for (int i = 0; i < list.size(); i++){
            if (list.get(i).getId().equals(id) || list.get(i).getRegId().equals(regId)){
                return false;
            }
        }*/
        return true;
    }

}
