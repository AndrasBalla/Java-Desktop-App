package main.java.Objekt;

/**
 * Created by Spiks on 2016-04-08.
 */
//TODO:Comments and just everything else :D
public class Ticket {
    private String id;
    private String passengerName;
    private String cost;
    private String lineId;
    private Stop destination;
    private Stop source;
    private String purchaseDate;
    private String fareDate;

    public Ticket(){}

    public String getFareDate() {
        return fareDate;
    }

    public void setFareDate(String fareDate) {
        this.fareDate = fareDate;
    }

    public String getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(String purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public String getLineId() {
        return lineId;
    }

    public void setLineId(String lineId) {
        this.lineId = lineId;
    }

    public String getCost() {

        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public String getPassengerName() {

        return passengerName;
    }

    public void setPassengerName(String passengerName) {
        this.passengerName = passengerName;
    }

    public String getId() {

        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Stop getDestination() {
        return destination;
    }

    public void setDestination(Stop destination) {
        this.destination = destination;
    }

    public Stop getSource() {
        return source;
    }

    public void setSource(Stop source) {
        this.source = source;
    }
}
