package lms.project.Services;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.RequestScope;

import lms.project.Enums.Role;
import lms.project.Exceptions.UserNotFoundException;
import lms.project.Models.User;
import lms.project.Models.UserCourse;
import lms.project.Repositories.UserRepository;

@Service
@RequestScope
public class UserService {
    @Autowired
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User AddUser(
            String name,
            LocalDate birthDate,
            String userName,
            String passWord,
            Role role) {
        User user = new User();
        user.setName(name);
        user.setDob(birthDate);
        user.setUsername(userName);
        user.setPassword(passWord);
        user.setRole(role);

        user = userRepository.save(user);
        return user;
    }

    public User GetById(long id) throws UserNotFoundException {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User Not Found"));
        return user;
    }

}
