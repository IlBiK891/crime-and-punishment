package people;

import enums.Items;
import enums.Position;
import enums.Status;
import exc.NullItemException;
import forpeople.Item;
import forpeople.Tools;
import interfaces.Hit;
import interfaces.Move;


public class Raskolnikov extends Person implements Hit, Move {

    private Position position;
    private boolean x = false;
    private boolean distance;
    private boolean busyHands;

    public Raskolnikov(String name, Position position) {
        super(name);
        this.position = position;
        distance = false;

    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true; // Сравнение с самим собой
        if (obj == null || getClass() != obj.getClass()) return false; // Проверка класса
        if (!super.equals(obj)) return false; // Сравнение родительских полей (Person)

        Raskolnikov that = (Raskolnikov) obj;
        return x == that.x &&
                distance == that.distance &&
                busyHands == that.busyHands &&
                position == that.position; // Сравнение специфичных полей
    }

    @Override
    public int hashCode() {
        int result = super.hashCode(); // Используем хэш родительских полей
        result = 31 * result + (x ? 1 : 0);
        result = 31 * result + (distance ? 1 : 0);
        result = 31 * result + (busyHands ? 1 : 0);
        result = 31 * result + (position != null ? position.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Raskolnikov{" +
                "name='" + getName() + '\'' + // Поле из родительского класса Person
                ", position=" + position +
                ", x=" + x +
                ", distance=" + distance +
                ", busyHands=" + busyHands +
                '}';
    }



    @Override
    public boolean hit(Babka b) {

        // Условие, определяющее "удар"
        if (0 < b.getHp()) {

            if (b.getHp() == b.getFirstHp()) {

                System.out.println("Бабка была ударена!");
                b.setFirstHp(10); // Уменьшаем здоровье бабки
                // Удар успешно выполнен
            } else {
                b.setSecondHp();

            }
            x = true;
        } else {
            System.out.println("Бабка уже мертва!");
            x = false; // Бабка не может быть больше повреждена
        }

        return x;


    }

    @Override
    public void say() {
        System.out.println("Xexe");
    }

    // public void climb(){}

    public void laugh() {
        say();
        setStatus(Status.LAUGHTER);

    }


    public boolean take(Tools t) {
        busyHands = true;
        Tools expectedTool = new Tools(Items.AXE, true);

        // Сравниваем переданный инструмент с ожидаемым
        return expectedTool.equals(t);
    }

    public void move() {
        System.out.println("Раскольников переместился");
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
        busyHands = true;
        System.out.println("Раскольников взял " + i);
    }

    public void hidePocket(Item i) {
        busyHands = false;
        System.out.println("Раскольников положил в карман " + i);

    }

    public void drop(Tools t) {
        busyHands = false;
        System.out.println("Раскольников положил " + t);

    }

    public void drop(Item i) {
        busyHands = false;
        System.out.println("Раскольников положил " + i);

    }

    public void vision(GhostBabka g) {
        g.setVisiable(false);
        System.out.println("Ему почудилась бабка");

    }


    public void cut(Item i, Item r) throws NullItemException {
        if (i == null) {
            throw new NullItemException("Item cannot be null");
        } else {
            r.setIntegrity(false);
            System.out.println("Веревка разрезана");
        }

    }


}
