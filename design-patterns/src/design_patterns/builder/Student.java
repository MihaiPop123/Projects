package design_patterns.builder;

public class Student {
    private String name;
    private int age;
    private String description;
    private Double gradeAverageFirstYear;
    private Double gradeAverageSecondYear;
    private Double gradeAverageThirdYear;
    private Double gradeAverageFourthYear;

    public Student(String name, int age, String description, Double gradeAverageFirstYear, Double gradeAverageSecondYear, Double gradeAverageThirdYear, Double gradeAverageFourthYear) {
        this.name = name;
        this.age = age;
        this.description = description;
        this.gradeAverageFirstYear = gradeAverageFirstYear;
        this.gradeAverageSecondYear = gradeAverageSecondYear;
        this.gradeAverageThirdYear = gradeAverageThirdYear;
        this.gradeAverageFourthYear = gradeAverageFourthYear;
    }

    public static void main(String[] args) {
        Student student_1 = new Student("Andrei", 29, "This student graduated, has all grades not null.", 6.5, 6.5, 6.5, 6.5);
        Student student_2 = new Student("Andreea", 29, "This student only graduated first year.", 7.5, null, null, null);
        Student student_3 = StudentBuilder.createInstance().name("Andreea").age(29)
                .description("This student only graduated first year.")
                .gradeAverageFirstYear(7.5)
                .build();
        Student student_4 = StudentBuilder.createInstance().name("Sandor").age(23).build();
        Student student_5 = StudentBuilder.createInstance().description("Student la contabilitate").build();

    }
}
