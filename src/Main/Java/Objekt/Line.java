package main.java.Objekt;

import java.util.ArrayList;

/**
 * Created by Spiks on 2016-04-08.
 */

/**
 * A Object that represents the line a buss will take.
 */
public class Line {
    private String id;
    private ArrayList<Stop> stops;
    private Buss buss;

    public Line (){
        stops = new ArrayList<Stop>();
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
        return "You got it";
    }
}
