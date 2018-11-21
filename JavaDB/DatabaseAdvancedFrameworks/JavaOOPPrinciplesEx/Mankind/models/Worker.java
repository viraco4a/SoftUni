package Mankind.models;

public class Worker extends Human {
    private static final double MIN_WEEK_SALARY = 10;
    private static final int MIN_WORKING_HOURS = 1;
    private static final int MAX_WORKING_HOURS = 12;
    private static final int MIN_LAST_NAME_LENGTH = 3;
    private double weekSalary;
    private double hoursWork;
    private double salaryPerHour;

    public Worker(String firstName, String lastName, double weekSalary, double hoursWork) {
        super(firstName, lastName);
        this.setWeekSalary(weekSalary);
        this.setHoursWork(hoursWork);
        this.setSalaryPerHour();
    }

    public double getSalaryPerHour() {
        return salaryPerHour;
    }

    public void setSalaryPerHour() {
        this.salaryPerHour = (weekSalary / 7) / this.hoursWork;
    }

    public double getWeekSalary() {
        return weekSalary;
    }

    public void setWeekSalary(double weekSalary) {
        if (weekSalary <= MIN_WEEK_SALARY){
            throw new IllegalArgumentException(
                    "Expected value mismatch!Argument: weekSalary"
            );
        }

        this.weekSalary = weekSalary;
    }

    public double getHoursWork() {
        return hoursWork;
    }

    public void setHoursWork(double hoursWork) {
        if (hoursWork < MIN_WORKING_HOURS || hoursWork > MAX_WORKING_HOURS){
            throw new IllegalArgumentException(
                    "Expected value mismatch!Argument: workHoursPerDay"
            );
        }

        this.hoursWork = hoursWork;
    }

    @Override
    public void setLastName(String lastName) {
        if (Character.isLowerCase(lastName.charAt(0))){
            throw new IllegalArgumentException(
                    "Expected upper case letter!Argument: lastName");
        }

        if (lastName.length() < MIN_LAST_NAME_LENGTH){
            throw new IllegalArgumentException(String.format(
                    "Expected length more than %d symbols!Argument: lastName",
                    MIN_LAST_NAME_LENGTH));
        }

        super.setLastName(lastName);
    }

    @Override
    public String toString(){
        return super.toString() +
                String.format("Week Salary: %.2f%n", this.getWeekSalary()) +
                String.format("Hours per day: %.2f%n", this.getHoursWork()) +
                String.format("Salary per hour: %.2f", this.getSalaryPerHour());
    }
}
