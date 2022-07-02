package com.umc_sjs.smallestShelter.animal.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class GetDetailRes {

    private Animal animal;
    private List<String> imgList;
    private List<String> illness;

   /* private String organization;
    private String socialization;
    private String anxiety;
    private String train;
    private String bark;
    private String bite;
    private String gender;
    private String species;
    private String illness;
    private List<String>*/
}
