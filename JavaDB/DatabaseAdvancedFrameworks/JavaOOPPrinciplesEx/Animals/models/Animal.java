package Animals.models;

import static Animals.constraints.Constraints.*;

public abstract class Animal {
    private String name;
    private int age;
    private String gender;

    protected Animal(String name, int age, String gender) {
        this.setName(name);
        this.setAge(age);
        this.setGender(gender);
    }

    private String getName() {
        return name;
    }

    private void setName(String name) {
        if (name == null || name.isEmpty()){
            throw new IllegalArgumentException(INVALID_INPUT);
        }
        this.name = name;
    }

    private int getAge() {
        return age;
    }

    private void setAge(int age) {
        if (age < 0){
            throw new IllegalArgumentException(INVALID_INPUT);
        }

        this.age = age;
    }

    private String getGender() {
        return gender;
    }

    private void setGender(String gender) {
        if (gender == null || gender.isEmpty() ||
                (!MALE.equalsIgnoreCase(gender) &&
                        !FEMALE.equalsIgnoreCase(gender))){
            throw new IllegalArgumentException(INVALID_INPUT);
        }

        this.gender = gender;
    }

    public String produceSound(){
        return ANIMAL_SOUND;
    };

    @Override
    public String toString() {
        return String.format(ANIMAL_INFO_STRING_FORMAT,
                this.getClass().getSimpleName(),
                this.getName(),
                this.getAge(),
                this.getGender());
    }
}
