package com.zipcode.fullstackblog.ServiceTests;

import com.zipcode.fullstackblog.models.Comment;
import com.zipcode.fullstackblog.repositories.CommentRepository;
import com.zipcode.fullstackblog.services.CommentService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class CommentServiceTest {
    @Autowired
    private CommentService commentService;

    @MockBean
    private CommentRepository commentRepository;

    @Test
    @DisplayName("Test findById Success")
    public void tetFindByIdSuccess() {

        // Set up mock object and repository
        Comment mockComment = new Comment();
        doReturn(Optional.of(mockComment)).when(commentRepository).findById(1L);

        // Execute call
        Optional<Comment> returnComment = commentService.findById(1);

        // Check assertions
        Assertions.assertTrue(returnComment.isPresent(), "No Comment was found when there should be");
        Assertions.assertSame(returnComment.get(), mockComment, "Models dont match up");
    }

    @Test
    @DisplayName("Test findById Fail")
    public void testFindByIdFail() {

        // Set up mock repository
        doReturn(Optional.empty()).when(commentRepository).findById(1L);

        //execute the service call
        Optional<Comment> returnUser = commentService.findById(1L);

        // Check assertions
        Assertions.assertFalse(returnUser.isPresent(), "User was found, when it should't be");
    }
    @Test
    @DisplayName("Test save product")
    public void testSave(){
        Comment mockComment = new Comment();
        doReturn(mockComment).when(commentRepository).save(any());

        Comment returnUser = commentService.create(mockComment);

        Assertions.assertNotNull(returnUser, "The saved comment should not be null");
    }


}
