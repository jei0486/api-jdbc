//package com.demo.api;
//
//
//import com.demo.api.domain.Board;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import static org.assertj.core.api.Assertions.assertThat;
//
//@SpringBootTest
//public class BoardDaoJdbcTest {
//
//    private final Board dummyBoard = Board.builder()
//            .subject("test subject")
//            .content("test content")
//            .hits(0)
//            .createdId("admin")
//            .build();
//
//
//    @Autowired
//    private BoardDaoJdbc boardDaoJdbc;
//
//    @Test
//    public void insert(){
//
//        // given
//        Board board = this.dummyBoard;
//
//        this.boardDaoJdbc.addBoard(board);
//
//        // when
//        Board board2 = this.boardDaoJdbc.selectBoard(25);
//
//        // then
//        assertThat(board).isSameAs(board2);
//
//    }
//}
