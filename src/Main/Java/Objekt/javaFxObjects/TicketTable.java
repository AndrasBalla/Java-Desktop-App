package main.java.Objekt.javaFxObjects;

import javafx.beans.property.SimpleStringProperty;
import main.java.Objekt.Stop;


/**
 * Created by Spiks on 2016-05-03.
 * In the project Buss_System
 */
public class TicketTable {
    private SimpleStringProperty id;
    private SimpleStringProperty passengerName;
    private SimpleStringProperty cost;
    private SimpleStringProperty lineId;
    private SimpleStringProperty purchaseDate;
    private SimpleStringProperty fareDate;
    private SimpleStringProperty sourceId;
    private SimpleStringProperty sourceName;
    private SimpleStringProperty sourceLoc;
    private SimpleStringProperty destId;
    private SimpleStringProperty destName;
    private SimpleStringProperty destLoc;

    public TicketTable(String id, String passengerName, String cost, String lineId, String purchaseDate, String fareDate, Stop source, Stop dest){
        this.id = new SimpleStringProperty(id);
        this.passengerName = new SimpleStringProperty(passengerName);
        this.cost = new SimpleStringProperty(cost);
        this.lineId = new SimpleStringProperty(lineId);
        this.purchaseDate = new SimpleStringProperty(purchaseDate);
        this.fareDate = new SimpleStringProperty(fareDate);
        this.sourceId = new SimpleStringProperty(source.getId());
        this.sourceName = new SimpleStringProperty(source.getName());
        this.sourceLoc = new SimpleStringProperty(source.getLocation());
        this.destId = new SimpleStringProperty(dest.getId());
        this.destName = new SimpleStringProperty(dest.getName());
        this.destLoc = new SimpleStringProperty(dest.getLocation());
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

    public String getPassengerName() {
        return passengerName.get();
    }

    public SimpleStringProperty passengerNameProperty() {
        return passengerName;
    }

    public void setPassengerName(String passengerName) {
        this.passengerName.set(passengerName);
    }

    public String getCost() {
        return cost.get();
    }

    public SimpleStringProperty costProperty() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost.set(cost);
    }

    public String getLineId() {
        return lineId.get();
    }

    public SimpleStringProperty lineIdProperty() {
        return lineId;
    }

    public void setLineId(String lineId) {
        this.lineId.set(lineId);
    }

    public String getPurchaseDate() {
        return purchaseDate.get();
    }

    public SimpleStringProperty purchaseDateProperty() {
        return purchaseDate;
    }

    public void setPurchaseDate(String purchaseDate) {
        this.purchaseDate.set(purchaseDate);
    }

    public String getFareDate() {
        return fareDate.get();
    }

    public SimpleStringProperty fareDateProperty() {
        return fareDate;
    }

    public void setFareDate(String fareDate) {
        this.fareDate.set(fareDate);
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

    public String getSourceName() {
        return sourceName.get();
    }

    public SimpleStringProperty sourceNameProperty() {
        return sourceName;
    }

    public void setSourceName(String sourceName) {
        this.sourceName.set(sourceName);
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

    public String getDestId() {
        return destId.get();
    }

    public SimpleStringProperty destIdProperty() {
        return destId;
    }

    public void setDestId(String destId) {
        this.destId.set(destId);
    }

    public String getDestName() {
        return destName.get();
    }

    public SimpleStringProperty destNameProperty() {
        return destName;
    }

    public void setDestName(String destName) {
        this.destName.set(destName);
    }

    public String getDestLoc() {
        return destLoc.get();
    }

    public SimpleStringProperty destLocProperty() {
        return destLoc;
    }

    public void setDestLoc(String destLoc) {
        this.destLoc.set(destLoc);
    }
}
