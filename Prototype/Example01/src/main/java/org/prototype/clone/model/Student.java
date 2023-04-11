package org.prototype.clone.model;

public class Student extends Person implements Cloneable {
    private final int grade;

    public Student(String firstname, String lastname, int grade) {
        super(firstname, lastname);
        this.grade = grade;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
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
