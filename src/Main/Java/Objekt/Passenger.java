package main.java.Objekt;

/**
 * Created by Spiks on 2016-04-08.
 * In the project Buss_System
 */

/**
 * Passenger Object inherits from Person.
 * Ticket ticket is the passengers personal ticket.
 */
public class Passenger extends Person{
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
