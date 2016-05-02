package main.java.Buss_lines;

import com.firebase.client.*;
import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;
import main.java.Objekt.*;
import main.java.Objekt.javaFxObjects.BussTable;

import java.util.ArrayList;

/**
 * Created by Spiks on 2016-04-16.
 * In the project Buss_System
 */

/**
 * BussDatabase Object that will hold all the methods used in communicating with Firebase.
 */
public class BussDatabase {
    private Firebase refBuss = new Firebase("https://buss-database.firebaseIO.com//live//garage");

    /**
     * Uploads a buss Object to Firebase.
     * @param buss Buss Object to be saved.
     */
    public void saveBuss(Buss buss){
        Firebase newBuss = refBuss.child(buss.getId());
        newBuss.child("active").setValue(buss.getActive());
        newBuss.child("id").setValue(buss.getId());
        newBuss.child("regId").setValue(buss.getRegId());
    }

    /**
     * Removes a buss from firebase.
     * @param id String id of the Buss to be removed.
     */
    public void deleteBuss(String id){
        Firebase remove = new Firebase("https://buss-database.firebaseIO.com//live//garage//" + id);
        remove.setValue(null);
    }

    /**
     * Gets all the buses from the database and adds them to the table.
     * @param data The ObservableList that used to populate the TableView.
     */
    public void updateBuss(ObservableList<BussTable> data){

        refBuss.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                Buss buss = dataSnapshot.getValue(Buss.class);
                data.add(new BussTable(dataSnapshot.getKey(),buss.getRegId(),buss.getActive() + ""));
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {
                Buss basicBuss = dataSnapshot.getValue(Buss.class);
                basicBuss.setId(dataSnapshot.getKey());
                for (BussTable buss: data){
                    if (buss.getId().equals(dataSnapshot.getKey())){
                        buss.setId(dataSnapshot.getKey());
                        buss.setActive(basicBuss.getActive());
                        buss.setRegId(basicBuss.getRegId());
                    }
                }
                System.out.println("Child changed: " + dataSnapshot);
            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {
                for (int i = 0; i < data.size(); i++) {
                    if (data.get(i).getId().equals(dataSnapshot.getKey())) {
                        data.remove(i);
                    }
                }
            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {}

            @Override
            public void onCancelled(FirebaseError firebaseError) {
                System.out.println("The read failed: " + firebaseError.getMessage());
            }
        });
    }

    public void getBussForLine(ComboBox<String> buss, ArrayList<Buss> buses){
        refBuss.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                Buss basicBuss = dataSnapshot.getValue(Buss.class);
                buses.add(basicBuss);
                if (basicBuss.getActive().equals("false"))
                buss.getItems().add(basicBuss.getId());
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {}

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {}

            @Override
            public void onCancelled(FirebaseError firebaseError) {}
        });
    }
}
