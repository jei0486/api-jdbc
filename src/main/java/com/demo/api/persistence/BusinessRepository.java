package com.demo.api.persistence;

import com.demo.api.domain.Business;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.jdbc.core.simple.SimpleJdbcInsertOperations;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@Repository
public class BusinessRepository {
    private NamedParameterJdbcOperations db;

    private SimpleJdbcInsertOperations businessInsertion;

    private RowMapper<Business> businessMapper = BeanPropertyRowMapper.newInstance(Business.class);

    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");


//    private RowMapper<Product> productMapper =  (rs, rowNum) -> {
//        Product product = new Product();
//        product.setId(rs.getInt("product_id")); // 필수값
//        product.setName(rs.getString("product_name"));
//        product.setPrice(rs.getLong("price"));
//        product.setDescription(rs.getString("desc"));
//        LocalDateTime createdAt = LocalDateTime.parse(rs.getString("created_at"), formatter);
//        product.setCreatedAt(createdAt);
//        return product;
//    };

    @Autowired
    public BusinessRepository(DataSource dataSource){
        this.db = new NamedParameterJdbcTemplate(dataSource);
        this.businessInsertion = new SimpleJdbcInsert(dataSource)
                .withTableName("business")
                .usingGeneratedKeyColumns("id");
    }

    public Integer create(Business business){
        SqlParameterSource params = new BeanPropertySqlParameterSource(business);
        return businessInsertion.executeAndReturnKey(params).intValue();
    }

    public Business findById(Integer id){
        Map<String,Integer> params = Collections.singletonMap("id",id);
        return db.queryForObject(BusinessSqls.SELECT_BY_ID,params,businessMapper);
    }

    public List<Business> findByIdList(List<Integer> idList){
        Map<String,Object> params = Collections.singletonMap("idList",idList);
        return db.query(BusinessSqls.SELECT_BY_ID_LIST,params,businessMapper);
    }

//    public Business findByIdWithProduct(Integer id){
//        Map<String,Object> params = Collections.singletonMap("id",id);
//        ResultSetExtractor<List<Business>> extractor =
//    }

    public List<Business> findBy (Business condition){
        SqlParameterSource params = new BeanPropertySqlParameterSource(condition);
        String sql = BusinessSqls.selectByCondition(condition);
        return db.query(sql,params,businessMapper);
    }

    public boolean update(Business business){
        SqlParameterSource params = new BeanPropertySqlParameterSource(business);
        int affected = db.update(BusinessSqls.UPDATE,params);
        return affected == 1;
    }

    public boolean delete(Integer id){
        Map<String,Integer> params = Collections.singletonMap("id",id);
        int affected = db.update(BusinessSqls.DELETE_BY_ID,params);
        return affected == 1;
    }

}
