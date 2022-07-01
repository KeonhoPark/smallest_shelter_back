package com.umc_sjs.smallestShelter.animal.model;

public enum Status {

    HIGH("완벽해요"),
    MIDDLE("연습중이에요"),
    LOW("아직 부족해요");

    private final String value;

    Status(String value){
        this.value = value;

    }

    public String getValue(){
        return value;
    }
}
