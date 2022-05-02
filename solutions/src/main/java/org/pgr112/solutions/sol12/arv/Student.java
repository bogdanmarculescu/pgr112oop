package org.pgr112.solutions.sol12.arv;

public class Student extends Person {

    public Student() {}

    public Student(String firstName, String lastName) {
        super(firstName, lastName);
    }

    public Student(String firstName, String lastName, int age) {
        super(firstName, lastName, age);
    }

    @Override
    public String toString() {
        return "Student: " + getFirstName() + ", " + getLastName() + ", " + getAge();
    }

}
