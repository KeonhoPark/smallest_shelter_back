package com.umc_sjs.smallestShelter.animal.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PostAnimalReq {
    private String name;
    private String age;
    private int organization;
    private int socialization;
    private int anxiety;
    private int train;
    private int bark;
    private int bite;
    private List<String> illness;
    private String mainImg;
    private String species;
}
