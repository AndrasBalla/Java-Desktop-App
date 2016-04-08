package System.Database.Buss_lines;

import java.io.File;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import System.Objekt.Line;

/**
 * Created by Spiks on 2016-04-08.
 */
public class Xml_Line {
    private static final String FILE_NAME = "src/System/Database/Buss_lines/";

    public void writeXml(Line line, String name){
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

    public Line readXml(String name){
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


}
