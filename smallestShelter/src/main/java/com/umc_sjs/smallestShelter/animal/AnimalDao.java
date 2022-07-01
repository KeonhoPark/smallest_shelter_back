package com.umc_sjs.smallestShelter.animal;

import com.umc_sjs.smallestShelter.model.GetAnimalRes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class AnimalDao {

    private JdbcTemplate jdbcTemplate;

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
