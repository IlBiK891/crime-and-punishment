package people;

import enums.Position;
import enums.Status;

import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class Person {


    public String name;
    private Position position;
    private Status status;


    public String getName() {
        return name;
    }

    public Person() {
    }

    public Person(String name, Position position) {
        this.name = name;
        this.position = position;
    }

    private static final Logger logger = Logger.getLogger(Person.class.getName());


    public void setStatus(Status status) {
        logger.log(Level.INFO, "Состояние  " + status);
        this.status = status;
    }

    public void setPosition(Position position) {
        this.position = position;
        logger.log(Level.INFO, "Положение " + position);
    }

    public Position getPosition() {
        return position;
    }

}
