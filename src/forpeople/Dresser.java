package forpeople;

import enums.Items;
import enums.Position;
import interfaces.Move;
import people.Raskolnikov;

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



        public void move() {
            durability = durability - 1;
            logger.log(Level.INFO, "Раздался скрип");
        }

        public void open(Item i, Raskolnikov raskolnikov) {
            Raskolnikov r = new Raskolnikov(Position.STAND);
                if (raskolnikov.hashCode() == r.hashCode()){
                    if (r.equals(raskolnikov)){

                if (i != null && Items.KEYS.equals(i.getName())) {
                    move();
                    logger.log(Level.INFO, "Полка открыта");
                } else {
                    logger.log(Level.INFO, "Неверный предмет для открытия");
                }}
                }
        }

    }
}
