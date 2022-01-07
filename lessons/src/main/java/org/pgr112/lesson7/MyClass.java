package org.pgr112.lesson7;

public class MyClass {
    private static int staticValue = 0;
    private int objectValue = 0;

    public MyClass(int value){
        objectValue = value;
    }

    public int getObjectValue() {
        return objectValue;
    }

    public void setObjectValue(int objectValue) {
        this.objectValue = objectValue;
    }

    public static int getStaticValue() {
        return staticValue;
    }

    public static void setStaticValue(int staticValue) {
        MyClass.staticValue = staticValue;
    }

    public int getSum(){
        return staticValue + objectValue;
    }
}
