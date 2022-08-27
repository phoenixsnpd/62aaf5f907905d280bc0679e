package ua.ithillel.lesson7.overcomeobstacles;

public class Wall implements Obstacle {
    int height;

    public Wall(int height) {
        this.height = height;
    }
    @Override
    public boolean overcome(Participant participant) {
        if (participant instanceof Human && participant.getJumpEndurance() < height) {
            System.out.println(height + "-meters wall is too high for human");
            return false;
        } else if (participant instanceof Cat && participant.getJumpEndurance() < height) {
            System.out.println(height + "-meters wall is too high for cat");
            return false;
        } else if (participant instanceof Robot && participant.getJumpEndurance() < height) {
            System.out.println(height + "-meters wall is too high for robot");
            return false;
        } else {
            participant.jump();
            System.out.println("over a " + height + " meter wall");
        }
        return true;
    }
}
