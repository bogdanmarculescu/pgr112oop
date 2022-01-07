package org.pgr112.lesson8.beginnersbook;

public class College {
    String collegeName;
    //Creating HAS-A relationship with Address class
    Address collegeAddr;
    College(String name, Address addr){
        this.collegeName = name;
        this.collegeAddr = addr;
    }

    @Override
    public String toString() {
        return "College{" +
                "collegeName='" + collegeName + '\'' +
                ", collegeAddr=" + collegeAddr +
                '}';
    }
}
