package System.Objekt;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;

/**
 * Created by Spiks on 2016-04-09.
 */
@XmlRootElement(name = "Garage")
public class Buses {
    private ArrayList<Buss> buses = new ArrayList<>();

    public ArrayList<Buss> getBuses() {
        return buses;
    }

    @XmlElement(name = "Buss")
    public void setBuses(ArrayList<Buss> buses) {
        this.buses = buses;
    }

    public void addBuses(Buss buss){
        buses.add(buss);
    }

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
        for(int i = 0; i < buses.size(); i++){
            out += buses.get(i).toString();
        }
        return out;
    }
}

