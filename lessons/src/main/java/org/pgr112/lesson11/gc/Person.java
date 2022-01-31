package org.pgr112.lesson11.gc;

import java.util.Objects;

public class Person {
    private String name;
    public Person(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                '}';
    }

    @Override
    public int hashCode(){
        return Objects.hash(name);
    }
}
