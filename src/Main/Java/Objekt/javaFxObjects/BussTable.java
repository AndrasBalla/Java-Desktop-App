package main.java.Objekt.javaFxObjects;

import javafx.beans.property.SimpleStringProperty;

/**
 * Created by Spiks on 2016-04-23.
 */

/**
 * Object used only for building the Table on the Garage screen.
 */
public class BussTable {
    private SimpleStringProperty id = null;
    private SimpleStringProperty regId = null;
    private SimpleStringProperty active = null;

    public BussTable(String id, String regId, String active){
        this.regId = new SimpleStringProperty(regId);
        this.id = new SimpleStringProperty(id);
        this.active = new SimpleStringProperty(active);
    }

    public BussTable(){

    }

    public String getActive() {
        return active.get();
    }

    public SimpleStringProperty activeProperty() {
        return active;
    }

    public void setActive(String active) {
        this.active.set(active);
    }

    public String getRegId() {

        return regId.get();
    }

    public SimpleStringProperty regIdProperty() {
        return regId;
    }

    public void setRegId(String regId) {
        this.regId.set(regId);
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
