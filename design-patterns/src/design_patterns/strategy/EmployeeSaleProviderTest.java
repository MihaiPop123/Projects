package design_patterns.strategy;

import design_patterns.strategy.salary.StrategyResolver;

public class EmployeeSaleProviderTest {
    public static void main(String[] args) {
        EmployeeSalaryProvider employeeSalaryProvider = new EmployeeSalaryProvider();

        Employee juniorEmployee = new Employee(EmployeeType.JUNIOR, 0);
        System.out.println(employeeSalaryProvider.getSalary(juniorEmployee));

        Employee middleEmployee = new Employee(EmployeeType.MIDDLE, 3);
        System.out.println(employeeSalaryProvider.getSalary(middleEmployee));

        Employee seniorEmployee = new Employee(EmployeeType.SENIOR, 3);
        System.out.println(employeeSalaryProvider.getSalary(seniorEmployee));

        StrategyResolver resolver = new StrategyResolver();

        System.out.println(resolver.resolve(juniorEmployee).calculateSalary(juniorEmployee));
        System.out.println(resolver.resolve(middleEmployee).calculateSalary(middleEmployee));
        System.out.println(resolver.resolve(seniorEmployee).calculateSalary(seniorEmployee));
    }

    public static interface SalaryCalculatorStrategy {

        public int calculateSalary();

    }
}
