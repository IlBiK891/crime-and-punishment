package people;

import enums.Items;
import enums.Position;
import enums.Status;
import exc.NullItemException;
import exc.ToolsIsNotSharpException;
import forpeople.Item;
import forpeople.Tools;
import interfaces.Hit;
import interfaces.Move;
import forpeople.Blood;


public class Raskolnikov extends Person implements Hit, Move {

    private Position position;
    private boolean distance;
    private boolean busyHands;

    public Raskolnikov(Position position) {
        this.position = position;
        distance = false;

    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        if (!super.equals(obj)) return false;

        Raskolnikov that = (Raskolnikov) obj;
        return distance == that.distance &&
                busyHands == that.busyHands &&
                position == that.position;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (distance ? 1 : 0);
        result = 31 * result + (busyHands ? 1 : 0);
        result = 31 * result + (position != null ? position.hashCode() : 0);
        return result;
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



    @Override
    public void hit(Babka b, Blood blood, Costume costume, Tools tools) {
        try {if (tools.isSharp()){
            while (b.getHp() != 0) {
                if (0 < b.getHp()) {
                    if (b.getHp() == b.getFirstHp()) {
                        b.setHp(10);
                        System.out.println("Бабка была ударена!");
                        b.setStatus(Status.SHIVER);
                        System.out.println("Бабка вскрикнула");
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
                System.out.println("Бабка уже мертва!");
            }
        }else{
               throw new ToolsIsNotSharpException("Топор тупой");
            }}catch (ToolsIsNotSharpException t){
            System.out.println(t.getMessage());
        }

    }


    public void laugh() {
        System.out.println("Xexe");
        setStatus(Status.LAUGHTER);

    }


    public void take(Tools t) {
        if (!getBusyHands()) {
            Tools expectedTool = new Tools(Items.AXE, true);
            if(expectedTool.equals(t)) {
                busyHands = true;
                System.out.println("Раскольников взял топор");
            }
        }
    }

    public void stepBack(Body body) {
        if (getDistance()) {
            body.setPosition(Position.LYTING);
            System.out.println("Раскольников отошел назад");

        }

        setPosition(Position.STAND);
        distance = true;
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
        if(getPosition() == Position.BENTDOWN) {
            if (!getBusyHands()) {
                busyHands = true;
                System.out.println("Раскольников нагнулся и взял " + i);
            }
        }
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
        if (g.getVisiable()) {
        g.setVisiable(false);
        System.out.println("Ему почудилась бабка");
        }

    }


    public void cut(Item i, Item r) throws NullItemException {
        if (i == null) {
            throw new NullItemException("Item cannot be null");
        } else {
            r.setIntegrity(false);
            System.out.println("Веревка разрезана");
        }
    }

    public void cutRope(Item i1, Item i2, Item r){
        try {
            cut(i1, r);
        } catch (NullItemException e) {
            System.out.println(e.getMessage());
            try {
                cut(i2, r);
            } catch (NullItemException e2) {
                System.out.println("Ошибка при повторной попытке: " + e2.getMessage());
            }
        }
    }



}
