package main.java.UI;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;


/**
 * Created by Spiks on 2016-04-22.
 */

/**
 * This is the Main page of the Application.
 */
public class Overview {
    private VBox root = new VBox(10);
    private HBox titleBox = new HBox();
    private Text title = new Text("Buss Deluxe");
    private TextField input = new TextField();
    private HBox time = new HBox();
    private Firebase ref = new Firebase("https://buss-database.firebaseIO.com//live//system");
    private Label helpText = new Label("This is the Start page for the application Buss Deluxe.\n You can save notes here simply by writing YYYY-MM-DD and your note this will stay here " +
            "on the page to serve as a reminder");

    /**
     * Initial setup of the page.
     * @return A VBox panel with the page content.
     */
    public VBox init(){

        input.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                pushDataToFirebase(input.getText());
            }
        });


        title.getStyleClass().add("custom-title");
        title.setId("custom-title");
        titleBox.getChildren().addAll(title);
        titleBox.setAlignment(Pos.CENTER);
        loadDataFromFirebase();

        root.getChildren().addAll(titleBox,input,helpText);
        return root;
    }

    /**
     * Loads in the Post-it notes from the Firebase database.
     */
    private void loadDataFromFirebase(){

        //ref.addListenerForSingleValueEvent(new ValueEventListener() {
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                for (DataSnapshot postSnapshot: snapshot.getChildren()) {
                   presentOnList(postSnapshot.getKey() + ": " + postSnapshot.getValue());
                }
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {
                System.out.println("The read failed: " + firebaseError.getMessage());
            }
        });
    }

    /**
     * Uploads new Post-it notes to firebase.
     * @param input A string containing a note this needs to be YYYY-MM-DD + message.
     */
    private void pushDataToFirebase(String input){
        String key = input.substring(0,10);
        String value = input.substring(10);
        ref.child(key).setValue(value);
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    /**
     * Adds new content to the Page.
     * @param input Post-it note.
     */
    private void presentOnList(String input){
        Platform.runLater(new Runnable(){
            @Override
            public void run() {
                Label in = new Label(input);
                VBox holder = new VBox();
                holder.getChildren().add(in);
                root.getChildren().add(holder);
            }
        });
    }
}


