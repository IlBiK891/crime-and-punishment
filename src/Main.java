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

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Random random = new Random();

        boolean createObject = random.nextBoolean();

        Item scissors = null;
        if (createObject) {
            scissors = new Item(Items.SCISSORS);
        }
        Item wallet = new Item(Items.WALLET);
        Item keys = new Item(Items.KEYS);
        Item sword = new Item(Items.SWORD);
        ArrayList<Item> itemArrayList = new ArrayList<>();
        itemArrayList.add(wallet);
        itemArrayList.add(keys);
        itemArrayList.add(sword);
        Item rope = new Item(Items.ROPE, false, true);


        Babka babka = new Babka(100);
        Person.Body bodyB = babka.new Body(32);
        Person.Body.Hair hair = bodyB.new Hair(10000);

        Raskolnikov raskolnikov = new Raskolnikov( Position.STAND);
        Costume costume = raskolnikov.new Costume("frak");

        GhostBabka ghostbabka = new GhostBabka(true);
        Blood blood = new Blood();

        Dresser dresser = new Dresser("tree");
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
            try {
                raskolnikov.cut(scissors, rope);
            } catch (NullItemException e) {
                System.out.println(e.getMessage());
                try {
                    raskolnikov.cut(itemArrayList.get(2), rope);
                } catch (NullItemException e2) {
                    System.out.println("Ошибка при повторной попытке: " + e2.getMessage());
                }
            }
            raskolnikov.take(itemArrayList.getFirst());
            raskolnikov.setPosition(Position.STAND);
            raskolnikov.hidePocket(itemArrayList.getFirst());
            raskolnikov.take(axe);
            raskolnikov.move();
    }
}