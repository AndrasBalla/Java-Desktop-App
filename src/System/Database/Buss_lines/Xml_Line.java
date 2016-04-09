package System.Database.Buss_lines;

import java.io.File;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import System.Objekt.Line;
import System.Objekt.Buses;

/**
 * Created by Spiks on 2016-04-08.
 */
public class Xml_Line {
    private static final String FILE_NAME = "src/System/Database/Buss_lines/";

    public void writeXmlLine(Line line, String name){
        try {
            JAXBContext context = JAXBContext.newInstance(Line.class);
            Marshaller m = context.createMarshaller();
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

            // Write to System.out for debugging
            m.marshal(line, System.out);

            // Write to File
            m.marshal(line, new File(FILE_NAME + name));
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    public Line readXmlLine(String name){
        try{
            JAXBContext context = JAXBContext.newInstance(Line.class);
            Unmarshaller un = context.createUnmarshaller();
            System.out.println(this.getClass().getResource(name));
            Line temp = (Line) un.unmarshal(new File(FILE_NAME + name));
            return temp;
        } catch(JAXBException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void writeXmlBuses(Buses buses){
        try {
            JAXBContext context = JAXBContext.newInstance(Buses.class);
            Marshaller m = context.createMarshaller();
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

            // Write to System.out for debugging
            m.marshal(buses, System.out);

            // Write to File
            m.marshal(buses, new File(FILE_NAME + "garage.xml"));
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    public Buses readXmlBuses(){
        try{
            JAXBContext context = JAXBContext.newInstance(Buses.class);
            Unmarshaller un = context.createUnmarshaller();
            System.out.println(this.getClass().getResource("garage.xml"));
            Buses temp = (Buses) un.unmarshal(new File(FILE_NAME + "garage.xml"));
            return temp;
        } catch(JAXBException e) {
            e.printStackTrace();
        }
        return null;
    }


}
