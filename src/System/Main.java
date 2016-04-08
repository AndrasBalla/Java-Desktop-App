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
        Stop oneStop = new Stop("01","Ringen","Halmstad");
        Stop two = new Stop("02","Central","Halmstad");
        Stop three = new Stop("03","Tåg","Halmstad");
        Line line = new Line();
        line.addStops(oneStop);
        line.addStops(two);
        line.addStops(three);
        line.toString();
        Xml_Line lineFile = new Xml_Line();
        lineFile.toXml(line,"line01.xml");
        lineFile.writeXml(line,"line02.xml");
    }
}
