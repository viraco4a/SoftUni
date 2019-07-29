package animals;

public abstract class Animal {
    private String name;
    private int age;
    private String gender;

    public Animal(String name, int age, String gender) {
        this.setName(name);
        this.setAge(age);
        this.setGender(gender);
    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }

    public String getGender() {
        return this.gender;
    }

    private void setName(String name) {
        if (name != null && !name.isEmpty()){
            this.name = name;
        } else {
            throw new IllegalArgumentException("Invalid input!");
        }
    }

    private void setAge(int age) {
        if (age > 0){
            this.age = age;
        } else {
            throw new IllegalArgumentException("Invalid input!");
        }
    }

    private void setGender(String gender) {
        if (("Male".equals(gender) || "Female".equals(gender))){
            this.gender = gender;
        } else {
            throw new IllegalArgumentException("Invalid input!");
        }
    }

    public abstract String produceSound();

    @Override
    public String toString() {
        return String.format("%s%n%s %d %s%n%s",
                this.getClass().getSimpleName(),
                this.getName(),
                this.getAge(),
                this.getGender(),
                this.produceSound());
    }
}
