package people;

import enums.Position;
import enums.Status;

import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class Person {


    public String name;
    private Position position;
    private int hp;
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
    /*static {
        Logger rootLogger = Logger.getLogger("");
        Handler consoleHandler = new ConsoleHandler();
        consoleHandler.setLevel(Level.ALL);
        rootLogger.addHandler(consoleHandler);
        rootLogger.setLevel(Level.ALL);
        if (logger.getHandlers().length == 0) {
            logger.addHandler(new ConsoleHandler());
        }

    }*/


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

    public class Body {
        private int sumTeeth;
        private Position position;

        public Body(int sumTeeth) {
            this.sumTeeth = sumTeeth;
        }

        public void fall(Raskolnikov r) {
            if (r.getDistance()) {
                setPosition(Position.LYTING);
            } else {
                setPosition(Position.SEMIRECUMBENT);
            }
            sumTeeth = sumTeeth - 1;


        }

        public void setPosition(Position position) {
            this.position = position;
        }

        public Position getPosition() {
            return position;
        }


        public class Hair {
            private int sumHair;

            public Hair(int sumHair) {
                this.sumHair = sumHair;
            }

            public void setHairstyle() {
                boolean isHairstyle = true;
                sumHair = sumHair - 10;
            }
        }
    }


    public class Costume {
        private boolean isDirty;
        private String name;


        public Costume(String name) {
            this.name = name;
        }

        public void setIsDirty(boolean isDirty) {
            this.isDirty = isDirty;
            logger.log(Level.INFO, "Костюм забрызган кровью");
        }
    }


}
