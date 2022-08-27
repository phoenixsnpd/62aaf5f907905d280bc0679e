package ua.ithillel.lesson7.overcomeobstacles;

public abstract class Participant {
    private int runEndurance;
    private  int jumpEndurance;
    public abstract void run();
    public abstract void jump();

    public int getRunEndurance() {
        return runEndurance;
    }

    public int getJumpEndurance() {
        return jumpEndurance;
    }
}
