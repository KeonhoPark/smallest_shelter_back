package com.umc_sjs.smallestShelter.animal;

import com.umc_sjs.smallestShelter.animal.model.GetDetailRes;
import com.umc_sjs.smallestShelter.animal.model.PostAnimalReq;
import com.umc_sjs.smallestShelter.animal.model.PostAnimalRes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import com.umc_sjs.smallestShelter.model.GetAnimalRes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "http://hana-umc.shop")
@RestController
@RequestMapping("")
public class AnimalController {

    private final AnimalService animalService;

    @Autowired
    public AnimalController(AnimalService animalService) {
        this.animalService = animalService;
        System.out.println("빌드 성공");
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

    /**
     * 바로 서비스를 호출한다.
     * 서비스에서 받은 List<GetAnimalRes> 바로 반환
     * @return List<GetAnimalRes>
     */
    @GetMapping("/list")
    public List<GetAnimalRes> getAnimals(){
        System.out.println("목록 리스트 출력");
        List<GetAnimalRes> animalResList = animalService.retrieveAnimals();
        return animalResList;
    }

    /*
        test api
        스트링 문자열 하나 리턴됨.
     */

    @ResponseBody
    @PostMapping("/test")
    public String test(){
        System.out.println("테스트 요청 성공");
        return "hello umc sjs";
    }

    //동물 정보 등록
    @ResponseBody
    @PostMapping("/new")
    public PostAnimalRes createAnimal(@RequestBody PostAnimalReq postAnimalReq){
        try{
            System.out.println("동물 정보 등록");
            return animalService.insertAnimal(postAnimalReq);
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

}
