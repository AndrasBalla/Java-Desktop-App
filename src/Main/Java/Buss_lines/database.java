package Main.java.Buss_lines;

import com.firebase.client.Firebase;
import Main.java.Objekt.*;

/**
 * Created by Spiks on 2016-04-16.
 */
public class Database {
    Firebase ref = new Firebase("https://buss-database.firebaseIO.com//Drivers");

    public void saveDriver(Driver driver){
        Firebase driverRef = ref.child(driver.getName());
        driverRef.child("driverId").setValue(driver.getDriverId());
        driverRef.child("name").setValue(driver.getName());
        driverRef.child("id").setValue(driver.getId());
        System.out.println(driver.toString());
    }
}
