package org.spring.tutorial.examples.core.beans;

public class SomeBean {
    private int someValue;

    public SomeBean(int someValue) {
        this.someValue = someValue;
    }

    public int getSomeValue() {
        return someValue;
    }

    public void setSomeValue(int someValue) {
        this.someValue = someValue;
    }
}