package org.pgr112.lesson7;

public class ParentClass {
    protected String stringInParentClass;


    public ParentClass() {
        stringInParentClass = "Some dummy parent class value";
    }

    public ParentClass(String stringInParentClass) {
        this.stringInParentClass = stringInParentClass;
    }

    public String getStringInParentClass() {
        return stringInParentClass;
    }

    public void setStringInParentClass(String stringInParentClass) {
        this.stringInParentClass = stringInParentClass;
    }

    public void fantasticMethod(){
        System.out.println("This is a beautiful method originated in the Parent class!");
    }

    public void printState(){
        System.out.println("---------------");
        System.out.println("stringInParentClass:"+stringInParentClass);
    }

}
