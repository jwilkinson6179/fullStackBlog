package com.zipcode.fullstackblog.ControllerTests;


import com.zipcode.fullstackblog.controllers.PostController;
import com.zipcode.fullstackblog.models.Post;
import com.zipcode.fullstackblog.repositories.PostRepository;
import com.zipcode.fullstackblog.services.PostService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.cloud.cloudfoundry.com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Optional;




@RunWith(SpringRunner.class)
@WebMvcTest(PostController.class)
public class PostControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private PostService postService;

    @InjectMocks
    PostController postController;

    @MockBean
    Post testPost;

    @Before
    public void setUp() throws Exception {
        testPost = new Post("sample header", "sample author","sample text","sample img");
        testPost.setId(1L);

    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void createPost() throws Exception {
        mvc.perform(MockMvcRequestBuilders
                .post ("/posts")
                .content(asJsonString(new Post("sample header", "sample author","sample text","sample img")))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
        ;
        verify(postService,times(1)).create(any(Post.class));
    }

    public static String asJsonString(final Object obj){
        try{
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e){
            throw new RuntimeException(e);
        }
    }


}
