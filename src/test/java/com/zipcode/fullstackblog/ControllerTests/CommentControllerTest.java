package com.zipcode.fullstackblog.ControllerTests;

import com.zipcode.fullstackblog.models.Comment;
import com.zipcode.fullstackblog.controllers.CommentController;
import com.zipcode.fullstackblog.services.PostService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

@SpringBootTest
@AutoConfigureMockMvc
@RunWith(SpringRunner.class)



public class CommentControllerTest {

    @Autowired
    private MockMvc mvc;


    @MockBean
    private PostService repository;


    @Test
    public void getCommentTest() throws Exception {

        //given
        String expected = "This is my comment";
        Date CommentDate = null;
        try {

            CommentDate = new SimpleDateFormat("yyyy-MM-dd").parse("2019-04-09");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Comment newComment = new Comment();
        int givenId = 1;

        BDDMockito
                .given(repository.findById(givenId));

        String expectedContent = "{\"id\":1,\"body\":\"This is my comment\",\"creationDate\":\"2019-04-09T04:00:00.000+0000\",\"post\":null,\"user\":null}";
        this.mvc.perform(MockMvcRequestBuilders
                .get("/comments/" + givenId))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(expectedContent));
    }
}
