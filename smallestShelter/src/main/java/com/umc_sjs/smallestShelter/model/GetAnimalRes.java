package com.umc_sjs.smallestShelter.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
public class GetAnimalRes {

    private String imgUrl;
    private String name;
    private String gender;
    private String age;
    private String species;
}
