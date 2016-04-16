package Main.java.Objekt;

/**
 * Created by Spiks on 2016-04-08.
 */
public class Passenger extends Person{
    private String name;
    private Ticket ticket;

    public Passenger(){

    }

    public void setTicket(Ticket inTicket){
        ticket = inTicket;
    }

    public Ticket getTicket(){
        return ticket;
    }

    public String toString(){
        return "Name: " + name;
    }
}
