package Main.java.Objekt;

import java.util.Calendar;

/**
 * Created by Spiks on 2016-04-08.
 */
public class Person {
    protected String id;
    protected String name;
    protected String age;

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getId(){
        return id;
    }

    public void setId(String inId) throws CheckIdException{
        checkId(inId);
        id = inId;
    }

    public void setName(String inName){
        name = inName;
    }

    public String getName(){
        return name;
    }

    private void checkId(String inId) throws CheckIdException{
        Calendar c = Calendar.getInstance();
        int currentYear = c.get(Calendar.YEAR);
        String controlTwo = "";
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
            throw new CheckIdException("Ogiltig Personnummer");
        }else if(inId.length() == 11){
            int year = Integer.parseInt(inId.substring(0,2));
            int month = Integer.parseInt(inId.substring(2,4));
            int day = Integer.parseInt(inId.substring(4,6));
            System.out.println("Year: " + year + " month: " + month + " day: " + day + " Current year: " + currentYear);
            if(inId.charAt(6) == '-'){
                if (year >= currentYear - 2000 && year <= 99 && month > 0 && month <= 12 && day > 0 && day <= 30){
                    id = inId;
                }else {
                    throw new CheckIdException("Ogiltig Personnummer");
                }
            }else if (inId.charAt(6) == '+'){
                if(year <= currentYear - 2000 && year >= 0 && month > 0 && month <= 12 && day > 0 && day <= 30){
                    System.out.println("100+");
                    id = inId;
                }else {
                    throw new CheckIdException("Ogiltig Personnummer");
                }
            }
        }else {
            throw new CheckIdException("Ogiltig Personnummer");
        }
    }

    public class CheckIdException extends Exception{
        public CheckIdException(String message){
            super(message);
        }
    }
}
