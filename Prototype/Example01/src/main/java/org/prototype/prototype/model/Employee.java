package org.prototype.prototype.model;

public class Employee extends Person {
    private final String position;

    public Employee(String firstname, String lastname, String position) {
        super(firstname, lastname);
        this.position = position;
    }

    public Employee(Employee employee) {
        super(employee);
        this.position = employee.position;
    }

    @Override
    public Person clone() {
        return new Employee(this);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + getId() +
                ", firstname='" + getFirstname() + '\'' +
                ", lastname='" + getLastname() + '\'' +
                ", position='" + position + '\'' +
                '}';
    }
}
