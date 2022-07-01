package com.umc_sjs.smallestShelter.animal;

import com.umc_sjs.smallestShelter.model.GetAnimalRes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("")
public class AnimalController {

    private final AnimalService animalService;

    @Autowired
    public AnimalController(AnimalService animalService) {
        this.animalService = animalService;
    }


    /**
     * 바로 서비스를 호출한다.
     * 서비스에서 받은 List<GetAnimalRes> 바로 반환
     * @return List<GetAnimalRes>
     */
    @GetMapping("/list")
    public List<GetAnimalRes> getAnimals(){
        List<GetAnimalRes> animalResList = animalService.retrieveAnimals();
        return animalResList;
    }

}
