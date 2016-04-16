package Main.java.Objekt;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * Created by Spiks on 2016-04-08.
 */
@XmlRootElement(name = "Buss")
@XmlType(propOrder = {"id","name","driverId"})
public class Driver extends Person{
    private String driverId;
    private String id;
    private String name;

    public Driver(){}

    public String getDriverId() {
        return driverId;
    }

    public void setDriverId(String driverId) {
        this.driverId = driverId;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    @XmlElement
    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    @XmlElement
    public void setName(String name) {
        this.name = name;
    }

    public String toString(){
        return "Name: " + name + " Id: " + id + " Driver Id: " + driverId;
    }
}
