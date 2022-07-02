package com.umc_sjs.smallestShelter.animal.model;

public enum Organization {

    GROUP("임보단체"),
    SINGLE("개인");

    private final String value;

    Organization(String value){
        this.value = value;

    }

    public String getValue(){
        return value;
    }
}
