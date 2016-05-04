package main.java.Objekt;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by Spiks on 2016-04-08.
 * In the project Buss_System
 */

/**
 * A Buss Object that has a id, list of passengers, driver, size and a boolean value that shows if it is currently in use.
 * The Buss id needs to be a three digit number.
 * The active value can only be true or false and stands shows if a buss is currently connected to a line or not.
 * The Registration number is three letters followed by 3 digits as the swedish standard.
 */
@JsonIgnoreProperties(ignoreUnknown=true)
public class Buss {
    private String id;
    private String active;
    private String regId;
    private final int size = 17;

    public Buss(String id, String regId, String active){
        this.id=id;
        this.regId = regId;
        this.active = active;
    }

    public Buss(){}

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRegId() {
        return regId;
    }

    public void setRegId(String regId) {
        this.regId = regId;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }


    public String toString(){
        return "Buss Registration Number: " + regId + " The Buss is currently active: " +active+
                " The id of this buss is: " + id;
    }
}
