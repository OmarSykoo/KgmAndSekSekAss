package lms.project.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.RequestScope;

import lms.project.Exceptions.UserNotFoundException;
import lms.project.Helpers.Strategies.InstructorNotificationStrategy;
import lms.project.Helpers.Strategies.NotificationStrategy;
import lms.project.Helpers.Strategies.StudentNotificationStrategy;
import lms.project.Models.Course;
import lms.project.Models.Notification;
import lms.project.Models.User;
import lms.project.Repositories.NotificationRepository;
import lms.project.Repositories.UserRepository;

@Service
@RequestScope
public class NotificationService {
    @Autowired
    private final NotificationRepository notificationRepository;
    @Autowired
    private final UserRepository userRepository;

    public NotificationService(NotificationRepository notificationRepository, UserRepository userRepository) {
        this.notificationRepository = notificationRepository;
        this.userRepository = userRepository;
    }

    private User getUserById(long userId, String userType) throws UserNotFoundException {
        return userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException(userType + " not found"));
    }

    private void notifyUser(long userId, Course course, User relatedUser, NotificationStrategy strategy)
            throws UserNotFoundException {
        User user = getUserById(userId, "User");
        Notification notification = strategy.createNotification(user, course, relatedUser);
        notificationRepository.save(notification);
    }

    public void studentEnrolled(long studentId, Course courseEnrolled) throws UserNotFoundException {
        long instructorId = courseEnrolled.getInstructor().getId();

        notifyUser(studentId, courseEnrolled, null, new StudentNotificationStrategy());

        User student = getUserById(studentId, "Student");
        notifyUser(instructorId, courseEnrolled, student, new InstructorNotificationStrategy());
    }

}
