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
 * TicketDatabase class that will hold all the methods used in communicating with Firebase.
 */
public class TicketDatabase {
    private Firebase refTicket = new Firebase("https://buss-database.firebaseIO.com//live//tickets");

    /**
     * Uploads a ticket to firebase.
     * @param ticket Ticket to be saved.
     */
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

    public void removeTicket(String id){
        Firebase removeTicket = new Firebase("https://buss-database.firebaseIO.com//live//tickets//" + id);
        removeTicket.setValue(null);
    }

    /**
     * Gets all the tickets from the database and adds them to the table.
     * @param data The ObservableList that used to populate the TableView.
     */
    public void updateTicket(ObservableList<TicketTable> data){

        refTicket.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                Ticket ticket = dataSnapshot.getValue(Ticket.class);
                TicketTable table = new TicketTable(ticket.getId(),ticket.getPassengerName(),ticket.getCost(),ticket.getLineId(),ticket.getPurchaseDate(),ticket.getFareDate(),
                        ticket.getSource(),ticket.getDestination());
                data.add(table);
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {}

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {
                for (int i = 0; i < data.size(); i++) {
                    if (data.get(i).getId().equals(dataSnapshot.getKey())) {
                        data.remove(i);
                    }
                }
            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {}

            @Override
            public void onCancelled(FirebaseError firebaseError) {}
        });

    }

    public void ticketId (Ticket ticket){
        refTicket.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                int foo = Integer.parseInt(dataSnapshot.getKey()) + 1;
                String id;
                if (foo < 10){
                    id = "000" + foo;
                }else if(foo < 100){
                    id = "00" + foo;
                }else if (foo < 1000){
                    id = "0" + foo;
                }else {
                    id = "" + foo;
                }

                ticket.setId(id);
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {}

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {}

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {}

            @Override
            public void onCancelled(FirebaseError firebaseError) {}
        });
    }
}
