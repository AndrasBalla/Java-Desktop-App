package System.Database.Buss_lines;

import java.io.File;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import System.Objekt.Stop;

/**
 * Created by Spiks on 2016-04-08.
 */
public class Xml_Line {
    Stop stop = new Stop();
    private static final String FILE_NAME = "src/System/Database/Buss_lines/lines.xml";

    public void generateStop(){
        stop.setId("01");
        stop.setName("Ringen");
        stop.setLocation("Halmstad");
    }

    public void toXml(){
        try {

            File file = new File(FILE_NAME);
            JAXBContext jaxbContext = JAXBContext.newInstance(Stop.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            // output pretty printed
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            jaxbMarshaller.marshal(stop, file);
            jaxbMarshaller.marshal(stop, System.out);

        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }


}
