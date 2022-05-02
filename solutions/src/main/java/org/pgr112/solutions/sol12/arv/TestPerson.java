package org.pgr112.solutions.sol12.arv;

public class TestPerson {
    public static void main(String[] args) {
        Address address = new Address("Drammensveien 1", "0102", "Norge");
        Person personStaff = new Staff("Anders", "Andersen", 33, address, 50000);
        Person personStudent = new Student("Ole", "Olsen", 24);

        System.out.println(personStaff.toString());
        System.out.println(personStudent.toString());

        Staff staff = (Staff)personStaff;
        System.out.println("Lønn, staff:"+staff.getSalary());
        staff.setSalary(60000);
        System.out.println("Lønn, staff, oppjustert:"+staff.getSalary());
    }
}
