package Main.Database.Buss_lines;

import Main.java.Objekt.Driver;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Created by Spiks on 2016-04-15.
 */
public class Convert_toJson {


    public String toJson(){
        ObjectMapper mapper = new ObjectMapper();
        Driver driver = new Driver();
        driver.setId("910612-1511");
        driver.setName("Andras Balla");
        driver.setDriverId("25428");
        String jsonInString = "";

        try {
            // Convert object to JSON string
            jsonInString = mapper.writeValueAsString(driver);
            System.out.println(jsonInString);

            // Convert object to JSON string and pretty print
            jsonInString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(driver);
            System.out.println(jsonInString);


        } catch (JsonGenerationException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jsonInString;
    }
}
