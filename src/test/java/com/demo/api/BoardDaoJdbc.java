//package com.demo.api;
//
//import com.demo.api.domain.Board;
//
//import java.sql.*;
//import java.time.LocalDateTime;
//
//// JDBC를 사용한 Java Application(DAO)
//public class BoardDaoJdbc {
//
//
//    public Connection getConnection() {
//        Connection con = null;
//
//        String server = "127.0.0.1:3306"; // mariaDB 서버 주소
//        String database = "demodb"; // mariaDB DATABASE 이름
//        String option = "?characterEncoding=UTF-8";
//        String userName = "root"; //  mariaDB  아이디
//        String password = "osckorea!"; // mariaDB  비밀번호
//
//        // 드라이버 로딩
//        try {
//            Class.forName("org.mariadb.jdbc.Driver");
//        } catch (ClassNotFoundException e) {
//            System.err.println(" !! JDBC Driver load 오류: " + e.getMessage());
//        }
//
//        // 드라이버 연결
//        try {
//            con = DriverManager.getConnection("jdbc:mariadb://localhost:3306/demodb?characterEncoding=UTF-8", userName, password);
//            System.out.println("정상적으로 연결되었습니다.");
//        } catch (SQLException e) {
//            System.err.println("연결 오류:" + e.getMessage());
//            closeConnection(con);
//        }
//        return con;
//    }
//
//    // 드라이버 연결해제
//    public void closeConnection(Connection con) {
//        try {
//            if (con != null)
//                con.close();
//        } catch (SQLException e) {
//            System.err.println("con 오류:" + e.getMessage());
//        }
//    }
//
//    // Create Read Update Delete ....
//    public void addBoard(Board board){
//
//        Connection connection = null;
//        try {
//            connection = getConnection();
//            String query = "INSERT INTO BOARD (SUBJECT , CONTENT ,HITS , CREATED_ID , CREATED_AT) VALUES (?, ?, ? , ? ,?)";
//            PreparedStatement pstmt = connection.prepareStatement(query);
//            pstmt.setString(1, board.getSubject());
//            pstmt.setString(2, board.getContent());
//            pstmt.setInt(3, board.getHits());
//            pstmt.setDate(4, new java.sql.Date(System.currentTimeMillis()));
//            pstmt.executeUpdate();
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//          closeConnection(connection);
//        }
//    }
//
//    public Board selectBoard(int seq){
//        Connection connection = null;
//        Board board = null;
//        try {
//            connection = getConnection();
//            String query = "SELECT SEQ , SUBJECT , CONTENT , HITS , CREATED_ID , CREATED_AT FROM BOARD";
//            Statement stmt = connection.createStatement();
//            ResultSet rs = stmt.executeQuery(query);
//            while (rs.next()){
//                board.setSeq(rs.getLong("SEQ"));
//                board.setSubject(rs.getString("SUBJECT"));
//                board.setContent(rs.getString("CONTENT"));
//                board.setHits(rs.getInt("HITS"));
//                board.setCreatedId(rs.getString("CREATED_ID"));
//                board.setCreatedAt(LocalDateTime.from(rs.getDate("CREATED_AT").toLocalDate()));
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            closeConnection(connection);
//        }
//        return board;
//    }
//}
