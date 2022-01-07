package org.pgr112.lesson8.beginnersbook;

public class Student {
    int rollNum;
    String studentName;
    //Creating HAS-A relationship with Address class
    Address studentAddr;
    Student(int roll, String name, Address addr){
        this.rollNum=roll;
        this.studentName=name;
        this.studentAddr = addr;
    }

    @Override
    public String toString() {
        return "Student{" +
                "rollNum=" + rollNum +
                ", studentName='" + studentName + '\'' +
                ", studentAddr=" + studentAddr +
                '}';
    }
}
