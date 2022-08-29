package ua.ithillel.lesson7.overcomeobstacles;

public class Cat implements Participant {
    static final int RUN_ENDURANCE = 200;
    static final int JUMP_ENDURANCE = 2;

    @Override
    public void run() {
        System.out.print("The cat ran ");
    }
    @Override
    public void jump() {
        System.out.print("The cat jumped ");
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
