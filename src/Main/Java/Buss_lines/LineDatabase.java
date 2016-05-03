package main.java.Buss_lines;

import com.firebase.client.ChildEventListener;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import javafx.collections.ObservableList;
import main.java.Objekt.Buss;
import main.java.Objekt.Line;
import main.java.Objekt.javaFxObjects.LineTable;

/**
 * Created by Spiks on 2016-04-30.
 * In the project Buss_System
 */
public class LineDatabase {
    private Firebase refLine = new Firebase("https://buss-database.firebaseIO.com//live//lines");

    /**
     * Uploads a Line Object to Firebase.
     * @param line Line Object to be saved.
     */
    public void saveLine(Line line){
        Firebase newLine = refLine.child(line.getId());
        newLine.child("id").setValue(line.getId());
        newLine.child("stops").setValue(line.getStops());
        newLine.child("buss").setValue(line.getBuss());
    }

    public void deleteLine(String id){
        Firebase remove = new Firebase("https://buss-database.firebaseIO.com//live//lines//" + id);
        remove.setValue(null);
    }

    public void updateLine(ObservableList<LineTable> data){
        refLine.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                Line line = dataSnapshot.getValue(Line.class);
                Buss buss = line.getBuss();
                LineTable table = new LineTable(line.getId(),line.getSource(),line.getDest(),buss.getId(),buss.getRegId(),buss.getActive());
                data.add(table);
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {
                Line basicLine = dataSnapshot.getValue(Line.class);
                for (LineTable line: data){
                    if (dataSnapshot.getKey().equals(line.getId())){
                        line.setId(dataSnapshot.getKey());
                        line.setBussId(basicLine.getBuss().getId());
                        line.setRegId(basicLine.getBuss().getRegId());
                        line.setActive(basicLine.getBuss().getActive());

                        line.setDestinationId(basicLine.getDest().getId());
                        line.setDestinationLoc(basicLine.getDest().getLocation());
                        line.setDestinationName(basicLine.getDest().getName());

                        line.setSourceId(basicLine.getSource().getId());
                        line.setSourceLoc(basicLine.getSource().getLocation());
                        line.setSourceName(basicLine.getSource().getName());
                    }
                }
                System.out.println("Child changed: " + dataSnapshot);
            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {}

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {}

            @Override
            public void onCancelled(FirebaseError firebaseError) {
                System.out.println("The read failed: " + firebaseError.getMessage());
            }
        });
    }
}
