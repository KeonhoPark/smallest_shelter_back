package com.umc_sjs.smallestShelter.animal;

import com.umc_sjs.smallestShelter.animal.model.*;
import com.umc_sjs.smallestShelter.model.GetAnimalRes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Repository
public class AnimalDao {

    private JdbcTemplate jdbcTemplate;

    private Animal detail;
    private List<Img> imgList;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    /*public GetDetailRes selectAnimalDetail(int animalIndex) {
        GetDetailRes getDetailRes = new GetDetailRes()
        String getAnimalQuery = "select name, age, socialization, anxiety, train, bark, bite, mainImgUrl, gender, species, organization\n" +
                "from animal where anmIdx = ?";
        int index = animalIndex;
        Animal animal = this.jdbcTemplate.queryForObject(getAnimalQuery,
                (rs, rowNum) -> new Animal(
                        rs.getString("mainImgUrl"),
                        rs.getString("name"),
                        rs.getString("age"),
                        Organization.valueOf(rs.getString("organization")),
                        Status.valueOf(rs.getString("socialization")),
                        Status.valueOf(rs.getString("anxiety")),
                        Status.valueOf(rs.getString("train")),
                        Status.valueOf(rs.getString("bark")),
                        Status.valueOf(rs.getString("bite")),
                        Gender.valueOf(rs.getString("gender")),
                        rs.getString("species")),
                index);
        
    }*/

    public GetDetailRes selectAnimalDetail(int animalIndex) {
        Animal animalModel = getAnimalModel(animalIndex);
        List<String> imgList = getImgList(animalIndex);
        List<String> illnessList = getIllnessList(animalIndex);

        return new GetDetailRes(animalModel, imgList, illnessList);

    }

    public Animal getAnimalModel(int animalIndex){
        String getAnimalQuery = "select name, age, socialization, anxiety, train, bark, bite, mainImgUrl, gender, species, organization\n" +
                "from animal where anmIdx = ?";
        int index = animalIndex;
        return this.jdbcTemplate.queryForObject(getAnimalQuery,
                (rs, rowNum) -> new Animal(
                        rs.getString("mainImgUrl"),
                        rs.getString("name"),
                        rs.getString("age"),
                        Organization.valueOf(rs.getString("organization")),
                        Status.valueOf(rs.getString("socialization")),
                        Status.valueOf(rs.getString("anxiety")),
                        Status.valueOf(rs.getString("train")),
                        Status.valueOf(rs.getString("bark")),
                        Status.valueOf(rs.getString("bite")),
                        Gender.valueOf(rs.getString("gender")),
                        rs.getString("species")),
                index);
    }

    public List<String> getImgList(int animalIndex){
        String getImagesQuery = "select imgUrl from image where anmIdx = ?";
        int index = animalIndex;
        List<String> imgUrlList = new ArrayList<>();

        List<Img> imgList = this.jdbcTemplate.query(getImagesQuery,
                (rs, rowNum) -> new Img(
                        rs.getString("imgUrl")), index);

        for (Img img : imgList) {
            imgUrlList.add(img.getImgUrl());
        }
        return imgUrlList;
    }

    public List<String> getIllnessList(int animalIndex){
        String getIllnessQuery = "select anmIdx, illnessName from illness where anmIdx = ?";
        int index = animalIndex;
        List<String> illnessNameList = new ArrayList<>();

        List<Illness> illnessList = this.jdbcTemplate.query(getIllnessQuery,
                (rs, rowNum) -> new Illness(
                        rs.getInt("anmIdx"),
                        rs.getString("illnessName")), index);

        for (Illness illness : illnessList) {
            illnessNameList.add(illness.getIllness());
        }
        return illnessNameList;
    }

    public Animal getAnimal(int animalIndex){
        String getAnimalQuery = "select name, age, socialization, anxiety, train, bark, bite, mainImgUrl, gender, species, organization\n" +
                "from animal where anmIdx = ?";
        int index = animalIndex;
        return this.jdbcTemplate.queryForObject(getAnimalQuery,
                (rs, rowNum) -> new Animal(
                        rs.getString("mainImgUrl"),
                        rs.getString("name"),
                        rs.getString("age"),
                        Organization.valueOf(rs.getString("organization")),
                        Status.valueOf(rs.getString("socialization")),
                        Status.valueOf(rs.getString("anxiety")),
                        Status.valueOf(rs.getString("train")),
                        Status.valueOf(rs.getString("bark")),
                        Status.valueOf(rs.getString("bite")),
                        Gender.valueOf(rs.getString("gender")),
                        rs.getString("species")),
                index);
    }


    public int checkAnimalExist(int anmIdx){
        String checkUserExistQuery = "select exists(select anmIdx from animal where anmIdx = ?)";
        int checkUserExistParams = anmIdx;
        return this.jdbcTemplate.queryForObject(checkUserExistQuery,
                int.class,
                checkUserExistParams);

    }

    /**
     * selectAnimalQuery 쿼리문을 이용하여 jdbc 템플릿을 통해 GetAnimalRes 모델에 데이터 넣어짐
     * 람다식을 사용하여 반복적으로 테이블의 객체를 getString() 메소드로 변환 후 모델로 넣는것 같음
     * @return List<GetAnimalRes>
     */
    public List<GetAnimalRes> selectAnimals(){
        String selectAnimalQuery = "SELECT mainImgUrl, name, gender, age, species\n" +
                "FROM animal";

        return this.jdbcTemplate.query(selectAnimalQuery,
                (rs,rowNum) -> new GetAnimalRes(
                        rs.getString("mainImgUrl"),
                        rs.getString("name"),
                        rs.getString("gender"),
                        rs.getString("age"),
                        rs.getString("species"))
                );
    }

}
