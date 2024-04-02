package design_patterns.strategy.salary;

import design_patterns.strategy.Employee;
import design_patterns.strategy.EmployeeType;

import java.util.ArrayList;
import java.util.List;

public class StrategyResolver {

    List<SalaryCalculatorStrategy> strategies = new ArrayList<>();

    public StrategyResolver() {
        strategies.add(new JuniorSalaryCalculatorStrategy());
        strategies.add(new MiddleSalaryCalculatorStrategy());
        strategies.add(new SeniorSalaryCalculatorStrategy());
    }

    public SalaryCalculatorStrategy resolve(Employee employee) {
        EmployeeType typeOfEmployeeToCalculateSalary = employee.getType();
        SalaryCalculatorStrategy foundedStrategy = null;
        for(SalaryCalculatorStrategy strategy : strategies) {
            if (strategy.supports(typeOfEmployeeToCalculateSalary)){
                foundedStrategy = strategy;
            }
        }
        return foundedStrategy;
    }
}
