package main.java.Buss_lines;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;
import main.java.Objekt.Driver;

import java.util.ArrayList;

/**
 * Created by Spiks on 2016-04-28.
 */
public class DriverDatabase {
    private Firebase refDriver = new Firebase("https://buss-database.firebaseIO.com//live//people//drivers");
    private ArrayList<Driver> driverList = new ArrayList<>();

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
     * Gets all drivers from the database and stores them in a ArrayList
     * @return ArrayList<Driver>
     */
    public ArrayList<Driver> getDriverList(){
        refDriver.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot postSnapshot: dataSnapshot.getChildren()) {
                    Driver driver = postSnapshot.getValue(Driver.class);
                    driverList.add(driver);
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
        return driverList;
    }

    /**
     * Removes a driver from the database.
     * @param name
     */
    public void deleteDriver(String name){
        Firebase remove = new Firebase("https://buss-database.firebaseIO.com//live//people//drivers//" + name);
        remove.setValue(null);
    }
}
