package Animals.models;

import static Animals.constraints.Constraints.DOG_SOUND;

public class Dog extends Animal {
    public Dog(String name, int age, String gender) {
        super(name, age, gender);
    }

    @Override
    public String produceSound() {
        return DOG_SOUND;
    }
}
