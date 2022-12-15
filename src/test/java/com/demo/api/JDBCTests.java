//package com.demo.api;
//
//import org.junit.jupiter.api.Test;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//
///*
//https://velog.io/@irriver/MariaDB-JDBC-Driver-%EC%84%A4%EC%B9%98-%EC%9C%A0%EB%8B%9B%ED%85%8C%EC%8A%A4%ED%8A%B8
// */
//public class JDBCTests {
//
//    static {
//        try {
//            Class.forName("org.mariadb.jdbc.Driver");
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    @Test
//    public void testConnection() {
//        try (Connection con =
//                     DriverManager.getConnection(
//                             "jdbc:mariadb://127.0.0.1:3306/demodb?user=root&password=osckorea!")) {
//            System.out.println(con);
//            if(con != null) {
//                System.out.println("DB Connection Success!");
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//}
