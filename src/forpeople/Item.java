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
