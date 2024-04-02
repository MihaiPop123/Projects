package design_patterns.strategy;

public class        Employee {
    private EmployeeType type;
    private int yearsOfExperience;

    public Employee(EmployeeType type, int yearsOfExperience) {
        this.type = type;
        this.yearsOfExperience = yearsOfExperience;
    }

    public EmployeeType getType() { return type;}

    public int getYearsOfExperience() { return yearsOfExperience;}
}
