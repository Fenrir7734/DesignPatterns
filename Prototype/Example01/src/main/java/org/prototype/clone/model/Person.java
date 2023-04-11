package org.prototype.clone.model;

import java.util.concurrent.atomic.AtomicLong;

public abstract class Person implements Cloneable {
    private static final AtomicLong count = new AtomicLong(1);

    private final long id;
    private final String firstname;
    private final String lastname;

    protected Person(String firstname, String lastname) {
        this.id = count.getAndIncrement();
        this.firstname = firstname;
        this.lastname = lastname;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

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
