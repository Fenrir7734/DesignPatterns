package org.prototype.prototype;

import org.prototype.prototype.model.Employee;
import org.prototype.prototype.model.Person;
import org.prototype.prototype.model.Student;

public class App {
    public static void main(String[] args) {
        Person student = new Student("John", "Smith", 3);
        Person studentCopy = student.clone();

        System.out.println(student);
        System.out.println(studentCopy);

        Person employee = new Employee("Jean", "Smith", "Director");
        Person employeeCopy = employee.clone();

        System.out.println(employee);
        System.out.println(employeeCopy);
    }
}
