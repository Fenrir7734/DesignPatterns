package org.prototype.prototype.model;

import java.util.concurrent.atomic.AtomicLong;

public abstract class Person {
    private static final AtomicLong count = new AtomicLong(1);

    private final long id;
    private final String firstname;
    private final String lastname;

    protected Person(String firstname, String lastname) {
        this.id = count.getAndIncrement();
        this.firstname = firstname;
        this.lastname = lastname;
    }

    protected Person(Person person) {
        this.id = person.id;
        this.firstname = person.firstname;
        this.lastname = person.lastname;
    }

    public abstract Person clone();

    public long getId() {
        return id;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                '}';
    }
}
