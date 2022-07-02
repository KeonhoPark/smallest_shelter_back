package com.umc_sjs.smallestShelter.animal;

import com.umc_sjs.smallestShelter.animal.model.Animal;
import com.umc_sjs.smallestShelter.animal.model.GetDetailRes;
import com.umc_sjs.smallestShelter.animal.model.Img;
import com.umc_sjs.smallestShelter.model.GetAnimalRes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
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

    public GetDetailRes selectAnimalDetail(int idx){
        String selectPostsQuery = "SELECT mainImgUrl, name, age, organization, socialization, anxiety, train, bark, bite, gender, species, illness from animal where anmIdx = ?;";
        int selectGetsParam = idx;
        // 객체는 queryForObject, 리스트 형태는 query
        return this.jdbcTemplate.queryForObject(selectPostsQuery,
                (rs,rowNum) -> new GetDetailRes(
                        detail = this.jdbcTemplate.queryForObject("SELECT mainImgUrl, name, age, organization, socialization, anxiety, train, bark, bite, gender, species, illness from animal where anmIdx = ?;",
                                (rk1, rowNum1) -> new Animal(
                                        rk1.getString("mainImgUrl"),
                                        rk1.getString("name"),
                                        rk1.getString("age"),
                                        rk1.getString("organization"),
                                        rk1.getString("socialization"),
                                        rk1.getString("anxiety"),
                                        rk1.getString("train"),
                                        rk1.getString("bark"),
                                        rk1.getString("bite"),
                                        rk1.getString("gender"),
                                        rk1.getString("species"),
                                        rk1.getString("illness")
                                ), rs.getInt("idx") // 파라미터 자리 = ? 안에 들어갈 것
                        ),
                        imgList = this.jdbcTemplate.query("SELECT imgUrl from image where anmIdx = ?;",
                                (rk2, rowNum2) -> new Img(
                                        rk2.getString("imgUrl")
                                ), rs.getInt("idx") // 파라미터 자리 = ? 안에 들어갈 것
                        )
                ), selectGetsParam);
    }

    public int checkAnimalExist(int anmIdx){
        String checkUserExistQuery = "select exists(select anmIdx from animal where anmIdx = ?)";
        int checkUserExistParams = anmIdx;
        return this.jdbcTemplate.queryForObject(checkUserExistQuery,
                int.class,
                checkUserExistParams);

    }
    @Autowired
    public void setDataSource(DataSource dataSource){
        this.jdbcTemplate = new JdbcTemplate(dataSource);
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
