package ua.ithillel.lesson7.overcomeobstacles;

public class Cat extends Participant {
    private int runEndurance = 200;
    private  int jumpEndurance = 2;

    @Override
    public void run() {
        System.out.print("The cat ran ");
    }
    @Override
    public void jump() {
        System.out.print("The cat jumped ");
    }

    public int getRunEndurance() {
        return runEndurance;
    }

    public int getJumpEndurance() {
        return jumpEndurance;
    }
}
