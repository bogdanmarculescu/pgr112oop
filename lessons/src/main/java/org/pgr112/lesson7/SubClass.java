package org.pgr112.lesson7;

public class SubClass extends MiddleClass {
    private String stringInSubClass;

    public SubClass(){
        super();
        stringInSubClass = "Some dummy sub class value";
    }

    public SubClass(String stringInSubClass) {
        super();
        this.stringInSubClass = stringInSubClass;
    }

    public SubClass(String stringInMiddleClass, String stringInSubClass) {
        super(stringInMiddleClass);
        this.stringInSubClass = stringInSubClass;
    }

    public SubClass(String stringInParentClass, String stringInMiddleClass, String stringInSubClass) {
        super(stringInParentClass, stringInMiddleClass);
        this.stringInSubClass = stringInSubClass;
    }

    public void printSubClassState(){
        System.out.println("---------------");
        System.out.println("stringInParentClass:"+stringInParentClass);
        System.out.println("stringInMiddleClass:"+stringInMiddleClass);
        System.out.println("stringInSubClass:"+stringInSubClass);
    }

}
