package main.java.Objekt;

/**
 * Created by Spiks on 2016-04-08.
 * In the project Buss_System
 */

/**
 * Driver Object that inherits from Person.
 * String driverId is a unique string of 5 digits.
 * String id is the drivers personal id provided by the Swedish state (Person number)
 * String name is the Drivers name First name + Last name.
 */
public class Driver extends Person{
    private String driverId;
    private String id;
    private String name;

    public Driver(String driverId, String id, String name){
        this.driverId = driverId;
        this.id = id;
        this.name = name;
    }

    public Driver(){}

    public String getDriverId() {
        return driverId;
    }

    public void setDriverId(String driverId) {this.driverId = driverId;}

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    public String toString(){
        return "Name: " + name + " Id: " + id + " Driver Id: " + driverId;
    }
}
