package System;

import System.Database.Buss_lines.Xml_Line;
import System.Objekt.Buss;
import System.Objekt.Driver;
import System.Objekt.Line;
import System.Objekt.Stop;

public class Main {

    public static void main(String[] args) {
        Driver driver = new Driver();
        driver.setId("001");
        driver.setName("Henrik");
        System.out.println(driver.toString());
        Buss one = new Buss("DXD868",driver);
        System.out.println(one.toString());
        testStop();
        testLine();
        testXmlLine();
    }

    public static void testStop(){
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

    public static void testLine(){
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

    public static void testXmlLine(){
        System.out.print("\nTesting Xml Line: \n");
        Stop oneStop = new Stop("01","Ringen","Halmstad");
        Stop two = new Stop("02","Central","Halmstad");
        Stop three = new Stop("03","Tåg","Halmstad");
        Line line = new Line();
        line.addStops(oneStop);
        line.addStops(two);
        line.addStops(three);
        line.toString();
        Xml_Line lineFile = new Xml_Line();
        lineFile.writeXml(line,"line02.xml");
        Line from = lineFile.readXml("line02.xml");
        from.toString();
    }
}
