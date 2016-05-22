package main.java.Objekt.javaFxObjects;

import javafx.beans.property.SimpleStringProperty;

/**
 * Created by Spiks on 2016-05-22.
 * In the project Buss_System
 */
public class NoteTable {
    private SimpleStringProperty date;
    private SimpleStringProperty message;

    public NoteTable(String date, String message){
        this.date = new SimpleStringProperty(date);
        this.message = new SimpleStringProperty(message);
    }

    public String getDate() {
        return date.get();
    }

    public SimpleStringProperty dateProperty() {
        return date;
    }

    public void setDate(String date) {
        this.date.set(date);
    }

    public String getMessage() {
        return message.get();
    }

    public SimpleStringProperty messageProperty() {
        return message;
    }

    public void setMessage(String message) {
        this.message.set(message);
    }
}
