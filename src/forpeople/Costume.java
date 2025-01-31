package forpeople;

import people.Person;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Costume {
    private boolean isDirty;
    private String name;


    public Costume(String name) {
        this.name = name;
    }

    private static final Logger logger = Logger.getLogger(Person.class.getName());

    public void setIsDirty(boolean isDirty) {
        this.isDirty = isDirty;
        logger.log(Level.INFO, "Костюм забрызган кровью");
    }
}