package main.java.Objekt;

import java.util.ArrayList;

/**
 * Created by Spiks on 2016-04-08.
 * In the project Buss_System
 */

/**
 * A Object that represents the line a buss will take.
 * The Line id is a two digit number.
 * More information about the stops and buss can be found in theyre files.
 */
public class Line {
    private String id;
    private ArrayList<Stop> stops = new ArrayList<>();
    private Buss buss = new Buss();
    private Stop source = new Stop();
    private Stop dest = new Stop();

    public Line (String id, Buss buss){
        this.id = id;
        this.buss = buss;
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

    public void removeStop(String stopId){
        for (int i = 0; i < stops.size(); i++){
            if (stops.get(i).getId().equals(stopId)){
                stops.remove(i);
            }
        }
    }

    public void updateStop(String id, String name, String loc){
        stops.stream().forEach(stop1 -> {
            if (stop1.getId().equals(id)){
                stop1.setName(name);
                stop1.setLocation(loc);
            }
        });
    }

    public String toString(){
        for (int i = 0; i < stops.size(); i++){
            System.out.println("Buss Stop: " + stops.get(i).toString());
        }
        return "I got this";
    }
}
