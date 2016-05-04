package main.java.Objekt.javaFxObjects;

import javafx.beans.property.SimpleStringProperty;

/**
 * Created by Spiks on 2016-04-23.
 * In the project Buss_System
 */

/**
 * Object used only for building the Table on the Garage screen.
 */
public class BussTable {
    private SimpleStringProperty id;
    private SimpleStringProperty regId;
    private SimpleStringProperty active;

    public BussTable(String id, String regId, String active){
        this.regId = new SimpleStringProperty(regId);
        this.id = new SimpleStringProperty(id);
        this.active = new SimpleStringProperty(active);
    }

    public String getActive() {return active.get();}

    public SimpleStringProperty activeProperty() {return active;}

    public void setActive(String active) {this.active.set(active);}

    public String getRegId() {return regId.get();}

    public SimpleStringProperty regIdProperty() {return regId;}

    public void setRegId(String regId) {this.regId.set(regId);}

    public String getId() {return id.get();}

    public SimpleStringProperty idProperty() {return id;}

    public void setId(String id) {this.id.set(id);}

    public boolean equals(BussTable buss){
        return this.id.toString().equals(buss.getId()) || this.regId.toString().equals(buss.getRegId());
    }
}
