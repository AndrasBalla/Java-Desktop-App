package main.java.Buss_lines;

import com.firebase.client.ChildEventListener;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import javafx.collections.ObservableList;
import main.java.Objekt.Ticket;
import main.java.Objekt.javaFxObjects.TicketTable;

/**
 * Created by Spiks on 2016-04-30.
 * In the project Buss_System
 */
public class TicketDatabase {
    private Firebase refTicket = new Firebase("https://buss-database.firebaseIO.com//live//tickets");

    public void saveTicket(Ticket ticket){
        Firebase newTicket = refTicket.child(ticket.getId());
        newTicket.child("id").setValue(ticket.getId());
        newTicket.child("passengerName").setValue(ticket.getPassengerName());
        newTicket.child("cost").setValue(ticket.getCost());
        newTicket.child("lineId").setValue(ticket.getLineId());
        newTicket.child("purchaseDate").setValue(ticket.getPurchaseDate());
        newTicket.child("fareDate").setValue(ticket.getFareDate());
        newTicket.child("source").setValue(ticket.getSource());
        newTicket.child("destination").setValue(ticket.getDestination());
    }

    public void updateTicket(ObservableList<TicketTable> data){

        refTicket.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                Ticket ticket = dataSnapshot.getValue(Ticket.class);
                TicketTable table = new TicketTable(ticket.getId(),ticket.getPassengerName(),ticket.getCost(),ticket.getLineId(),ticket.getPurchaseDate(),ticket.getFareDate(),
                        ticket.getSource(),ticket.getDestination());
                data.add(table);
                System.out.print(dataSnapshot);
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });

    }
}
