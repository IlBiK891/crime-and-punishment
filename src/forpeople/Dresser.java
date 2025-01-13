package forpeople;

import enums.Items;
import interfaces.Move;

public class Dresser {


    public class Shelf implements Move {
        private int durability;
        private Items name;

        public Shelf(int durability) {
            this.durability = durability;
        }


        @Override
        public boolean equals(Object o) {

            if (this == o) return true; // Проверка ссылки
            if (o == null || getClass() != o.getClass()) return false; // Проверка класса
            Shelf shelf = (Shelf) o;
            return name != null && name.equals(shelf.name); // Сравнение по имени
        }

        @Override
        public int hashCode() {
            return name != null ? name.hashCode() : 0; // Генерация hashCode
        }

        public void move() {
            durability = durability - 1;
            System.out.println("Раздался скрип");
        }

        public void open(Item i) {
            if (i != null && Items.KEYS.equals(i.getName())) { // Сравнение с константой enum
                move();
                System.out.println("Полка открыта!");
            } else {
                System.out.println("Неверный предмет для открытия!");
            }
        }
    }
}
