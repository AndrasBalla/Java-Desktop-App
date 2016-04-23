package main.java.Objekt;

import java.util.ArrayList;

/**
 * Created by Spiks on 2016-04-09.
 */

/**
 * Object Buses holds a list of the buses owned by the company using the system.
 */
public class Buses {
    private ArrayList<Buss> buses = new ArrayList<>();

    public ArrayList<Buss> getBuses() {
        return buses;
    }

    public void setBuses(ArrayList<Buss> buses) {
        this.buses = buses;
    }

    public void addBuses(Buss buss){
        buses.add(buss);
    }

    /**
     * Looks for a buss that is not in use.
     * @return The first inactive buss or null.
     */
    public Buss getInactive(){
        for (Buss buss: buses) {
            if (!(buss.isActive())) {
                return buss;
            }
        }
        return null;
    }

    public String toString(){
        String out = "";
        for(Buss buss: buses){
            out += buss.toString() + "\n";
        }
        return out;
    }
}

