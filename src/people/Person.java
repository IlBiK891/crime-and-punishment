package people;

import enums.Position;
import enums.Status;

public abstract class Person {
    /*@Override
    public boolean equals(Object obj) {
        return true;
    }*/


    public String name;
    private Position position;

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Person() {
    }

    public Person(String name, Position position) {
        this.name = name;
        this.position = position;
    }

    private int hp;
    private Status status;

    public abstract void say();

    public void setStatus(Status status) {
        System.out.println("Состояние " + status);
        this.status = status;
    }

    public void setPosition(Position position) {
        this.position = position;
        System.out.println("Положение " + position);
    }

    public Position getPosition() {
        return position;
    }

    public class Body {
        private int sumTeeth;
        private Position position;

        public Body(int sumTeeth) {
            this.sumTeeth = sumTeeth;
        }

        public void fall() {
            sumTeeth = sumTeeth - 1;
        }

        public void setPosition(Position position) {
            this.position = position;
        }

        public Position getPosition() {
            return position;
        }


        public class Hair {
            private int sumHair;

            public Hair(int sumHair) {
                this.sumHair = sumHair;

            }

            public void setHairstyle() {
                boolean isHairstyle = true;
                sumHair = sumHair - 10;

            }


        }


    }


    public class Costume {
        private boolean isDirty;
        private String name;


        public Costume(String name) {
            this.name = name;
        }

        public void setIsDirty(boolean isDirty) {
            this.isDirty = isDirty;
            System.out.println("Костюм забрызган кровью");

            //isDirty = Random
        }
    }




}
