package System.Objekt;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * Created by Spiks on 2016-04-08.
 */
@XmlRootElement(name = "stop")
@XmlType(propOrder = {"location","name"})
public class Stop {
    private String id;
    private String name;
    private String location;

    public Stop(String inId, String inName, String inLocation){
        id = inId;
        name = inName;
        location = inLocation;
    }

    public Stop(){}

    @XmlAttribute
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String toString(){
        return "Id: " + id + " Name: " + name + " Location: " + location;
    }
}
