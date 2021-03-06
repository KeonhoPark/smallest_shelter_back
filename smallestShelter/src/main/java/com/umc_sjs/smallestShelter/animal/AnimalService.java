package com.umc_sjs.smallestShelter.animal;

import com.umc_sjs.smallestShelter.animal.model.GetDetailRes;
import com.umc_sjs.smallestShelter.animal.model.PostAnimalReq;
import com.umc_sjs.smallestShelter.animal.model.PostAnimalRes;
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

    public GetDetailRes retrieveAnimalDetail(int anmIdx) {

        if (checkAnimalExist(anmIdx) == 0) {
            throw new RuntimeException("존재하지 않는 동물 입니다.");
        }

        try{
            GetDetailRes getDetailRes = animalDao.selectAnimalDetail(anmIdx);
            System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!Service" + getDetailRes);

            System.out.println("getDetailRes = " + getDetailRes);
            return getDetailRes;
        }
        catch (Exception exception) {
            System.out.println("AnimalService.retrieveAnimalDetail");
            System.out.println("exception = " + exception);
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
    

    /**
     * 바로 Dao를 호출한다.
     * Dao에서 받은 List<GetAnimalRes> 반환
     * @return List<GetAnimalRes>
     */
    public List<GetAnimalRes> retrieveAnimals(){
        List<GetAnimalRes> animalResList = animalDao.selectAnimals();
        return animalResList;
    }

    //동물 정보 등록
    public PostAnimalRes insertAnimal(PostAnimalReq postAnimalReq){
        try{
            return animalDao.insertAnimal(postAnimalReq);
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
