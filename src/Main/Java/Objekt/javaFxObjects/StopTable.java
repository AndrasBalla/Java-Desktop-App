package main.java.Objekt.javaFxObjects;

import javafx.beans.property.SimpleStringProperty;

/**
 * Created by Spiks on 2016-05-03.
 * In the project Buss_System
 * This Object is only used in the java fx Table.
 */
public class StopTable {
    private SimpleStringProperty id;
    private SimpleStringProperty name;
    private SimpleStringProperty location;

    public StopTable(String id, String name, String location){
        this.id = new SimpleStringProperty(id);
        this.name = new SimpleStringProperty(name);
        this.location = new SimpleStringProperty(location);
    }

    public String getId() {
        return id.get();
    }

    public SimpleStringProperty idProperty() {
        return id;
    }

    public void setId(String id) {
        this.id.set(id);
    }

    public String getName() {
        return name.get();
    }

    public SimpleStringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public String getLocation() {
        return location.get();
    }

    public SimpleStringProperty locationProperty() {
        return location;
    }

    public void setLocation(String location) {
        this.location.set(location);
    }

    public boolean equals(StopTable in){
        if (this.id.equals(in.getId())){
            return true;
        }
        return false;
    }
}
