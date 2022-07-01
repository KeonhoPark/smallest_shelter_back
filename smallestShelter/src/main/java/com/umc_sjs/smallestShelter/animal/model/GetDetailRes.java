package com.umc_sjs.smallestShelter.animal.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class GetDetailRes {

    private Animal detail;
    private List<Img> imgList;
}
