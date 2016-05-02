package main.java.Objekt;

import java.util.ArrayList;

/**
 * Created by Spiks on 2016-04-08.
 * In the project Buss_System
 */

/**
 * A Object that represents the line a buss will take.
 */
public class Line {
    private String id;
    private ArrayList<Stop> stops = new ArrayList<>();
    private Buss buss;
    private Stop source;
    private Stop dest;

    public Line (String id, Buss buss, Stop source, Stop dest){
        this.id = id;
        this.buss = buss;
        this.source = source;
        this.dest = dest;
    }

    public Line (){}

    public Stop getSource() {
        return source;
    }

    public void setSource(Stop source) {
        this.source = source;
    }

    public Stop getDest() {
        return dest;
    }

    public void setDest(Stop dest) {
        this.dest = dest;
    }

    public Buss getBuss() {
        return buss;
    }

    public void setBuss(Buss buss) {
        this.buss = buss;
    }

    public void setId(String inId){
        id = inId;
    }

    public String getId(){
        return id;
    }

    public void addStops(Stop stop){
        stops.add(stop);
    }

    public void setStops(ArrayList<Stop> Stops){
        this.stops = Stops;
    }

    public ArrayList<Stop> getStops(){
        return stops;
    }

    public String toString(){
        for (int i = 0; i < stops.size(); i++){
            System.out.println("Buss Stop: " + stops.get(i).toString());
        }
        return "I got this";
    }
}
