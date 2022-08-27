package ua.ithillel.lesson7.overcomeobstacles;

public class Human extends Participant {
    private int runEndurance = 100;
    private  int jumpEndurance = 1;

    @Override
    public void run() {
        System.out.print("The human ran ");
    }
    @Override
    public void jump() {
        System.out.print("The human jumped ");
    }

    public int getRunEndurance() {
        return runEndurance;
    }

    public int getJumpEndurance() {
        return jumpEndurance;
    }
}

