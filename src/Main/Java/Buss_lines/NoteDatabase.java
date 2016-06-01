package main.java.Buss_lines;

import com.firebase.client.ChildEventListener;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import javafx.collections.ObservableList;
import main.java.Objekt.Note;
import main.java.Objekt.javaFxObjects.NoteTable;

/**
 * Created by Spiks on 2016-05-22.
 * In the project Buss_System
 */
public class NoteDatabase {
    private Firebase ref = new Firebase("https://buss-database.firebaseIO.com//live//system");

    public void saveNote(String date, String message){
        Firebase newNote = ref.child(date);
        System.out.println(date);
        newNote.child("date").setValue(date);
        newNote.child("message").setValue(message);
    }

    public void removeNote(String date){
        Firebase remove = new Firebase("https://buss-database.firebaseIO.com//live//system//" + date);
        remove.setValue(null);
    }

    public void getPost(ObservableList<NoteTable> data){
        ref.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                if (!(dataSnapshot.getKey().equals("keep"))){
                    Note note = dataSnapshot.getValue(Note.class);
                    data.add(new NoteTable(dataSnapshot.getKey(),note.getMessage()));
                }
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {
                Note note = dataSnapshot.getValue(Note.class);
                data.stream().forEach(noteTable -> {
                    if (noteTable.getDate().equals(dataSnapshot.getKey())){
                        noteTable.setMessage(note.getMessage());
                    }
                });
            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {}

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {}

            @Override
            public void onCancelled(FirebaseError firebaseError) {}
        });
    }
}
