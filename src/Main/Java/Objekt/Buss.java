package main.java.Objekt;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.ArrayList;

/**
 * Created by Spiks on 2016-04-08.
 */

/**
 * A Buss Object that has a id, list of passengers, driver, size and a boolean value that shows if it is currently in use.
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
        if (checkId(regId)){
            this.regId = regId;
        }
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

    /**
     * Private method that checks if the Buss Id is valid.
     * A valid Buss Id is a String with 3 letters and 3 digits like XXX000
     * @param inId The input string to be checked.
     */
    private boolean checkId(String inId){
        if(inId.length() != 6){
            System.out.println("The Buss registration is invalid");
            return false;
        }else{
            String letters = inId.substring(0,3);
            String numbers = inId.substring(3,6);

            if(!(Character.isLetter(letters.charAt(0))&& Character.isLetter(letters.charAt(1)) && Character.isLetter(letters.charAt(2)))){
                System.out.println("The Buss registration is invalid");
                return false;
                //TODO: Fix this.
            }else if(!(Character.isDigit(numbers.charAt(0)) && Character.isDigit(numbers.charAt(1)) && Character.isDigit(numbers.charAt(2)))){
                System.out.println("The Buss registration is invalid");
                return false;
            }else {
                return true;
            }
        }
    }
}
