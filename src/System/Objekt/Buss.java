package System.Objekt;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlTransient;
import java.util.ArrayList;

/**
 * Created by Spiks on 2016-04-08.
 */
@XmlRootElement(name = "Buss")
@XmlType(propOrder = {"id","active","driver"})
public class Buss {
    private String id;
    private ArrayList<Person> passengers = new ArrayList<Person>();
    private boolean active;
    private Driver driver;
    private final int size = 17;

    public Buss(String inId, Driver driver ){
        active = false;
        passengers.add(null);

        checkId(inId);
        passengers.set(0,driver);
    }

    public Buss(){

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        checkId(id);
    }

    @XmlTransient
    public void setPassengers(ArrayList<Person> passengers) {
        this.passengers = passengers;
    }

    public void addPassengers(Passenger inPerson){
        passengers.add(inPerson);
    }

    public ArrayList<Person> getPassengers(){
        return passengers;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public void setDriver(Driver inDriver){
        driver = inDriver;
        passengers.add(driver);
    }

    public Driver getDriver(){
        return driver;
    }

    public String toString(){
        String output = "Buss Registration Number: " + id + " Driver: " + passengers.get(0) + " Passengers: ";
        for (int i = 1; i < passengers.size(); i++){
            output += passengers.get(i).toString();
        }
        return output;
    }

    private void checkId(String inId){
        if(inId.length() != 6){
            System.out.println("The Buss registration is invalid");
        }else{
            String letters = inId.substring(0,3);
            String numbers = inId.substring(3,6);

            if(!(Character.isLetter(letters.charAt(0))&& Character.isLetter(letters.charAt(1)) && Character.isLetter(letters.charAt(2)))){
                System.out.println("The Buss registration is invalid");
            }else if(!(Character.isDigit(numbers.charAt(0)) && Character.isDigit(numbers.charAt(1)) && Character.isDigit(numbers.charAt(2)))){
                System.out.println("The Buss registration is invalid");
            }else {
                id = inId;
            }
        }


    }
}
