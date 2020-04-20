package com.zipcode.fullstackblog.ServiceTests;

import com.zipcode.fullstackblog.models.User;
import com.zipcode.fullstackblog.repositories.UserRepository;
import com.zipcode.fullstackblog.services.UserService;
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
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @MockBean
    private UserRepository userRepository;

    @Test
    @DisplayName("Test findById Success")
    public void tetFindByIdSuccess() {

        // Set up mock object and repository
        User mockUser = new User();
        doReturn(Optional.of(mockUser)).when(userRepository).findById(1L);

        // Execute call
        Optional<User> returnUser = userService.findById(1);

        // Check assertions
        Assertions.assertTrue(returnUser.isPresent(), "No User was found when there should be");
        Assertions.assertSame(returnUser.get(), mockUser, "Models dont match up");
    }

    @Test
    @DisplayName("Test findById Fail")
    public void testFindByIdFail() {

        // Set up mock repository
        doReturn(Optional.empty()).when(userRepository).findById(1L);

        //execute the service call
        Optional<User> returnUser = userService.findById(1L);

        // Check assertions
        Assertions.assertFalse(returnUser.isPresent(), "User was found, when it should't be");
    }
    @Test
    @DisplayName("Test save product")
    public void testSave(){
        User mockUser = new User();
        doReturn(mockUser).when(userRepository).save(any());

        User returnUser = userService.create(mockUser);

        Assertions.assertNotNull(returnUser, "The saved user should not be null");
    }

}

