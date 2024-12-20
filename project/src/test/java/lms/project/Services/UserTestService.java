package lms.project.Services;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import lms.project.Enums.Role;
import lms.project.Models.User;

@SpringBootTest
public class UserTestService {
    @Autowired
    private UserService userService;

    @Test
    public void testCreateUser() {
        User result = userService.AddUser("Youssef", LocalDate.now(), "jooo", "hoho123",
                Role.STUDENT);

        assertEquals("Youssef", result.getName());
    }

    @Test
    public void testFetchUserByID() {
        long id = 1;
        User result = userService.GetById(id);
        assertEquals(result.getName(), "omar");
    }

}
