package main.java.Objekt.javaFxObjects;

import javafx.beans.property.SimpleStringProperty;
import main.java.Objekt.Stop;

/**
 * Created by Spiks on 2016-05-02.
 * In the project Buss_System
 * This Object is only used in the java fx Table.
 */
public class LineTable {
    private SimpleStringProperty id;
    private SimpleStringProperty destinationId;
    private SimpleStringProperty destinationLoc;
    private SimpleStringProperty destinationName;
    private SimpleStringProperty sourceId;
    private SimpleStringProperty sourceLoc;
    private SimpleStringProperty sourceName;
    private SimpleStringProperty bussId;
    private SimpleStringProperty regId;
    private SimpleStringProperty active;

    public LineTable(String id, Stop source, Stop destination, String bussId, String regId, String active) {
        this.id = new SimpleStringProperty(id);
        this.destinationId = new SimpleStringProperty(destination.getId());
        this.destinationLoc = new SimpleStringProperty(destination.getLocation());
        this.destinationName = new SimpleStringProperty(destination.getName());
        this.sourceId = new SimpleStringProperty(source.getId());
        this.sourceLoc = new SimpleStringProperty(source.getLocation());
        this.sourceName = new SimpleStringProperty(source.getName());
        this.regId = new SimpleStringProperty(regId);
        this.bussId = new SimpleStringProperty(bussId);
        this.active = new SimpleStringProperty(active);
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

    public String getDestinationId() {
        return destinationId.get();
    }

    public SimpleStringProperty destinationIdProperty() {
        return destinationId;
    }

    public void setDestinationId(String destinationId) {
        this.destinationId.set(destinationId);
    }

    public String getDestinationLoc() {
        return destinationLoc.get();
    }

    public SimpleStringProperty destinationLocProperty() {
        return destinationLoc;
    }

    public void setDestinationLoc(String destinationLoc) {
        this.destinationLoc.set(destinationLoc);
    }

    public String getDestinationName() {
        return destinationName.get();
    }

    public SimpleStringProperty destinationNameProperty() {
        return destinationName;
    }

    public void setDestinationName(String destinationName) {
        this.destinationName.set(destinationName);
    }

    public String getSourceId() {
        return sourceId.get();
    }

    public SimpleStringProperty sourceIdProperty() {
        return sourceId;
    }

    public void setSourceId(String sourceId) {
        this.sourceId.set(sourceId);
    }

    public String getSourceLoc() {
        return sourceLoc.get();
    }

    public SimpleStringProperty sourceLocProperty() {
        return sourceLoc;
    }

    public void setSourceLoc(String sourceLoc) {
        this.sourceLoc.set(sourceLoc);
    }

    public String getSourceName() {
        return sourceName.get();
    }

    public SimpleStringProperty sourceNameProperty() {
        return sourceName;
    }

    public void setSourceName(String sourceName) {
        this.sourceName.set(sourceName);
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

    public String getBussId() {
        return bussId.get();
    }

    public SimpleStringProperty bussIdProperty() {
        return bussId;
    }

    public void setBussId(String bussId) {
        this.bussId.set(bussId);
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
}
