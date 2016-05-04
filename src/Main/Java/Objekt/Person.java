package main.java.Objekt;

import java.util.Calendar;

/**
 * Created by Spiks on 2016-04-08.
 * In the project Buss_System
 */

/**
 * Object Person not used actively by the system it is only used by Driver and Passenger as a super class.
 */
public class Person {
    protected String id;
    protected String name;

    public String getId(){
        return id;
    }

    public void setId(String inId) {
        id = inId;
    }

    public void setName(String inName){
        name = inName;
    }

    public String getName(){
        return name;
    }

    /**
     * Takes a String and checks if it is a valid personal Id given by the Swedish government.
     * @param inId The persons personal Id.
     */
    public boolean checkId(String inId) {
        Calendar c = Calendar.getInstance();
        int currentYear = c.get(Calendar.YEAR);
        String controlTwo;
        int control = 0;
        int times = 2;

        for(int i = 0; i < inId.length() - 1; i++){
            if(i != 6){
                controlTwo = "" + Integer.parseInt(inId.substring(i,i+1)) * times;
                if(times == 1){
                    times = 2;
                }else{
                    times = 1;
                }
                for(int j = 0; j < controlTwo.length(); j++){
                    control += Integer.parseInt(controlTwo.substring(j,j+1));
                }
            }
        }

        if((10 - (control % 10) != Integer.parseInt(inId.substring(10)))){
            return false;
        }else if(inId.length() == 11){
            int year = Integer.parseInt(inId.substring(0,2));
            int month = Integer.parseInt(inId.substring(2,4));
            int day = Integer.parseInt(inId.substring(4,6));
            if(inId.charAt(6) == '-'){
                return year >= currentYear - 2000 && year <= 99 && month > 0 && month <= 12 && day > 0 && day <= 30;
            }else if (inId.charAt(6) == '+'){
                return year <= currentYear - 2000 && year >= 0 && month > 0 && month <= 12 && day > 0 && day <= 30;
            }
        }else {
            return false;
        }
        return false;
    }
}
