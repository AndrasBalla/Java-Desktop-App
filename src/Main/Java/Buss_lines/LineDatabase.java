package main.java.Buss_lines;

import com.firebase.client.ChildEventListener;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import javafx.scene.control.ComboBox;
import main.java.Objekt.Buss;
import main.java.Objekt.Line;
import main.java.Objekt.Stop;

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

    public void updateLine(ComboBox lines){
        refLine.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                System.out.println(dataSnapshot);
                Line line = dataSnapshot.getValue(Line.class);
                lines.getItems().add(dataSnapshot.getKey());
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {}

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

    /*public Line setupTest(){
        Buss buss = new Buss("101","DXD868","false");
        Line line = new Line();
        line.setId("11");
        line.setBuss(buss);
        Stop oneStop = new Stop("01","Ringen","Halmstad");
        Stop twoStop = new Stop("02","Central","Halmstad");
        Stop threeStop = new Stop("03","Tåg","Halmstad");
        line.addStops(oneStop);
        line.addStops(twoStop);
        line.addStops(threeStop);
        return line;
    }*/
}
