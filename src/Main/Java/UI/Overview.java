package main.java.UI;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

import javafx.application.Platform;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import main.java.Buss_lines.NoteDatabase;
import main.java.Objekt.javaFxObjects.NoteTable;


/**
 * Created by Spiks on 2016-04-22.
 * In the project Buss_System
 */

/**
 * This is the Main page of the Application.//TODO REDO this screen since its bad.
 */
public class Overview {
    private NoteDatabase database = new NoteDatabase();
    private VBox root = new VBox(10);
    private HBox titleBox = new HBox();
    private Text title = new Text("Buss Deluxe");
    private Label label = new Label("Sticky Notes");
    private final TableView<NoteTable> table = new TableView<>();
    private ObservableList<NoteTable> data = FXCollections.observableArrayList();
    private HBox hb = new HBox();
    private TableColumn<NoteTable,SimpleStringProperty> date;
    private TableColumn<NoteTable,SimpleStringProperty> message;

    /**
     * Initial setup of the page.
     * @return A VBox panel with the page content.
     */
    public VBox init(){
        tableSetup();
        database.getPost(data);
        setupButtons();

        title.getStyleClass().add("custom-title");
        title.setId("custom-title");
        titleBox.getChildren().addAll(title);
        titleBox.setAlignment(Pos.CENTER);

        hb.setSpacing(5);
        root.setSpacing(5);
        root.setPadding(new Insets(10, 0, 0, 10));
        root.getChildren().addAll(titleBox,label,table,hb);
        return root;
    }

    private void tableSetup(){
        date = new TableColumn<>("Date");
        date.setMinWidth(250);
        date.setCellValueFactory(new PropertyValueFactory<>("date"));

        message = new TableColumn<>("Message");
        message.setMinWidth(500);
        message.setCellValueFactory(new PropertyValueFactory<>("message"));

        table.setItems(data);
        table.setPrefWidth(250);
        table.setMinHeight(500);
        table.getColumns().addAll(date,message);
    }

    private void setupButtons(){
        final Text warn = new Text("Invalid input! Please try again");
        warn.getStyleClass().add("custom-redTitle");

        final Text duplicate = new Text("Duplicate input! Please try again");
        duplicate.getStyleClass().add("custom-redTitle");

        final TextField addDate = new TextField();
        addDate.setPromptText("Date");
        addDate.setMaxWidth(date.getPrefWidth());

        final TextField addMessage = new TextField();
        addMessage.setPromptText("Message");
        addMessage.setMaxWidth(message.getPrefWidth());

        setupAddButton(addDate,addMessage,warn,duplicate);
        setupDeleteButton(addDate);
    }

    private void setupAddButton(TextField addDate, TextField addMessage,Text warn, Text duplicate){
        Button addButton = new Button("Add");
        addButton.setOnAction(event -> {
            if (checkInput(addDate.getText(),addMessage.getText()) && checkForDuplicates(addDate.getText())){
                database.saveNote(addDate.getText(),addMessage.getText());
                hb.getChildren().remove(warn);
                hb.getChildren().remove(duplicate);
                addDate.clear();
                addMessage.clear();
            }else if (!(checkInput(addDate.getText(),addMessage.getText()))){
                hb.getChildren().remove(duplicate);
                if (!(hb.getChildren().contains(warn))) {
                    hb.getChildren().add(warn);
                }
            }else {
                hb.getChildren().remove(warn);
                if (!(hb.getChildren().contains(duplicate))){
                    hb.getChildren().add(duplicate);
                }
            }
        });
        hb.getChildren().addAll(addDate, addMessage, addButton);
    }

    private void setupDeleteButton(TextField addDate){
        Button removeButton = new Button("Remove");
        removeButton.setOnAction(event -> {
            data.stream().forEach(noteTable -> {
                if (noteTable.getDate().equals(addDate.getText())){
                    database.removeNote(addDate.getText());
                    removeFromList(noteTable);
                    addDate.clear();
                }
            });
        });
        hb.getChildren().add(removeButton);
    }

    private boolean checkInput(String date, String message){
        System.out.println("Checking input date:" + date);
        return date.length() == 10 && message.length() > 0 && date.charAt(4) == '-' && date.charAt(7) == '-';
    }

    private boolean checkForDuplicates(String date){
        for (NoteTable note:data) {
            if (note.getDate().equals(date)){
                return false;
            }
        }
        return true;
    }

    /**
     * Removes a child element from the list.
     * @param input Post-it note.
     */
    private void removeFromList(NoteTable input){
        Platform.runLater(new Runnable(){
            @Override
            public void run() {
                data.remove(input);
            }
        });
    }
}


