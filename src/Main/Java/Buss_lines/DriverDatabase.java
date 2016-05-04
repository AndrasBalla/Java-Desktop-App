package main.java.Buss_lines;

import com.firebase.client.*;
import javafx.collections.ObservableList;
import main.java.Objekt.Driver;
import main.java.Objekt.javaFxObjects.DriverTable;

/**
 * Created by Spiks on 2016-04-28.
 * In the project Buss_System
 */
public class DriverDatabase {
    private Firebase refDriver = new Firebase("https://buss-database.firebaseIO.com//live//people//drivers");

    /**
     * Uploads the provided Driver to the database.
     * @param driver The Driver Object to be saved in the database.
     */
    public void saveDriver(Driver driver){
        Firebase driverRef = refDriver.child(driver.getName());
        driverRef.child("driverId").setValue(driver.getDriverId());
        driverRef.child("name").setValue(driver.getName());
        driverRef.child("id").setValue(driver.getId());
    }

    /**
     * Removes a driver from the database.
     * @param name The name value of the driver to be removed.
     */
    public void deleteDriver(String name){
        Firebase remove = new Firebase("https://buss-database.firebaseIO.com//live//people//drivers//" + name);
        remove.setValue(null);
    }

    /**
     * Gets all the drivers from the database and adds them to the table.
     * @param data The ObservableList that used to populate the TableView.
     */
    public void updateDriver(ObservableList<DriverTable> data){

        refDriver.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                Driver driver = dataSnapshot.getValue(Driver.class);
                data.add(new DriverTable(driver.getDriverId(),driver.getId(),dataSnapshot.getKey()));
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {
                Driver basicDriver = dataSnapshot.getValue(Driver.class);
                basicDriver.setName(dataSnapshot.getKey());
                data.stream().forEach(driver -> {
                    if (driver.getName().equals(dataSnapshot.getKey())){
                        driver.setId(basicDriver.getId());
                        driver.setName(dataSnapshot.getKey());
                        driver.setDriverId(basicDriver.getDriverId());
                    }
                });
            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {
                for (int i = 0; i < data.size(); i++) {
                    if (data.get(i).getName().equals(dataSnapshot.getKey())) {
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
}
