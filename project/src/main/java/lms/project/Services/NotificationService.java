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

@Service
@RequestScope
public class NotificationService {
    @Autowired
    private final NotificationRepository notificationRepository;
    @Autowired
    private final UserService userService;

    public NotificationService(NotificationRepository notificationRepository, UserService userService_) {
        this.notificationRepository = notificationRepository;
        this.userService = userService_;
    }

    private void notifyUser(long userId, Course course, User relatedUser, NotificationStrategy strategy)
            throws UserNotFoundException {
        User user = userService.GetById(userId);
        Notification notification = strategy.createNotification(user, course, relatedUser);
        notificationRepository.save(notification);
    }

    public void studentEnrolled(long studentId, Course courseEnrolled) throws UserNotFoundException {
        long instructorId = courseEnrolled.getInstructor().getId();

        notifyUser(studentId, courseEnrolled, null, new StudentNotificationStrategy());

        User student = this.userService.GetById(studentId);
        notifyUser(instructorId, courseEnrolled, student, new InstructorNotificationStrategy());
    }

}
