package org.pgr112.solutions.sol12.arv;

public class Staff extends Person implements Payable{

    private double salary;

    public Staff(){}

    public Staff(String firstName, String lastName) {
        super(firstName, lastName);
    }

    public Staff(String firstName, String lastName, int age) {
        super(firstName, lastName, age);
    }

    public Staff(String firstName, String lastName, int age, double salary) {
        super(firstName, lastName, age);
        this.salary = salary;
    }

    public Staff(String firstName, String lastName, int age, Address address, double salary) {
        super(firstName, lastName, age, address);
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Staff: " + getFirstName() + ", " + getLastName() + ", " + getAge() + ", " + getSalary()
                + (getAddress()!=null ? getAddress().toString() : "");
    }

    @Override
    public double getPayment() {
        return salary*12;
    }
}
