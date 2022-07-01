package com.umc_sjs.smallestShelter.animal.model;

public enum Gender {

    MEN("남자"),
    WOMEN("여자"),
    NEUTRALITY("중성");

    private final String value;

    Gender(String value){
        this.value = value;

    }

    public String getValue(){
        return value;
    }

}
