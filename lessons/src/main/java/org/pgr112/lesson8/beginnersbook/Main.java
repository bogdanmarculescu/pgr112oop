package org.pgr112.lesson8.beginnersbook;

public class Main {
    public static void main(String args[]){
        Address a1 = new Address("Kirkegata 24", 0107,
                "Oslo", "Oslo", "Norge");
        Address a2 = new Address("Liksomveien 2", 5007,
                "Bergen", "Vestland", "Norge");
        Address a3 = new Address("Greverudveien 99", 1415,
                "Oppegård", "Viken", "Norge");
        Student student = new Student(123, "Hans Hansen", a2);
        Staff staff = new Staff("Frode Foreleser", a3);
        College college = new College("Høyskolen Kristiania", a1);

        System.out.printf("Student: %s%n", student);
        System.out.printf("Staff: %s%n", staff);
        System.out.printf("college: %s%n", college);
    }
}
