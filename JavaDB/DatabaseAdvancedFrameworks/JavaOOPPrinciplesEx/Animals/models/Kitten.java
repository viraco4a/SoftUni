package Animals.models;

import static Animals.constraints.Constraints.KITTEN_SOUND;

public class Kitten extends Cat {

    public Kitten(String name, int age, String gender) {
        super(name, age, gender);
    }

    @Override
    public String produceSound() {
        return KITTEN_SOUND;
    }
}
