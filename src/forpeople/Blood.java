package forpeople;

public class Blood {


    private double sumLiterBlood = Math.random() * 100;


    public double getGushFirst() {
        return sumLiterBlood;
    }


    public double getGushSecond() {
        sumLiterBlood = 2 * sumLiterBlood;
        return sumLiterBlood;
    }
}


