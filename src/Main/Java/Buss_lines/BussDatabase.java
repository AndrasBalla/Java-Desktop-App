package main.java.Buss_lines;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;
import main.java.Objekt.*;

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
        Firebase newBuss = refBuss.child(buss.getRegId());
        newBuss.child("active").setValue(buss.getActive());
        newBuss.child("id").setValue(buss.getId());
        newBuss.child("regId").setValue(buss.getRegId());
    }

    /**
     * Gets all the busses from firebase and stores them in a array.
     * @return ArrayList<Buss>.
     */
    public ArrayList<Buss> getBuss(){
        refBuss.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                for (DataSnapshot postSnapshot: snapshot.getChildren()) {
                    Buss buss = postSnapshot.getValue(Buss.class);
                    bussList.add(buss);
                }
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {
                System.out.println("The read failed: " + firebaseError.getMessage());
            }
        });
        try {
            Thread.sleep(250);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
        return bussList;
    }

    /**
     * Removes a buss from firebase.
     * @param regId
     */
    public void deleteBuss(String regId){
        Firebase remove = new Firebase("https://buss-database.firebaseIO.com//live//garage//" + regId);
        remove.setValue(null);
    }
}
