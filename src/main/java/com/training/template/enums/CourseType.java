package com.training.template.enums;

public enum CourseType {

    SHORT_COURSE("Short Course"), WORKSHOP("Workshop"), COURSE("Course");

    private String value;

    CourseType(String locator) {
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
