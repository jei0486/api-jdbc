package com.demo.api.persistence

import org.apache.commons.lang.StringUtils
import org.springframework.util.Assert

public class ProductSqls {


    private static String notEmpty(String param, String condition) {
        return StringUtils.isEmpty(param)? null: condition;
    }

    private static String whereAnd(String ... conditions) {
        List<String> finalCond = conditions.findAll({it != null});
        Assert.notEmpty(finalCond);
        return "WHERE " + finalCond.join("\nAND ");
    }

}
