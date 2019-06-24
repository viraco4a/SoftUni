package spaceStationRecruitment;

import java.util.ArrayList;
import java.util.List;

public class SpaceStation {
    private String name;
    private int capacity;
    private List<Astronaut> data;

    public SpaceStation(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public String getName() {
        return this.name;
    }

    public int getCapacity() {
        return this.capacity;
    }

    public int getCount() {
        return this.data.size();
    }

    public void add(Astronaut astronaut) {
        if (this.getCount() < this.getCapacity()) {
            this.data.add(astronaut);
        }
    }

    public boolean remove(String name) {
        for (int i = 0; i < this.getCount(); i++) {
            if (this.data.get(i).getName().equals(name)) {
                this.data.remove(i);
                return true;
            }
        }
        return false;
    }

    public Astronaut getOldestAstronaut() {
        int max = 0;
        int index = 0;
        for (int i = 0; i < this.getCount(); i++) {
            if (this.data.get(i).getAge() >= max) {
                max = this.data.get(i).getAge();
                index = i;
            }
        }
        return this.data.get(index);
    }

    public Astronaut getAstronaut(String name) {
        for (int i = 0; i < this.getCount(); i++) {
            if (this.data.get(i).getName().equals(name)) {
                return this.data.get(i);
            }
        }
        return null;
    }

    public String report() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Astronauts working at Space Station %s:%n", this.getName()));
        for (Astronaut astronaut : this.data) {
            sb.append(astronaut.toString()).append(System.lineSeparator());
        }

        return sb.toString().trim();
    }
}
