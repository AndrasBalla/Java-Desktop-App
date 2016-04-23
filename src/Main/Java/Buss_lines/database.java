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
 * Database Object that will hold all the methods used in communicating with Firebase.
 */
public class Database {
    private Firebase refDriver = new Firebase("https://buss-database.firebaseIO.com//live//people//drivers");
    private Firebase refBuss = new Firebase("https://buss-database.firebaseIO.com//live//garage");
    //private Buses list = new Buses();
    private ArrayList<Buss> list = new ArrayList<>();

    /**
     * Uploads the provided Driver to the database.
     * @param driver
     */
    public void saveDriver(Driver driver){
        Firebase driverRef = refDriver.child(driver.getName());
        driverRef.child("driverId").setValue(driver.getDriverId());
        driverRef.child("name").setValue(driver.getName());
        driverRef.child("id").setValue(driver.getId());
        System.out.println(driver.toString());
    }

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
                    list.add(buss);
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
        return list;
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
