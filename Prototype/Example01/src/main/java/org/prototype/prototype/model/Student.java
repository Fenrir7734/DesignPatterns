package org.prototype.prototype.model;

public class Student extends Person {
    private final int grade;

    public Student(String firstname, String lastname, int grade) {
        super(firstname, lastname);
        this.grade = grade;
    }

    public Student(Student student) {
        super(student);
        this.grade = student.grade;
    }

    @Override
    public Person clone() {
        return new Student(this);
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + getId() +
                ", firstname='" + getFirstname() + '\'' +
                ", lastname='" + getLastname() + '\'' +
                ", grade=" + grade +
                '}';
    }
}
