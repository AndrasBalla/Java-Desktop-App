package main.java.Buss_lines;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;
import main.java.Objekt.*;

/**
 * Created by Spiks on 2016-04-16.
 */

/**
 * Database Object that will hold all the methods used in communicating with Firebase.
 */
public class Database {
    private Firebase refDriver = new Firebase("https://buss-database.firebaseIO.com//live//people//drivers");
    private Firebase refBuss = new Firebase("https://buss-database.firebaseIO.com//live//garage");
    private Buses list = new Buses();

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

    public void saveBuss(Buss buss){
        Firebase newBuss = refBuss.child(buss.getId());
        newBuss.child("active").setValue(buss.isActive());
        newBuss.child("id").setValue(buss.getId());
    }

    public Buses getBuss(){
        refBuss.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                System.out.println("Loading in Buss items");
                for (DataSnapshot postSnapshot: snapshot.getChildren()) {
                    Buss buss = postSnapshot.getValue(Buss.class);
                    list.addBuses(buss);
                    System.out.println(buss.toString());
                    System.out.println(postSnapshot.getValue());
                }
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {
                System.out.println("The read failed: " + firebaseError.getMessage());
            }
        });

        return list;
    }
}
