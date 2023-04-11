package org.prototype.clone.model;

public class Employee extends Person implements Cloneable {
    private final String position;

    public Employee(String firstname, String lastname, String position) {
        super(firstname, lastname);
        this.position = position;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
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
