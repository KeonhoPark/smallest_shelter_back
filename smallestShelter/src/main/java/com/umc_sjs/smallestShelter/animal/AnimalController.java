package com.umc_sjs.smallestShelter.animal;

import com.umc_sjs.smallestShelter.animal.model.GetDetailRes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AnimalController {

    @Autowired
    private final AnimalService animalService;

    public AnimalController(AnimalService animalService) {
        this.animalService = animalService;
    }

    @ResponseBody
    @GetMapping("/animal/{anmIdx}") // http://localhost:8080/animal/{anmIdx}
    public GetDetailRes getAnimalDetail(@PathVariable int anmIdx) {
        try{
            GetDetailRes getDetailRes = animalService.retrieveAnimalDetail(anmIdx);
            return getDetailRes;
        } catch(Exception e){
            return null;
        }
    }
}
