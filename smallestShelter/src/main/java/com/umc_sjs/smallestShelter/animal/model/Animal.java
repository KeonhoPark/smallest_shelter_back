package com.umc_sjs.smallestShelter.animal.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class Animal {

    private String mainImgUrl;
    private String name;
    private String age;
//    private Organization organization;
//    private Status socialization;
//    private Status anxiety;
//    private Status train;
//    private Status bark;
//    private Status bite;
//    private Gender gender;
//    private String species;
//    private List<String> illness;
    private Organization organization;
    private Status socialization;
    private Status anxiety;
    private Status train;
    private Status bark;
    private Status bite;
    private Gender gender;
    private String species;

}
