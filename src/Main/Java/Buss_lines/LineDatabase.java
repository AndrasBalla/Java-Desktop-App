package main.java.Buss_lines;

import com.firebase.client.ChildEventListener;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;
import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;
import main.java.Objekt.Buss;
import main.java.Objekt.Line;
import main.java.Objekt.Stop;
import main.java.Objekt.javaFxObjects.LineTable;
import main.java.Objekt.javaFxObjects.StopTable;

import java.util.ArrayList;

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
        newLine.child("dest").setValue(line.getDest());
        newLine.child("source").setValue(line.getSource());
    }

    /**
     * Removes a line from the database.
     * @param id The id value of the line to be removed.
     */
    public void deleteLine(String id){
        Firebase remove = new Firebase("https://buss-database.firebaseIO.com//live//lines//" + id);
        remove.setValue(null);
    }

    /**
     * Gets all the lines from the database and adds them to the table.
     * @param data The ObservableList that used to populate the TableView.
     */
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
                data.stream().forEach(line -> {
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
                });
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

    public void getLineIds(ComboBox<String> lines, ArrayList<Line> list){
        refLine.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                lines.getItems().add(dataSnapshot.getKey());
                Line basicLine = dataSnapshot.getValue(Line.class);
                list.add(basicLine);
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {}

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {}

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {}

            @Override
            public void onCancelled(FirebaseError firebaseError) {}
        });
    }

    public void getStops(ObservableList<StopTable> data, String id){
        refLine.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                Line line = dataSnapshot.getValue(Line.class);
                if (id.equals(line.getId())){
                    ArrayList<Stop> lines = line.getStops();
                    for (Stop stop: lines){
                        data.add(new StopTable(stop.getId(),stop.getName(),stop.getLocation()));
                    }
                }
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {
                Line line = dataSnapshot.getValue(Line.class);
                ArrayList<StopTable> tableList = new ArrayList<>();
                line.getStops().stream().forEach(stop -> {
                    StopTable stopTable = new StopTable(stop.getId(),stop.getName(),stop.getLocation());
                    tableList.add(stopTable);
                });
                data.setAll(tableList);
            }



            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {}

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {}

            @Override
            public void onCancelled(FirebaseError firebaseError) {}
        });
    }

    public void removeStop(){

    }
}
