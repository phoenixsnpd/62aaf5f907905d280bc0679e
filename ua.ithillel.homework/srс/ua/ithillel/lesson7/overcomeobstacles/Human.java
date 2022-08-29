package ua.ithillel.lesson7.overcomeobstacles;

public class Human implements Participant {
    static final int RUN_ENDURANCE = 100;
    static final int JUMP_ENDURANCE = 1;

    @Override
    public void run() {
        System.out.print("The human ran ");
    }
    @Override
    public void jump() {
        System.out.print("The human jumped ");
    }

    @Override
    public int getRunEndurance() {
        return RUN_ENDURANCE;
    }
    @Override
    public int getJumpEndurance() {
        return JUMP_ENDURANCE;
    }
}

