package main.java.Objekt;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;

/**
 * Created by Spiks on 2016-04-08.
 */
@XmlRootElement(name = "line")
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

    @XmlAttribute
    public void setId(String inId){
        id = inId;
    }

    public String getId(){
        return id;
    }

    public void addStops(Stop stop){
        stops.add(stop);
    }

    @XmlElement(name = "stop")
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
