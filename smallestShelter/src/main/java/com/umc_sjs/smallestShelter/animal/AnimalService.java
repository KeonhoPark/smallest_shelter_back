package com.umc_sjs.smallestShelter.animal;

import com.umc_sjs.smallestShelter.animal.model.GetDetailRes;
import org.springframework.stereotype.Service;

@Service
public class AnimalService {

    private final AnimalDao animalDao;

    public AnimalService(AnimalDao animalDao) {
        this.animalDao = animalDao;
    }

    public GetDetailRes retrieveAnimalDetail(int anmIdx) {

        if (checkAnimalExist(anmIdx) == 0) {
            throw new RuntimeException("존재하지 않는 동물 입니다.");
        }

        try{
            GetDetailRes getDetailRes = animalDao.selectAnimalDetail(anmIdx);
            System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!Service" + getDetailRes);

            return getDetailRes;
        }
        catch (Exception exception) {
            return null;
        }
    }

    public int checkAnimalExist(int anmIdx) {
        try{
            return animalDao.checkAnimalExist(anmIdx);
        } catch (Exception exception){
            throw null;
        }
    }
}
