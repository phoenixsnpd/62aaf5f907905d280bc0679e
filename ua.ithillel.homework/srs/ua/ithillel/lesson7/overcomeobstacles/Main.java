package ua.ithillel.lesson7.overcomeobstacles;

public class Main {
    public static void main(String[] args) {
        Participant[] participants = {new Robot(), new Human(), new Cat()};
        Obstacle[] obstacles = {new Wall(1), new Treadmill(50), new Wall(2), new Treadmill(1000)};
        competition(participants, obstacles);

    }
    public static void competition(Participant[] participants, Obstacle[] obstacles) {
        for (int i = 0; i < obstacles.length; i++) {
            for (int j = 0; j < participants.length; j++) {
                if (participants[j] == null) {
                    continue;
                }
                if (obstacles[i].overcome(participants[j]) == false) {
                    System.out.println("participant number " + (j + 1) + " dropped out");
                    participants[j] = null;
                }
            }
        }
    }
}
