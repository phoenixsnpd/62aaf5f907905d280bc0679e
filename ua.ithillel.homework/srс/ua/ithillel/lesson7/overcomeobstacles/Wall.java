package ua.ithillel.lesson7.overcomeobstacles;

public class Wall implements Obstacle {
    private int height;

    public Wall(int height) {
        this.height = height;
    }

    @Override
    public boolean overcome(Participant participant) {
        if (participant.getJumpEndurance() < height) {
            System.out.println(height + "-meters wall is too high for participant");
            return false;
        } else {
            participant.jump();
            System.out.println("over a " + height + " meter wall");
        }
        return true;
    }
}
