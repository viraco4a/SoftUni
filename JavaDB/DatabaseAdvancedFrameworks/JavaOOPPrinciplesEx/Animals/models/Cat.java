package Animals.models;

import static Animals.constraints.Constraints.CAT_SOUND;

public class Cat extends Animal {

    public Cat(String name, int age, String gender) {
        super(name, age, gender);
    }

    @Override
    public String produceSound() {
        return CAT_SOUND;
    }
}
