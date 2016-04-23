package main.java.Buss_lines;

import com.firebase.client.Firebase;
import main.java.Objekt.*;

/**
 * Created by Spiks on 2016-04-16.
 */

/**
 * Database Object that will hold all the methods used in communicating with Firebase.
 */
public class Database {
    Firebase ref = new Firebase("https://buss-database.firebaseIO.com//Drivers");

    /**
     * Uploads the provided Driver to the database.
     * @param driver
     */
    public void saveDriver(Driver driver){
        Firebase driverRef = ref.child(driver.getName());
        driverRef.child("driverId").setValue(driver.getDriverId());
        driverRef.child("name").setValue(driver.getName());
        driverRef.child("id").setValue(driver.getId());
        System.out.println(driver.toString());
    }
}
