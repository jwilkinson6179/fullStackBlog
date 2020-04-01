package com.zipcode.fullstackblog.ControllerTests;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zipcode.fullstackblog.controllers.TagController;
import com.zipcode.fullstackblog.models.Post;
import com.zipcode.fullstackblog.models.Tag;
import com.zipcode.fullstackblog.services.TagService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;


import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class TagControllerTest {
    @MockBean
    private TagService service;

    @Autowired
    private MockMvc mockMvc;

    @InjectMocks
    private TagController tagController;

    @Test
    @DisplayName("POST /tags - Success")
    void testCreateTag() throws Exception {
        Tag postTag = new Tag("Hello");
        Tag mockTag = new Tag(1L,"Hello");
        Post mockPost = new Post();
        tagController.save(postTag);
        mockTag.setPost(mockPost);
        doReturn(mockTag).when(service).create(any());

        mockMvc.perform(post("/tags")
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(postTag)))

                .andExpect(status().isCreated())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))

                .andExpect(header().string(HttpHeaders.LOCATION, "/tags/1"))

                .andExpect(jsonPath("$.id", is(1)))
                .andExpect(jsonPath("$.name", is("Hello")));


    }
    static String asJsonString(final Object obj){
        try{
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e){
            throw new RuntimeException(e);
        }
    }

}
