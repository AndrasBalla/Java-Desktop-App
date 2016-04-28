package main.java;

import main.java.Buss_lines.*;
import main.java.Objekt.*;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

public class Main {

    public static void main(String[] args) {
        Window win = new Window();
        Person person = new Person();
        try{
            person.setId("811218-9876");
        }catch (Person.CheckIdException e){
            e.printStackTrace();
        }

        Passenger passenger = new Passenger();
        try{
            passenger.setId("811218-9876");
        }catch (Person.CheckIdException e){
            e.printStackTrace();
        }

        testBuss();
        testStop();
        testLine();
        testJson();
        //testFirebase();
        //populateList();
    }

    private static void testBuss(){
        System.out.print("\nTesting Buss: \n");
        Driver driver = new Driver();
        driver.setId("001");
        driver.setName("Henrik");
        System.out.println("Driver: " + driver.toString());
        Buss buss = new Buss("101","DXD868","false");
        System.out.println(buss.toString());
        Stop oneStop = new Stop("01","Ringen","Halmstad");
        Stop twoStop = new Stop("02","Central","Halmstad");
        Stop threeStop = new Stop("03","Tåg","Halmstad");
        Line line = new Line();
        line.addStops(oneStop);
        line.addStops(twoStop);
        line.addStops(threeStop);
        line.setId("10");
        line.setBuss(buss);
        line.toString();
        Passenger one = new Passenger();
        Passenger two = new Passenger();
        Passenger three = new Passenger();
        Passenger four = new Passenger();
        Passenger five = new Passenger();
        System.out.println(buss.toString());
    }

    private static void testStop(){
        Stop stop = new Stop("01","Sjukhuset","Halmstad");
        System.out.print("\nTesting Stop: \n");
        System.out.println(stop.toString());
        Stop one = new Stop();
        System.out.println(one.toString());
        one.setId("02");
        System.out.println(one.toString());
        one.setLocation("Halmstad");
        System.out.println(one.toString());
        one.setName("Bergen");
        System.out.println(one.toString());
    }

    private static void testLine(){
        System.out.print("\nTesting Line: \n");
        Stop oneStop = new Stop("01","Ringen","Halmstad");
        Stop two = new Stop("02","Central","Halmstad");
        Stop three = new Stop("03","Tåg","Halmstad");
        Line line = new Line();
        line.addStops(oneStop);
        line.addStops(two);
        line.addStops(three);
        line.toString();
    }

    private static void testJson(){
        Convert_toJson toJson = new Convert_toJson();
        toJson.toJson();
    }

    private static void testFirebase(){
        Firebase ref = new Firebase("https://buss-database.firebaseIO.com//Drivers");
        DriverDatabase database = new DriverDatabase();
        Driver driver = new Driver();
        driver.setDriverId("25429");
        driver.setName("Andras Ballas");
        driver.setId("910612-1511");
        database.saveDriver(driver);
        //ref.push().setValue(driver);
        /*ref.child(driver.getName()).setValue(driver, new Firebase.CompletionListener() {
            @Override
            public void onComplete(FirebaseError firebaseError, Firebase firebase) {
                System.out.println("Computing");
                if (firebaseError != null) {
                    System.out.println("Data could not be saved. " + firebaseError.getMessage());
                } else {
                    System.out.println("Data saved successfully.");
                }
            }
        });*/

        ref.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                System.out.println("Hi FireBase!");
                System.out.println("There are " + snapshot.getChildrenCount() + " blog posts");
                for (DataSnapshot postSnapshot: snapshot.getChildren()) {
                    Driver post = postSnapshot.getValue(Driver.class);
                    System.out.println(post.toString());
                }
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {
                System.out.println("The read failed: " + firebaseError.getMessage());
            }
        });
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e){
            e.printStackTrace();
        }


    }

    private static class MyObject {

        private String property1;
        private int property2;

        public MyObject(String value1, int value2) {
            this.property1 = value1;
            this.property2 = value2;
        }

        public String getFirstProperty() {
            return property1;
        }

        public int getProperty2(){
            return property2;
        }

    }

    private static void populateList() {
        Firebase ref = new Firebase("https://burning-heat-6434.firebaseIO.com//myObjects");
        ref.push().setValue(new MyObject("myString", 14));
    }
}
