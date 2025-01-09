package forpeople;

public class Blood {

    private String color;
    private double sumLiterBlood = Math.random() * 100;

    public Blood(String color) {
        this.color = color;
    }

    public double getGushFirst() {
        //color = "Black";
        return sumLiterBlood;
    }


    public double getGushSecond() {
        sumLiterBlood = 2 * sumLiterBlood;
        return sumLiterBlood;
    }
}


