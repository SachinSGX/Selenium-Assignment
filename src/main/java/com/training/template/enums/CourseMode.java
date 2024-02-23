package com.training.template.enums;

public enum CourseMode {

    LIVE_CLASSES("Live Classes"), ON_DEMAND("On Demand");

    private String value;

    CourseMode(String locator) {
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
