package org.dungmd.springaop.model;

public class Circle {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        System.out.println("Circle setName called: " + name);
        throw (new RuntimeException("Circle set throwing"));
    }

    public String setNameAndReturn(String name) {
        this.name = name;
        System.out.println("Circle setNameAndReturn called: " + name);
        return name + " modified";
    }
}
