package net.engineeringdigest.journalApp.service;

import net.engineeringdigest.journalApp.entity.User;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.*;

@Disabled
@SpringBootTest // to run the application
//@ActiveProfiles("dev")
public class UserServiceTests {

    @Autowired
    private UserService userRepository;

    @Autowired
    private UserService userService;

    /* @BeforeEach this will run before each test case
    @BeforeAll  this will run before all test case
    @AfterEach this will run after each test case
    @AfterAll this will run after all test case get executed
    void setUp() {

    } */

    @Disabled // to disable this test
    @Test
    public void testFindByUserName() {

        User user = userRepository.findByUserName("Jay");
        assertTrue(!user.getJournalEntries().isEmpty());

        assertNotNull( userRepository.findByUserName("Jay"));

        assertEquals(4, 2 + 2);
        assertTrue(5 > 3);
    }

    @ParameterizedTest
//    @CsvSource({
//            "Jay",
//            "Sagar",
//            "Chinku",
//            "Tony"
//    })
    @ValueSource(strings = { // and for int => ints
            "Jay",
            "Sagar",
            "Chinku",
            "Tony"
    })
    public void testFindByUserNameParameterized(String name) {
        assertNotNull( userRepository.findByUserName(name), "Failed for: " + name);
    }

    @ParameterizedTest
    @ArgumentsSource(UserArgumentsProvider.class)
    public void testSaveNewUser(User user) {
        assertTrue(userService.saveNewUser(user));
    }

    @ParameterizedTest
//    @CsvFileSource => you give the file to test as well
    @CsvSource({
            "1, 1, 2", // a, b, expected
            "2, 10, 12",
            "3, 3, 9"
    })
    public void test(int a, int b, int expected) {
        assertEquals(expected, a + b);

    }
}
