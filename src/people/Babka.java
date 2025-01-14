package people;

public class Babka extends Person {

    private int hp;
    private final int firstHp;

    public Babka(int hp) {
        this.hp = hp;
        firstHp = hp;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        if (!super.equals(obj)) return false;

        Babka babka = (Babka) obj;
        return hp == babka.hp && firstHp == babka.firstHp;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + hp;
        result = 31 * result + firstHp;
        return result;
    }

    @Override
    public String toString() {
        return "Babka{" +
                "name='" + getName() + '\'' +
                ", hp=" + hp +
                ", firstHp=" + firstHp +
                '}';
    }


    public int getHp() {
        return hp;
    }

    public int getFirstHp() {
        return firstHp;
    }

    public void setHp(int sumHit) {
        hp = hp - sumHit;
    }

    public void setSecondHp() {
        hp = 0;
    }


}
