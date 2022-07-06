package com.example.swcoaching.member;

import com.example.swcoaching.board.Board;
import com.example.swcoaching.board.BoardService;
import com.example.swcoaching.controller.BoardController;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static java.util.Collections.emptyList;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@WebMvcTest(BoardController.class)
class BoardControllerTest {

  @MockBean
  private BoardService boardService;
  @Autowired
  private MockMvc mockMvc;

  @DisplayName("게시판 정보를 조회 테스트 한다")
  @Test
  void testBoard() throws Exception {
    // given
    long id = 1L;
    String title = "test";
    String remark = "test1";
    when(boardService.findById(id)).thenReturn(new Board(id, title, remark, emptyList()));

    // when
    ResultActions resultActions = mockMvc.perform(get("/board/{boardId}", id)).andDo(print());

    // then
    resultActions
            .andExpect(jsonPath("$.id").value(is((int) id)))
            .andExpect(jsonPath("$.title").value(is(title)))
            .andExpect(jsonPath("$.remark").value(is(remark)));
  }
}