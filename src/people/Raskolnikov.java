package people;

import enums.Items;
import enums.Position;
import enums.Status;
import exc.NullItemException;
import exc.ToolsIsNotSharpException;
import forpeople.*;
import interfaces.Move;
import interfaces.Open;

import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Raskolnikov extends Person implements Move, Open {

    private static final Logger logger = Logger.getLogger(Raskolnikov.class.getName());


    private Position position;
    private boolean distance;
    private boolean busyHands;

    public Raskolnikov(Position position) {
        this.position = position;
        distance = false;
    }


    @Override
    public String toString() {
        return "Raskolnikov{" +
                "name='" + getName() + '\'' +
                ", position=" + position +
                ", distance=" + distance +
                ", busyHands=" + busyHands +
                '}';
    }

    public void hit(Babka b, Blood blood, Costume costume, Tools tools) {
        try {
            Babka rightBabka = new Babka(100);
            if (b.hashCode() == rightBabka.hashCode()) {
                if (b.equals(rightBabka)) {
                    if (tools.isSharp()) {
                        while (b.getHp() != 0) {
                            if (0 < b.getHp()) {
                                if (b.getHp() == b.getFirstHp()) {
                                    b.setHp(10);
                                    logger.log(Level.INFO, "Бабка была ударена!");
                                    b.setStatus(Status.SHIVER);
                                    logger.log(Level.INFO, "Бабка вскрикнула");
                                    if (blood.getGushFirst() > 50) {
                                        costume.setIsDirty(true);
                                    }
                                } else {
                                    b.setSecondHp();
                                }
                            }
                            if (blood.getGushSecond() > 50) {
                                costume.setIsDirty(true);
                            }
                            b.setStatus(Status.DEAD);
                            logger.log(Level.INFO, "Бабка уже мертва!");
                        }
                    } else {
                        throw new ToolsIsNotSharpException("Топор тупой");
                    }
                }
            }
        } catch (ToolsIsNotSharpException t) {
            logger.log(Level.SEVERE, t.getMessage());
        }
    }

    public void laugh() {
        logger.log(Level.INFO, "Xexe");
        setStatus(Status.LAUGHTER);
    }

    public void take(Tools t) {
        if (!getBusyHands()) {
            Tools expectedTool = new Tools(Items.AXE, true);
            if (expectedTool.equals(t)) {
                busyHands = true;
                logger.log(Level.INFO, "Раскольников взял топор");
            }
        }
    }

    public void stepBack(Babka babka) {
        if (getDistance()) {
            babka.setPosition(Position.LYTING);
            logger.log(Level.INFO, "Раскольников отошел назад");
        }
        setPosition(Position.STAND);
        distance = true;
        babka.setDistanceB(true);
    }

    public void move() {
        logger.log(Level.INFO, "Раскольников переместился");
        setPosition(Position.STAND);
        distance = true;
    }

    public boolean getDistance() {
        return distance;
    }

    public boolean getBusyHands() {
        return busyHands;
    }

    public void take(Item i) {
        if (getPosition() == Position.BENTDOWN) {
            if (!getBusyHands()) {
                busyHands = true;
                logger.log(Level.INFO, "Раскольников нагнулся и взял {0}", i);
            }
        }
    }

    public void hidePocket(Item i) {
        busyHands = false;
        logger.log(Level.INFO, "Раскольников положил в карман {0}", i);
    }

    public void drop(Tools t) {
        busyHands = false;
        logger.log(Level.INFO, "Раскольников положил {0}", t);
    }

    public void drop(Item i) {
        busyHands = false;
        logger.log(Level.INFO, "Раскольников положил {0}", i);
    }

    public void vision(GhostBabka g) {
        if (g.getVisiable()) {
            g.setVisiable(false);
            logger.log(Level.INFO, "Ему почудилась бабка");
        }
    }

    public void cut(Item i, Item r) throws NullItemException {
        if (i == null) {
            throw new NullItemException("Item cannot be null");
        } else {
            r.setIntegrity(false);
            logger.log(Level.INFO, "Веревка разрезана");
        }
    }

    @Override
    public void open(Dresser d, Item i) {
        Dresser dresser = new Dresser(10);

        //Raskolnikov r = new Raskolnikov(Position.STAND);
        if (dresser.hashCode() == d.hashCode()) {
            if (d.equals(dresser)) {

                if (i != null && Items.KEYS.equals(i.getName())) {
                    move();
                    logger.log(Level.INFO, "Полка открыта");
                } else {
                    logger.log(Level.INFO, "Неверный предмет для открытия");
                }
            }
        }
    }

    /*public void cutRope(Item i1, Item i2, Item r)
    /*{
        try {
            cut(i1, r);
        } catch (NullItemException e) {
            logger.log(Level.SEVERE, e.getMessage());
            try {
                cut(i2, r);
            } catch (NullItemException e2) {
                logger.log(Level.SEVERE, "Ошибка при повторной попытке: {0}", e2.getMessage());
            }
        }
    }*/
}
