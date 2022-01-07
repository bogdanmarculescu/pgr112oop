package org.pgr112.lesson8.beginnersbook;

public class Staff {
    String employeeName;
    //Creating HAS-A relationship with Address class
    Address employeeAddr;
    Staff(String name, Address addr){
        this.employeeName = name;
        this.employeeAddr = addr;
    }

    @Override
    public String toString() {
        return "Staff{" +
                "employeeName='" + employeeName + '\'' +
                ", employeeAddr=" + employeeAddr +
                '}';
    }
}
