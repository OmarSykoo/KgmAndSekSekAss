package lms.project.Helpers.Strategies;

import lms.project.Helpers.Builders.NotificationBuilder;
import lms.project.Models.Course;
import lms.project.Models.Notification;
import lms.project.Models.User;

public class StudentNotificationStrategy implements NotificationStrategy {
    @Override
    public Notification createNotification(User student, Course course, User unused) {
        return new NotificationBuilder()
                .setUser(student)
                .setSeen(false)
                .setName("Course Enrollment Confirmation. Status: Not Seen")
                .setContent(
                        String.format("Congratulations! You have been enrolled in the course: %s", course.getTitle()))
                .build();
    }
}
