package com.company;

public class Main {

    public static void main(String[] args) {
        Cat cat = new Cat("Mosya",4, 90);
        Human human = new Human("Andrey", 6, 3900);
        Robot robot = new Robot("Petya", 8, 3000);
        cat.run(4);
        cat.jump(1);
        human.run(30);
        human.jump(2);
        robot.run(5000);
        robot.jump(10);

        Runable_and_Jumpable members[] = {
                new Robot("Vasya", 4, 9000),
                new Robot("Petya", 8, 3000),
                new Cat("Lus'ka", 1, 80),
                new Cat("Dus'ka", 2, 40),
                new Human("Andrey", 6, 3900),
                new Human("Anton", 5, 2500)
        };
        Wall wall[] = {
                new Wall(4),
                new Wall(2),
                new Wall(10)
        };
        Treadmill treadmill[] = {
                new Treadmill(280),
                new Treadmill(280),
                new Treadmill(20),
                new Treadmill(1000),
                new Treadmill(8500)
        };


        for (Wall w : wall) {
            for (Runable_and_Jumpable m : members) {
                if (m.getParticipation() && !m.jump(w.getHeight())) {
                    m.setParticipation(false);
                }
            }
        }
        for (Treadmill t : treadmill) {
            for (Runable_and_Jumpable m : members) {
                if (m.getParticipation() && !m.run(t.getDistance())) {
                    m.setParticipation(false);
                }
            }
        }




    }
}
