package com.umc_sjs.smallestShelter.animal;

import com.umc_sjs.smallestShelter.model.GetAnimalRes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnimalService {

    private final AnimalDao animalDao;

    @Autowired
    public AnimalService(AnimalDao animalDao) {
        this.animalDao = animalDao;
    }


    /**
     * 바로 Dao를 호출한다.
     * Dao에서 받은 List<GetAnimalRes> 반환
     * @return List<GetAnimalRes>
     */
    public List<GetAnimalRes> retrieveAnimals(){
        List<GetAnimalRes> animalResList = animalDao.selectAnimals();
        return animalResList;
    }
}
