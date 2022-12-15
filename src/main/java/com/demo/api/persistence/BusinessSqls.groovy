package com.demo.api.persistence

import com.demo.api.domain.Business
import org.apache.commons.lang.StringUtils
import org.springframework.util.Assert

public class BusinessSqls {

    public static final String SELECT_BY_ID = """ 
        SELECT id , name  , description , phone , email , address 
        FROM business
            WHERE id = :id
    """;

    public static final String SELECT_BY_ID_LIST = """ 
        SELECT id , name , description , phone , email , address
        FROM business
            WHERE id IN (:idList)
    """;

    public static final String UPDATE = """ 
        UPDATE business \n
        SET name = :name ,
            description = :description ,
            phone = :phone ,
            email = :email ,
            address = :address,
        WHERE id = :id
    """;


    public static final String DELETE_BY_ID = """
        DELETE FROM business
        WHERE  id = :id
    """;

    public static final String selectByCondition(Business business) {
        return """
			SELECT id , name , description , phone , email , address
			FROM business
			""" +
                whereAnd (
                        notEmpty(business.getName(), "name = :name"),
                        notEmpty(business.getAddress(), "address = :address"),
                        notEmpty(business.getPhone(), "phone = :phone")
                );
    }

    private static String notEmpty(String param, String condition) {
        return StringUtils.isEmpty(param)? null: condition;
    }

    private static String whereAnd(String ... conditions) {
        List<String> finalCond = conditions.findAll({it != null});
        Assert.notEmpty(finalCond);
        return "WHERE " + finalCond.join("\nAND ");
    }

}
