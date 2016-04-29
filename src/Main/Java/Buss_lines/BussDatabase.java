package main.java.Buss_lines;

import com.firebase.client.*;
import javafx.collections.ObservableList;
import javafx.scene.control.TableView;
import main.java.Objekt.*;
import main.java.Objekt.javaFxObjects.BussTable;

import java.util.ArrayList;

/**
 * Created by Spiks on 2016-04-16.
 */

/**
 * BussDatabase Object that will hold all the methods used in communicating with Firebase.
 */
public class BussDatabase {
    private Firebase refBuss = new Firebase("https://buss-database.firebaseIO.com//live//garage");
    private ArrayList<Buss> bussList = new ArrayList<>();

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
     * Gets all the busses from firebase and stores them in a array. UNUSED at the moment.
     * @return ArrayList<Buss>.
     */
    public ArrayList<Buss> getBuss(ObservableList<BussTable> data){
        refBuss.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                for (DataSnapshot postSnapshot: snapshot.getChildren()) {
                    Buss buss = postSnapshot.getValue(Buss.class);
                    bussList.add(buss);
                    BussTable buses = new BussTable(buss.getId(),buss.getRegId(),buss.getActive() + "");
                    if (data.contains(buses)){
                        data.add(buses);
                    }
                }
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {
                System.out.println("The read failed: " + firebaseError.getMessage());
            }
        });
        try {
            Thread.sleep(300);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
        return bussList;
    }

    /**
     * Removes a buss from firebase.
     * @param id
     */
    public void deleteBuss(String id){
        Firebase remove = new Firebase("https://buss-database.firebaseIO.com//live//garage//" + id);
        remove.setValue(null);
    }

    public void updateBuss(ObservableList<BussTable> data, TableView<BussTable> table){
        refBuss.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                Buss buss = dataSnapshot.getValue(Buss.class);
                if (buss.getId() != null){
                    data.add(new BussTable(buss.getId(),buss.getRegId(),buss.getActive() + ""));
                }
                System.out.println("Getting Child added info:" + dataSnapshot.getValue());

            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
    }
}
