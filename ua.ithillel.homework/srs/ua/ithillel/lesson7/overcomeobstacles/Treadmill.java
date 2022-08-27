package ua.ithillel.lesson7.overcomeobstacles;

public class Treadmill implements Obstacle {
    private int length;

    public Treadmill(int length) {
        this.length = length;
    }

    @Override
    public boolean overcome(Participant participant) {
        if (participant instanceof Human && participant.getRunEndurance() < length) {
            System.out.println(length + "-meters treadmill is too long distance for human");
            return false;
        } else if (participant instanceof Cat && participant.getRunEndurance() < length) {
            System.out.println(length + "-meters treadmill is too long distance for cat");
            return false;
        } else if (participant instanceof Robot && participant.getRunEndurance() < length) {
            System.out.println(length + "-meters treadmill is too long distance for robot");
            return false;
        } else {
            participant.run();
            System.out.println("a " + length + "-meters the treadmill");
        }
        return true;
    }
}
