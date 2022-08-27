package ua.ithillel.lesson7.overcomeobstacles;

public class Robot extends Participant {
    private int runEndurance = 5000;
    private  int jumpEndurance = 5;

    @Override
    public void run() {
        System.out.print("The robot ran ");
    }
    @Override
    public void jump() {
        System.out.print("The robot jumped ");
    }

    public int getRunEndurance() {
        return runEndurance;
    }

    public int getJumpEndurance() {
        return jumpEndurance;
    }
}
