package org.prototype.clone;

import org.prototype.clone.model.Employee;
import org.prototype.clone.model.Person;
import org.prototype.clone.model.Student;

public class App {
    public static void main(String[] args) throws CloneNotSupportedException {
        Person student = new Student("John", "Smith", 3);
        Person studentCopy = (Person) student.clone();

        System.out.println(student);
        System.out.println(studentCopy);

        Person employee = new Employee("Jean", "Smith", "Director");
        Person employeeCopy = (Person) employee.clone();

        System.out.println(employee);
        System.out.println(employeeCopy);
    }
}
