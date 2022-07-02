package com.umc_sjs.smallestShelter.animal.model;

public enum Gender {

    MALE("수컷"),
    FEMALE("암컷"),
    NEUTRALITY("중성");

    private final String value;

    Gender(String value){
        this.value = value;

    }

    public String getValue(){
        return value;
    }

}
