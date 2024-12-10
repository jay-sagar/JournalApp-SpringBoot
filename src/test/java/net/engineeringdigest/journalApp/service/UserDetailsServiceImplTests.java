package net.engineeringdigest.journalApp.service;

import net.engineeringdigest.journalApp.entity.User;
import net.engineeringdigest.journalApp.respository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;

import static org.mockito.Mockito.*;

@Disabled
//@SpringBootTest => This annotation is required when you want to run tests within the full Spring Context.
// It loads the entire Spring application context, which is necessary when using @Autowired
// to inject beans like the UserDetailsServiceImpl.
// While powerful, it is heavier and slower than using Mockito for isolated tests.
public class UserDetailsServiceImplTests {

    // @Autowired
    // private UserDetailsServiceImpl userDetailsService;

     // If you want to use Spring Context (e.g., with @SpringBootTest), you need to annotate
     // the dependent beans (e.g., UserRepository) with @MockBean
     // private UserRepository userRepository;

     /* Using the above approach would look like this:
     1. Annotate the class with @SpringBootTest.
     2. Use @MockBean to mock UserRepository and inject it into the Spring Context.
    3. Use @Autowired to inject the UserDetailsServiceImpl. */

    // @InjectMocks is used to create an instance of the class under test (UserDetailsServiceImpl)
    // and inject all the mocked dependencies annotated with @Mock into it.
    @InjectMocks
    private UserDetailsServiceImpl userDetailsService;

    // @Mock is used to create a mock instance of the UserRepository.
    @Mock
    private UserRepository userRepository;

    /**
     * Initializes the mocks before each test execution.
     * This avoids dependency on the Spring Context and allows isolated unit testing.
     */
    @BeforeEach
    void initializingMocks() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void loadUserByUsernameTest() {
        when(userRepository.findByUserName(ArgumentMatchers.anyString())).thenReturn(User.builder().userName("Jay").password("dahdjshdk").roles(new ArrayList<>()).build());
        UserDetails user = userDetailsService.loadUserByUsername("Jay");
    }
}
