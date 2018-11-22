package Animals.models;

import static Animals.constraints.Constraints.TOMCAT_SOUND;

public class Tomcat extends Cat {
    public Tomcat(String name, int age, String gender) {
        super(name, age, gender);
    }

    @Override
    public String produceSound() {
        return TOMCAT_SOUND;
    }
}
