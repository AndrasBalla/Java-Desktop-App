package System.Objekt;

/**
 * Created by Spiks on 2016-04-08.
 */
public class Driver extends Person{
    private String DriverId;

    public String getDriverId() {
        return DriverId;
    }

    public void setDriverId(String driverId) {
        DriverId = driverId;
    }

    public String toString(){
        return "Name: " + name + " Id: " + id;
    }
}
