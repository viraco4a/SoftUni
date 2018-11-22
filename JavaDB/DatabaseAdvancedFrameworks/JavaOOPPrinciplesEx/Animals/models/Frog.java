package Animals.models;

import static Animals.constraints.Constraints.FROG_SOUND;

public class Frog extends Animal {
    public Frog(String name, int age, String gender) {
        super(name, age, gender);
    }

    @Override
    public String produceSound() {
        return FROG_SOUND;
    }
}
