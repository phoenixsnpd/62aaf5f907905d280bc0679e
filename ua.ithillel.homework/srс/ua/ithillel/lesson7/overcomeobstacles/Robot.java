package ua.ithillel.lesson7.overcomeobstacles;

public class Robot implements Participant {
    static final int RUN_ENDURANCE = 5000;
    static final int JUMP_ENDURANCE = 5;

    @Override
    public void run() {
        System.out.print("The robot ran ");
    }
    @Override
    public void jump() {
        System.out.print("The robot jumped ");
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
