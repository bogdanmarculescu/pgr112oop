package org.pgr112.lesson9.casting;

public class Main {
    public static void main(String[] args) {
        Parent p = new Child();
        if(p instanceof  AnotherChild){
            AnotherChild c = (AnotherChild)p;
            c.extraMethodAnotherInChild();
        } else if (p instanceof Child){
            Child c = (Child)p;
            c.extraMethodInChild();
        }
    }
}
