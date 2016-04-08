package System.Database.Buss_lines;

import java.io.File;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import System.Objekt.Line;
import System.Objekt.Stop;

/**
 * Created by Spiks on 2016-04-08.
 */
public class Xml_Line {
    Stop stop = new Stop();
    private static final String FILE_NAME = "src/System/Database/Buss_lines/";

    public void generateStop(){
        stop.setId("01");
        stop.setName("Ringen");
        stop.setLocation("Halmstad");
    }

    public void toXml(Line line, String name){
        try {

            File file = new File(FILE_NAME + name);
            JAXBContext jaxbContext = JAXBContext.newInstance(Line.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            // output pretty printed
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            jaxbMarshaller.marshal(line, file);
            jaxbMarshaller.marshal(line, System.out);

        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

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


}
