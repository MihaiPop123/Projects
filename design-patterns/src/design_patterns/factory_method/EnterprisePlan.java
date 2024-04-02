package design_patterns.factory_method;

public class EnterprisePlan extends Plan{
    /**
     * TODO:
     * 1. extend Plan class
     * 2. override getRate method and return a double with value 10
     */

    @Override
    public Double getRate() {
        return 10.0;
    }
}
