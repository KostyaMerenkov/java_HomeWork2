package com.company;

public class Robot implements Runable_and_Jumpable {
    private String name;
    private int max_height;
    private int max_distance;
    private Boolean participation;

    public Robot(String name, int max_height, int max_distance) {
        this.name = name;
        this.max_height = max_height;
        this.max_distance = max_distance;
        this.participation = true;
    }

    @Override
    public Boolean getParticipation() {
        return participation;
    }

    @Override
    public void setParticipation(Boolean participation) {
        this.participation = participation;
    }

    @Override
    public Boolean jump(int h) {
        if (h <= max_distance) {
            System.out.println("Robot #" + name + " jump " + h + " meters");
            return true;
        }
        else {
            System.out.println("Robot #" + name + "was unable to jump " + h + " meters");
            return false;
        }
    }

    @Override
    public Boolean run(int m) {
        if (m <= max_distance) {
            System.out.println("Robot #" + name + " run " + m + " meters");
            return true;
        }
        else {
            System.out.println("Robot #" + name + "was unable to run " + m + " meters");
            return false;
        }
    }
}
