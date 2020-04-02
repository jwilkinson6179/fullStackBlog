package com.zipcode.fullstackblog.ControllerTests;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zipcode.fullstackblog.controllers.TagController;
import com.zipcode.fullstackblog.models.Post;
import com.zipcode.fullstackblog.models.Tag;
import com.zipcode.fullstackblog.repositories.TagRepository;
import com.zipcode.fullstackblog.services.TagService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;


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
    private TagRepository service;

    @Autowired
    private MockMvc mockMvc;

    @InjectMocks
    private TagController tagController;

//    @Test
//    @DisplayName("POST /tags - Success")
//    void testCreateTag() throws Exception {
//        Tag postTag = new Tag("Hello");
//        Tag mockTag = new Tag(1L,"Hello");
//        Post mockPost = new Post();
//        tagController.save(postTag);
//        mockTag.setPost(mockPost);
//        doReturn(mockTag).when(service).create(any());
//
//        mockMvc.perform(post("/tags")
//                .contentType(MediaType.APPLICATION_JSON)
//                .content(asJsonString(postTag)))
//
//                .andExpect(status().isCreated())
//                .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
//
//                .andExpect(header().string(HttpHeaders.LOCATION, "/tags/1"))
//
//                .andExpect(jsonPath("$.id", is(1)))
//                .andExpect(jsonPath("$.name", is("Hello")));
//
//
//    }
//    static String asJsonString(final Object obj){
//        try{
//            return new ObjectMapper().writeValueAsString(obj);
//        } catch (Exception e){
//            throw new RuntimeException(e);
//        }
//    }

    @Test
    public void testPostTag() throws Exception {
        Tag tag = new Tag("Hello");
        tag.setPost(new Post());
        BDDMockito
                .given(service.save(tag))
                .willReturn(tag);

        String expectedContent = "{\"id\":null,\"name\":\"Hello\"}";
        this.mockMvc.perform(MockMvcRequestBuilders
                .post("/tags")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(expectedContent)
        )
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.content().string(expectedContent));
    }
}
