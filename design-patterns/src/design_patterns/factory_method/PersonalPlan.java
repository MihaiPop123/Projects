package design_patterns.factory_method;

public class PersonalPlan extends Plan{
    /**
     * TODO:
     * 1. extend Plan class
     * 2. override getRate method and return a double with value 5
     */

    @Override
    public Double getRate() {
        return 5.0;
    }
}
