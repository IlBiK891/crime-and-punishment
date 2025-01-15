package forpeople;

import enums.Items;
import interfaces.Move;

import java.util.logging.ConsoleHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Dresser {


    public class Shelf implements Move {
        private int durability;
        private Items name;

        public Shelf(int durability) {
            this.durability = durability;
        }

        private static final Logger logger = Logger.getLogger(Dresser.class.getName());
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


        @Override
        public boolean equals(Object o) {

            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Shelf shelf = (Shelf) o;
            return name != null && name.equals(shelf.name);
        }

        @Override
        public int hashCode() {
            return name != null ? name.hashCode() : 0;
        }

        public void move() {
            durability = durability - 1;
            logger.log(Level.INFO, "Раздался скрип");
        }

        public void open(Item i) {
            if (i != null && Items.KEYS.equals(i.getName())) {
                move();
                logger.log(Level.INFO, "Полка открыта");
            } else {
                logger.log(Level.INFO, "Неверный предмет для открытия");
            }
        }
    }
}
