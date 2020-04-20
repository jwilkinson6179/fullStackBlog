package com.zipcode.fullstackblog.ServiceTests;

import com.zipcode.fullstackblog.models.Board;
import com.zipcode.fullstackblog.models.Post;
import com.zipcode.fullstackblog.repositories.BoardRepository;
import com.zipcode.fullstackblog.repositories.PostRepository;
import com.zipcode.fullstackblog.services.BoardService;
import com.zipcode.fullstackblog.services.PostService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class BoardServiceTest {

    @Autowired
    private BoardService boardService;

    @MockBean
    private BoardRepository boardRepository;

    @Test
    @DisplayName("Test findById Success")
    public void testFindByIdSuccess() {

        // Set up mock object and repository
        Board mockBoard = new Board("Hello");
        doReturn(Optional.of(mockBoard)).when(boardRepository).findById(1L);

        // Execute call
        Optional<Board> returnTag = boardService.findById(1);

        // Check assertions
        Assertions.assertTrue(returnTag.isPresent(), "No Tag was found when there should be");
        Assertions.assertSame(returnTag.get(), mockBoard, "Models dont match up");
    }

    @Test
    @DisplayName("Test findById Fail")
    public void tetFindByIdFail() {

        // Set up mock repository
        doReturn(Optional.empty()).when(boardRepository).findById(1L);

        //execute the service call
        Optional<Board> returnCar = boardService.findById(1L);

        // Check assertions
        Assertions.assertFalse(returnCar.isPresent(), "Tag was found, when it should't be");
    }
    @Test
    @DisplayName("Test save product")
    public void testCreate(){
        Board mockBoard = new Board("Hello");
        doReturn(mockBoard).when(boardRepository).save(any());

        Board returnPost = boardService.create(mockBoard);

        Assertions.assertNotNull(returnPost, "The saved product should not be null");
    }

}
