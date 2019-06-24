package spaceStationRecruitment;

public class Main {
    public static void main(String[] args) {
// Initialize the repository
        SpaceStation spaceStation = new SpaceStation("Apolo", 1);

// Initialize entity
        Astronaut astronaut = new Astronaut("Stephen", 40, "Bulgaria");

// Print Astronaut
        System.out.println(astronaut); // Astronaut: Stephen, 40 (Bulgaria)

// Add Astronaut
        spaceStation.add(astronaut);

// Remove Astronaut
        System.out.println(spaceStation.remove("Astronaut name")); // false

        Astronaut secondAstronaut = new Astronaut("Mark", 34, "UK");
        Astronaut third = new Astronaut("Kur", 40, "UK");
// Add Astronaut
        spaceStation.add(secondAstronaut);
        spaceStation.add(third);

        Astronaut oldestAstronaut = spaceStation.getOldestAstronaut();
// Astronaut with name Stephen

        Astronaut astronautStephen = spaceStation.getAstronaut("Stephen");
// Astronaut with name Stephen

// Print Astronauts
        System.out.println("oldest " + oldestAstronaut); // Astronaut: Stephen, 40 (Bulgaria)
        System.out.println(astronautStephen); // Astronaut: Stephen, 40 (Bulgaria)

        System.out.println(spaceStation.getCount()); // 2
        System.out.println(spaceStation.report());
        System.out.println(spaceStation.getCount()); // 2
// Astronauts working at Space Station Apolo:
// Astronaut: Stephen, 40 (Bulgaria)
// Astronaut: Mark, 34 (UK)

        spaceStation.remove("Stephen");
        spaceStation.remove("Mark");
        spaceStation.remove("Kur");
        System.out.println(spaceStation.report());
        System.out.println("==================");
    }
}
