package main.java.Objekt;

/**
 * Created by Spiks on 2016-04-08.
 */

/**
 * Object representing a Buss stop.
 */
public class Stop {
    private String id;
    private String name;
    private String location;

    public Stop(String inId, String inName, String inLocation){
        id = inId;
        name = inName;
        location = inLocation;
    }

    public Stop(){}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String toString(){
        return "Id: " + id + " Name: " + name + " Location: " + location;
    }
}
