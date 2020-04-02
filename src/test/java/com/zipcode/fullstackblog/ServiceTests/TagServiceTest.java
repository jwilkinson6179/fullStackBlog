package com.zipcode.fullstackblog.ServiceTests;

import com.zipcode.fullstackblog.models.Tag;
import com.zipcode.fullstackblog.repositories.TagRepository;
import com.zipcode.fullstackblog.services.TagService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class TagServiceTest {

    @Autowired
    private TagService tagService;

    @MockBean
    private TagRepository tagRepository;

    @Test
    @DisplayName("Test findById Success")
    public void tetFindByIdSuccess() {

        // Set up mock object and repository
        Tag mockTag = new Tag(1L, "Hello");
        doReturn(Optional.of(mockTag)).when(tagRepository).findById(1L);

        // Execute call
        Optional<Tag> returnTag = tagService.findById(1);

        // Check assertions
        Assertions.assertTrue(returnTag.isPresent(), "No Tag was found when there should be");
        Assertions.assertSame(returnTag.get(), mockTag, "Models dont match up");
    }

    @Test
    @DisplayName("Test findById Fail")
    public void tetFindByIdFail() {

        // Set up mock repository
        doReturn(Optional.empty()).when(tagRepository).findById(1L);

        //execute the service call
        Optional<Tag> returnCar = tagService.findById(1L);

        // Check assertions
        Assertions.assertFalse(returnCar.isPresent(), "Tag was found, when it should't be");
    }
    @Test
    @DisplayName("Test save product")
    public void testSave(){
        Tag mockTag = new Tag(1L,"Hello");
        doReturn(mockTag).when(tagRepository).save(any());

        Tag returnTag = tagService.create(mockTag);

        Assertions.assertNotNull(returnTag, "The saved product should not be null");
    }

}