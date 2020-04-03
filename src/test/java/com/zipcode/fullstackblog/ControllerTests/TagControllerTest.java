package com.zipcode.fullstackblog.ControllerTests;

import com.zipcode.fullstackblog.controllers.TagController;
import com.zipcode.fullstackblog.models.Post;
import com.zipcode.fullstackblog.models.Tag;
import com.zipcode.fullstackblog.repositories.TagRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

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


    @Test
    public void testPostTag() throws Exception {
        Tag tag = new Tag("Hello");
        BDDMockito
                .given(service.save(tag))
                .willReturn(tag);
        tag.addPost(new Post());
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
