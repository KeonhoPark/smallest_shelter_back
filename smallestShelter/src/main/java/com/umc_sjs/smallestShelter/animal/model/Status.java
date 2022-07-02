package com.umc_sjs.smallestShelter.animal.model;

public enum Status {

    GOOD("완벽해요"),
    TRAINING("연습중이에요"),
    BAD("아직 부족해요");

    private final String value;

    Status(String value){
        this.value = value;

    }

    public String getValue(){
        return value;
    }
}
