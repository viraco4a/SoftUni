package Mankind.models;

public class Student extends Human {
    private static final int MIN_FAC_NUM = 5;
    private static final int MAX_FAC_NUM = 10;

    private String facultyNumber;

    public Student(String firstName, String lastName, String facultyNumber ) {
        super(firstName, lastName);
        this.setFacultyNumber(facultyNumber);
    }

    public String getFacultyNumber() {
        return facultyNumber;
    }

    public void setFacultyNumber(String facultyNumber) {
        if (facultyNumber.length() < MIN_FAC_NUM || facultyNumber.length() > MAX_FAC_NUM){
            throw new IllegalArgumentException(
                    "Invalid faculty number!"
            );
        }
        this.facultyNumber = facultyNumber;
    }

    @Override
    public String toString(){
        return super.toString() +
                String.format("Faculty number: %s%n", this.getFacultyNumber());
    }
}
