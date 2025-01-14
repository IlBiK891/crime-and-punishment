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
        if (this == obj) return true; // Сравнение с самим собой
        if (obj == null || getClass() != obj.getClass()) return false; // Проверка класса
        if (!super.equals(obj)) return false; // Сравнение родительских полей (Person)

        Babka babka = (Babka) obj;
        return hp == babka.hp && firstHp == babka.firstHp; // Сравнение специфичных полей
    }

    @Override
    public int hashCode() {
        int result = super.hashCode(); // Используем хэш родительских полей
        result = 31 * result + hp;
        result = 31 * result + firstHp;
        return result;
    }

    @Override
    public String toString() {
        return "Babka{" +
                "name='" + getName() + '\'' + // Поле из родительского класса Person
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
