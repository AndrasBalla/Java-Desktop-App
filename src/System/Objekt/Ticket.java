package System.Objekt;

/**
 * Created by Spiks on 2016-04-08.
 */
public class Ticket {
    private String id;
    private String passengerName;
    private String cost;
    private Line line;
    private String destination;
    private String source;

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
