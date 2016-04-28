package main.java.Objekt.javaFxObjects;

import javafx.beans.property.SimpleStringProperty;

/**
 * Created by Spiks on 2016-04-28.
 */
public class DriverTable {
    private SimpleStringProperty driverId;
    private SimpleStringProperty name;
    private SimpleStringProperty id;

    public DriverTable(String driverId, String id, String name){
        this.driverId = new SimpleStringProperty(driverId);
        this.name = new SimpleStringProperty(name);
        this.id = new SimpleStringProperty(id);

    }

    public String getDriverId() {
        return driverId.get();
    }

    public SimpleStringProperty driverIdProperty() {
        return driverId;
    }

    public void setDriverId(String driverId) {
        this.driverId.set(driverId);
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

    public String getId() {
        return id.get();
    }

    public SimpleStringProperty idProperty() {
        return id;
    }

    public void setId(String id) {
        this.id.set(id);
    }
}
