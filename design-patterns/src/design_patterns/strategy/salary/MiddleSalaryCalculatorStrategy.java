package design_patterns.strategy.salary;

import design_patterns.strategy.Employee;
import design_patterns.strategy.EmployeeType;

public class MiddleSalaryCalculatorStrategy implements SalaryCalculatorStrategy{

    @Override
    public int calculateSalary(Employee employee) {
        return ApplicationConstants.BASE_SALARY + 100;

    }

    @Override
    public boolean supports(EmployeeType employeeType) {
        return employeeType.equals(EmployeeType.MIDDLE);
    }
}
