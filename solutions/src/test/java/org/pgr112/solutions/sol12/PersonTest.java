package org.pgr112.solutions.sol12;

import org.junit.jupiter.api.Test;
import org.pgr112.solutions.sol12.arv.Address;
import org.pgr112.solutions.sol12.arv.Person;
import org.pgr112.solutions.sol12.arv.Staff;
import org.pgr112.solutions.sol12.arv.Student;

public class PersonTest {

    @Test
    public void testPerson(){
        Address address = new Address("Drammensveien 1", "0102", "Norge");
        Person personStaff = new Staff("Anders", "Andersen", 33, address, 50000);
        Person personStudent = new Student("Ole", "Olsen", 24);

        System.out.println(personStaff.toString());
        System.out.println(personStudent.toString());

        Staff staff = (Staff)personStaff;
        System.out.println("Lønn, staff:"+staff.getSalary());
        staff.setSalary(60000);System.out.println("Lønn, staff, oppjustert:"+staff.getSalary());
    }
}
