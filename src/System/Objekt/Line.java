package System.Objekt;

import java.util.ArrayList;

/**
 * Created by Spiks on 2016-04-08.
 */
public class Line {
    private String id;
    private ArrayList<Stop> stops;

    public Line (){
        stops = new ArrayList<Stop>();
    }

    public void setId(String inId){
        id = inId;
    }

    public String getId(){
        return id;
    }

    public void setStops(Stop stop){
        stops.add(stop);
    }

    public ArrayList<Stop> getStops(){
        return stops;
    }
}
