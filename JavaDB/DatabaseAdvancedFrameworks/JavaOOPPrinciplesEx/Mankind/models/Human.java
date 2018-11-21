package Mankind.models;

public abstract class Human {
    private static final int MIN_FIRST_NAME_LENGTH = 4;
    private static final int MIN_LAST_NAME_LENGTH = 3;
    private String firstName;
    private String lastName;

    public Human(String firstName, String lastName) {
        this.setFirstName(firstName);
        this.setLastName(lastName);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        if (Character.isLowerCase(firstName.charAt(0))){
            throw new IllegalArgumentException(
                    "Expected upper case letter!Argument: firstName");
        }

        if (firstName.length() < MIN_FIRST_NAME_LENGTH){
            throw new IllegalArgumentException(String.format(
                    "Expected length at least %d symbols!Argument: firstName",
                    MIN_FIRST_NAME_LENGTH));
        }

        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        if (Character.isLowerCase(lastName.charAt(0))){
            throw new IllegalArgumentException(
                    "Expected upper case letter!Argument: lastName");
        }

        if (lastName.length() < MIN_LAST_NAME_LENGTH){
            throw new IllegalArgumentException(String.format(
                    "Expected length at least %d symbols!Argument: lastName",
                    MIN_LAST_NAME_LENGTH));
        }

        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return String.format("First Name: %s%n", this.getFirstName()) +
                String.format("Last Name: %s%n", this.getLastName());
    }
}
