package design_patterns.strategy.salary;

import design_patterns.strategy.Employee;
import design_patterns.strategy.EmployeeType;

public interface SalaryCalculatorStrategy {

    public int calculateSalary(Employee employee);

    boolean supports(EmployeeType employeeType);
}
