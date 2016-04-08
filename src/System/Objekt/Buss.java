package System.Objekt;

import java.util.ArrayList;

/**
 * Created by Spiks on 2016-04-08.
 */
public class Buss {
    private String id;
    private ArrayList<Person> passengers = new ArrayList<Person>();
    private String lineId;

    public Buss(String inId, Driver driver ){
        passengers.add(null);
        checkId(inId);
        passengers.set(0,driver);
    }

    public void setLineId(String inLineId){
        lineId = inLineId;
    }

    public String getLineId(){
        return lineId;
    }

    public void setPassengers(Passenger inPerson){
        passengers.add(inPerson);
    }

    public ArrayList<Person> getPassengers(){
        return passengers;
    }

    public String toString(){
        return "Buss Regnr: " + id + " Driver: " + passengers.get(0);
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
                System.out.println("Letters: " + letters + " Numbers: " + numbers);
            }
        }


    }
}
