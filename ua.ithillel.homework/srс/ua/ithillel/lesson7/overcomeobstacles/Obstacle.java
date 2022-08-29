package ua.ithillel.lesson7.overcomeobstacles;

@FunctionalInterface
public interface Obstacle {
    boolean overcome(Participant participant);
}
