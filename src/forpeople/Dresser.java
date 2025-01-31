package forpeople;

import enums.Items;
import enums.Position;
import interfaces.Move;
import people.Raskolnikov;

import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Dresser implements Move {
        private int durability;
        private Items name;

        public Dresser(int durability) {
            this.durability = durability;
        }

        private static final Logger logger = Logger.getLogger(Dresser.class.getName());

        public void move() {
            durability = durability - 1;
            logger.log(Level.INFO, "Раздался скрип");
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Dresser dresser = (Dresser) o;
            return durability == dresser.durability && name == dresser.name;
        }

        @Override
        public int hashCode() {
            return Objects.hash(durability, name);
        }

        @Override
        public String toString() {
            return "Dresser{" +
                    "durability=" + durability +
                    ", name=" + name +
                    '}';
        }
    }

