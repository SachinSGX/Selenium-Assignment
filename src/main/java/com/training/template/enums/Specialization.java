package com.training.template.enums;

public enum Specialization {

    INTERNETOFTHINGS("Internet of Things"), COMPUTERARCHITECTURE("Computer Architecture"), CYBERSECURITY("Cybersecurity");

    private String value;

    Specialization(String locator) {
        this.value = locator;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return this.getValue();
    }
}
