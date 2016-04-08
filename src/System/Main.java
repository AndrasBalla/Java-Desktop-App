package System;

import System.Database.Buss_lines.Xml_Line;
import System.Objekt.Buss;
import System.Objekt.Driver;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        System.out.println("Or maybe good bye ?");
        Driver driver = new Driver();
        driver.setId("001");
        driver.setName("Henrik");
        System.out.println(driver.toString());
        Buss one = new Buss("DXD868",driver);
        System.out.println(one.toString());
        Xml_Line line = new Xml_Line();
        line.generateStop();
        line.toXml();
    }
}
