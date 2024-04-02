package design_patterns.builder;

public class StudentBuilder {

    /**
     * TODO Steps to create a builder class:
     * 1. create a private constructor without parameters
     * 2. create a public static method called "createInstance" that returns a StudentBuilder instance using constructor defined at step 1
     * 3. declare all instance variables from target class (Student class in our case) and make them private
     * 4. For each instance variable create a public method with same name as the variable.
     *  - INPUT: method has one argument of variable's type. Assign argument value to variable
     *  - OUTPUT: return this instance of builder (StudentBuilder in our case)
     * 5. create a method called "build" that instantiate a new Student and pass as arguments, corresponding variable from StudentBuilder class.
     * <p>
     * Great job! Now you have a builder class. Let put this at work!
     * <p>
     * TODO Go back to Student class and in main method create a new Student using StudentBuilder.
     * Spot the differences from creating Student using new keyword.
     */

    private String name;
    private int age;
    private String studentDescription;
    private Double gradeAverageFirstYear;
    private Double gradeAverageSecondYear;
    private Double gradeAverageThirdYear;
    private Double gradeAverageFourthYear;

    private StudentBuilder() {
    }

    public static StudentBuilder createInstance() {
        return new StudentBuilder();
    }

    public StudentBuilder name(String string) {
        this.name = string;
        return this;
    }

    public StudentBuilder age(int integer) {
        this.age = integer;
        return this;
    }

    public StudentBuilder description(String string) {
        this.studentDescription = string;
        return this;
    }

    public StudentBuilder gradeAverageFirstYear(double number) {
        this.gradeAverageFirstYear = number;
        return this;
    }

    public StudentBuilder gradeAverageSecondYear(double number) {
        this.gradeAverageSecondYear = number;
        return this;
    }

    public StudentBuilder gradeAverageThirdYear(double number) {
        this.gradeAverageThirdYear = number;
        return this;
    }

    public StudentBuilder gradeAverageFourthYear(double number) {
        this.gradeAverageFourthYear = number;
        return this;
    }

    public Student build() {
        return new Student(name, age, studentDescription, gradeAverageFirstYear, gradeAverageSecondYear, gradeAverageThirdYear, gradeAverageFourthYear);
    }

}
