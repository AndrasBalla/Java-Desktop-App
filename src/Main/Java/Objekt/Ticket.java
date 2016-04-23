package main.java.Objekt;

/**
 * Created by Spiks on 2016-04-08.
 */
//TODO:Comments and just everything else :D
public class Ticket {
    private String id;
    private String passengerName;
    private String cost;
    private Line line;
    private Stop destination;
    private Stop source;
    private String purchaseDate;

    public String getFareDate() {
        return FareDate;
    }

    public void setFareDate(String fareDate) {
        FareDate = fareDate;
    }

    public String getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(String purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    private String FareDate;

    public Line getLine() {
        return line;
    }

    public void setLine(Line line) {
        this.line = line;
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
}
