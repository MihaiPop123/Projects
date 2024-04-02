package design_patterns.strategy;

public class EmployeeSalaryProvider {

    public static int BASE_SALARY = 1000;

    public int getSalary(Employee employee) {
        switch (employee.getType()) {
            case JUNIOR:
                return BASE_SALARY;
            case MIDDLE:
                return BASE_SALARY + 100;
            case SENIOR:
                return BASE_SALARY + (employee.getYearsOfExperience() * 200);
            default:
                throw new RuntimeException("Employee type " + employee.getType() + "not exists." );
        }
    }
}

/**
 * TODO Please answer to following questions:
 * What this code do? Understand the algorithm for each case.
 * Is this code respecting Single Responsibility principle? Why?
 * It this code respecting Open Closed principle? Why?
 */
