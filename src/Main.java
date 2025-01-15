import enums.Items;
import enums.Position;
import enums.Status;
import exc.NullItemException;
import forpeople.Blood;
import forpeople.Dresser;
import forpeople.Item;
import forpeople.Tools;
import people.Babka;
import people.GhostBabka;
import people.Person;
import people.Person.Costume;
import people.Raskolnikov;

import java.util.ArrayList;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        LoggerConfig.configureLogging();
        Random random = new Random();

        boolean createObject = random.nextBoolean();

        Item scissors = null;
        if (createObject) {
            scissors = new Item(Items.SCISSORS);
        }
        ArrayList<Item> itemArrayList = new ArrayList<>();
        for (Items item : new Items[]{Items.WALLET, Items.KEYS, Items.SWORD}) {
            itemArrayList.add(new Item(item));
        }


        Item rope = new Item(Items.ROPE, false, true);


        Babka babka = new Babka(100);
        Person.Body bodyB = babka.new Body(32);
        Person.Body.Hair hair = bodyB.new Hair(10000);

        Raskolnikov raskolnikov = new Raskolnikov( Position.STAND);
        Costume costume = raskolnikov.new Costume("frak");

        GhostBabka ghostbabka = new GhostBabka(true);
        Blood blood = new Blood();

        Dresser dresser = new Dresser();
        Dresser.Shelf polka = dresser.new Shelf(10);

        Tools axe = new Tools(Items.AXE, true);


        hair.setHairstyle();
        raskolnikov.take(axe);
        raskolnikov.hit(babka, blood, costume, axe);
        bodyB.fall(raskolnikov);
        raskolnikov.setStatus(Status.SHIVER);
        raskolnikov.stepBack(bodyB);
        raskolnikov.setPosition(Position.BENTDOWN);
        raskolnikov.drop(axe);
        raskolnikov.take(itemArrayList.get(1));
        raskolnikov.move();
        raskolnikov.setStatus(Status.CRAMP);
        polka.open(itemArrayList.get(1));
        raskolnikov.laugh();
        raskolnikov.vision(ghostbabka);
        raskolnikov.drop(itemArrayList.get(1));
        raskolnikov.move();
        raskolnikov.take(axe);
        rope.setWetness(true);
        raskolnikov.setPosition(Position.BENTDOWN);
        raskolnikov.cutRope(scissors, itemArrayList.get(2), rope);
        raskolnikov.take(itemArrayList.getFirst());
        raskolnikov.setPosition(Position.STAND);
        raskolnikov.hidePocket(itemArrayList.getFirst());
        raskolnikov.take(axe);
        raskolnikov.move();
    }
}