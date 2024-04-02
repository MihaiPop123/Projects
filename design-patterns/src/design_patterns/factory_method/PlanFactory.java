package design_patterns.factory_method;

public class PlanFactory {

    /**
     * TODO: Steps to create FactoryMethod design pattern
     * 1. create a public static method called "getPlan" that gets as argument a String called type and returns a Plan
     * 2. in method body create an if-else block like follows:
     *  - if type equals "personal" return a PersonalPlan instance
     *  - else if type equals "enterprise" return a EnterprisePlan instance
     *  - else throw a RuntimeException with message "There is no Plan of given type"

     * Great job! Now you have a method factory. Let put this at work.

     * TODO: Test your code in a main method created anywhere in this package
     * 1. create a PersonalPlan using factory method. call getRate on it and print the result to console. what is printed?
     * 2. create an EnterprisePlan using factory method. call getRate on it and print the result to console. what is printed?
     * 3. spot the advantages of this pattern
     */

    public static Plan getPlan(String type){

            if(type.equals("personal")) {
                return new PersonalPlan();
            } else if(type.equals("enterprise")) {
                return new EnterprisePlan();
            } else if(type.equals("child")) {
                return new ChildrenPlan();
            } else {
                throw new RuntimeException("There is no Plan of given type");
            }
    }

    public static void main(String[] args) {

        System.out.println(getPlan("personal").getRate());
        System.out.println(getPlan("enterprise").getRate());
        System.out.println(getPlan("child").getRate());
        double planRate = 0.0;
        try {
           getPlan("fictional").getRate();
        }catch (RuntimeException e) {
            e.printStackTrace();
            System.out.println("Invalid plan");
            planRate = 15;
        }
        finally {
            System.out.println ("Plan rate is " + planRate);
        }



    }
}
