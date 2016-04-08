package System.Objekt;

/**
 * Created by Spiks on 2016-04-08.
 */
public class Person {
    protected String id;
    protected String name;

    public String getId(){
        return id;
    }

    public void setId(String inId){
        id = inId;
    }

    public void setName(String inName){
        name = inName;
    }

    public String getName(){
        return name;
    }
}
