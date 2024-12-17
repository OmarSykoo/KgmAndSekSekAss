package lms.project.Services;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import lms.project.Enums.Role;
import lms.project.Models.User;

@SpringBootTest
class UserTestService {
    @Autowired
    private UserService userService;

    @Test
    public void testCreateUser() {
        User result = userService.AddUser("omar", LocalDate.now(), "Sykoo", "123", Role.INSTRUCTOR);
        assertEquals("Sykooo", "ss");
    }
}
