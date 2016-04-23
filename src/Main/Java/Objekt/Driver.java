package main.java.Objekt;

/**
 * Created by Spiks on 2016-04-08.
 */

/**
 * Driver Object that inherits from Person.
 * String driverId is a unique string of 5 digits.
 * String id is the drivers personal id provided by the Swedish state (Person nummer)
 * String name is the Drivers name First name + Last name.
 */
public class Driver extends Person{
    private String driverId;
    private String id;
    private String name;

    public Driver(){}

    public String getDriverId() {
        return driverId;
    }

    public void setDriverId(String driverId) {
        this.driverId = checkDriverId(driverId);
    }

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

    /**
     * Checks the correctness of the driver id.
     * @param driverId A string of 5 digits.
     * @return The supplied driverId or null if it was invalid.
     */
    private String checkDriverId(String driverId){
        if (driverId.length() != 5){
            return null;
        }else{
            return driverId;
        }
    }
}
