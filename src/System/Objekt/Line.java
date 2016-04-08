package System.Objekt;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;

/**
 * Created by Spiks on 2016-04-08.
 */
@XmlRootElement
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

    @XmlElement(name = "book")
    public void setStops(Stop stop){
        stops.add(stop);
    }

    public ArrayList<Stop> getStops(){
        return stops;
    }
}
