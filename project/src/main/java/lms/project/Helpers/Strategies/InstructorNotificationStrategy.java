package lms.project.Helpers.Strategies;

import lms.project.Helpers.Builders.NotificationBuilder;
import lms.project.Models.Course;
import lms.project.Models.Notification;
import lms.project.Models.User;

public class InstructorNotificationStrategy implements NotificationStrategy {

    @Override
    public Notification createNotification(User instructor, Course course, User student) {
        return new NotificationBuilder()
                .setUser(instructor)
                .setSeen(false)
                .setName("New Student Enrollment Notification. Status: Not Seen")
                .setContent(String.format("%s has enrolled in the course: %s", student.getName(), course.getTitle()))
                .build();
    }
}
