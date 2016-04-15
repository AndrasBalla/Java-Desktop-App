package System;

import System.Database.Buss_lines.Convert_toJson;
import System.Database.Buss_lines.Xml_Line;
import System.Objekt.*;

public class Main {

    public static void main(String[] args) {
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
        testXmlLine();
        testXmlBuses();
        testJson();
    }

    private static void testBuss(){
        System.out.print("\nTesting Buss: \n");
        Driver driver = new Driver();
        driver.setId("001");
        driver.setName("Henrik");
        System.out.println("Driver: " + driver.toString());
        Buss buss = new Buss("DXD868",driver);
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
        buss.addPassengers(one);
        buss.addPassengers(two);
        buss.addPassengers(three);
        buss.addPassengers(four);
        buss.addPassengers(five);
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

    private static void testXmlLine(){
        System.out.print("\nTesting Xml Line: \n");
        Stop oneStop = new Stop("01","Ringen","Halmstad");
        Stop two = new Stop("02","Central","Halmstad");
        Stop three = new Stop("03","Tåg","Halmstad");
        Line line = new Line();
        line.addStops(oneStop);
        line.addStops(two);
        line.addStops(three);
        line.setId("10");
        line.toString();
        Xml_Line lineFile = new Xml_Line();
        lineFile.writeXmlLine(line,"line" + line.getId() + ".xml");
        Line from = lineFile.readXmlLine("line" + line.getId() + ".xml");
        from.toString();
    }

    private static void testXmlBuses(){
        System.out.print("\nTesting Xml Buses: \n");
        Driver driver = new Driver();
        driver.setId("001");
        driver.setName("Henrik");
        Buss one = new Buss();
        Buss two = new Buss();
        Buss three = new Buss();
        one.setDriver(driver);
        two.setDriver(driver);
        three.setDriver(driver);
        one.setId("DXD868");
        two.setId("DXD878");
        three.setId("DXD888");
        one.setActive(false);
        two.setActive(true);
        three.setActive(true);
        System.out.println(one.toString());
        Buses buses = new Buses();
        buses.addBuses(one);
        buses.addBuses(two);
        buses.addBuses(three);
        Xml_Line lineFile = new Xml_Line();
        lineFile.writeXmlBuses(buses);
        Buses from = lineFile.readXmlBuses();
        System.out.println(from.toString());
        System.out.println(from.getInactive().toString());
    }

    private static void testJson(){
        Convert_toJson toJson = new Convert_toJson();
        toJson.toJson();
    }
}
