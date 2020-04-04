package com.zipcode.fullstackblog.ControllerTests;


import com.fasterxml.jackson.databind.*;
import com.zipcode.fullstackblog.models.Post;
import com.zipcode.fullstackblog.repositories.PostRepository;
import com.zipcode.fullstackblog.services.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.*;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class PostControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private PostService repository;

    @Test
    public void testCreate() throws Exception {
        Post post = new Post();
        BDDMockito
                .given(repository.create(post))
                .willReturn(post);

        String expectedContent = "{\"id\":4,\"header\":\"1\",\"author\":\"2\"}";
        this.mvc.perform(post("/posts")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(expectedContent)
        )
                .andExpect(status().isCreated())
                .andExpect(content().string(expectedContent));
    }

    @Test
    @DisplayName("POST /posts - Success")
    void testCreatePost() throws Exception {
        Post postPost = new Post("Header Test", "Adam", "Some test text", "empty", false);
        Post mockPost = new Post("Header Test", "Adam", "Some test text", "empty", false);
        doReturn(mockPost).when(repository).create(any());
        System.out.println("JSON OUTPUT: " + asJsonString(postPost));
        mvc.perform(post("/posts")
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(postPost)))

                .andExpect(status().isCreated())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
                //.andExpect(header().string(HttpHeaders.LOCATION, "/posts/1"))

                .andExpect(jsonPath("$.header", is("Header Test")))
                .andExpect(jsonPath("$.text", is("Some test text")))
                .andExpect(jsonPath("$.imageUrl", is("empty")))
                .andExpect(jsonPath("$.author", is("Adam")));

    }
    static String asJsonString(final Post obj){
        try{
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
