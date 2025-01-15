package forpeople;


import enums.Items;
import people.Raskolnikov;

import java.util.logging.ConsoleHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Item {
    private Items name;
    private boolean wetness;
    private boolean integrity;

    public Item(Items name) {
        this.name = name;
    }

    public Item(Items name, boolean wetness, boolean integrity) {
        this.name = name;
        this.wetness = wetness;
        this.integrity = integrity;
    }

    private static final Logger logger = Logger.getLogger(Item.class.getName());
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
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Item item = (Item) obj;
        return wetness == item.wetness &&
                integrity == item.integrity &&
                name == item.name;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (wetness ? 1 : 0);
        result = 31 * result + (integrity ? 1 : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Item{" +
                "name=" + name +
                ", wetness=" + wetness +
                ", integrity=" + integrity +
                '}';
    }

    public Items getName() {
        return name;
    }

    public void setIntegrity(boolean integrity) {
        this.integrity = integrity;
    }

    public boolean isIntegrity() {
        return integrity;
    }

    public boolean getWetness() {
        return wetness;
    }

    public void setWetness(boolean wetness) {
        logger.log(Level.INFO, "Веревка пропиталась кровью");
        this.wetness = wetness;
    }


}
