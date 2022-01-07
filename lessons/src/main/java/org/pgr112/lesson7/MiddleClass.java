package org.pgr112.lesson7;

public class MiddleClass extends ParentClass{
    protected String stringInMiddleClass;

    public MiddleClass() {
        super();
        this.stringInMiddleClass = "Some dummy middle class value";
    }

    public MiddleClass(String stringInMiddleClass) {
        super();
        this.stringInMiddleClass = stringInMiddleClass;
    }

    public MiddleClass(String stringInParentClass, String stringInMiddleClass) {
        super(stringInParentClass);
        this.stringInMiddleClass = stringInMiddleClass;
    }

    public String getStringInMiddleClass() {
        return stringInMiddleClass;
    }

    public void setStringInMiddleClass(String stringInMiddleClass) {
        this.stringInMiddleClass = stringInMiddleClass;
    }

    @Override
    public void printState(){
        super.printState();
        System.out.println("stringInMiddleClass:"+stringInMiddleClass);
    }

}
