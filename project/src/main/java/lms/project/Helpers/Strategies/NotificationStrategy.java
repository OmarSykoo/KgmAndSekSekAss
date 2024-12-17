package lms.project.Helpers.Strategies;

import lms.project.Models.Course;
import lms.project.Models.Notification;
import lms.project.Models.User;

public interface NotificationStrategy {
    Notification createNotification(User user, Course course, User relatedUser);
}
