package com.demo.api.persistence;

import com.demo.api.domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.jdbc.core.simple.SimpleJdbcInsertOperations;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.time.format.DateTimeFormatter;

@Repository
public class ProductRepository {

    private NamedParameterJdbcOperations db;

    private SimpleJdbcInsertOperations productInsertion;

    private RowMapper<Product> productMapper = BeanPropertyRowMapper.newInstance(Product.class);

    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");


    @Autowired
    public ProductRepository(DataSource dataSource){
        this.db = new NamedParameterJdbcTemplate(dataSource);
        this.productInsertion = new SimpleJdbcInsert(dataSource)
                .withTableName("product")
                .usingGeneratedKeyColumns("id");
    }
}
