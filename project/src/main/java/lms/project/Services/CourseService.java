package lms.project.Services;

import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.RequestScope;

import lms.project.Exceptions.InstructorNotFoundException;
import lms.project.Models.Course;
import lms.project.Models.User;
import lms.project.Repositories.CourseRepository;
import lms.project.Repositories.UserRepository;

@Service
@RequestScope
public class CourseService {
    private final CourseRepository courseRepository;
    private final UserRepository userRepository;

    public CourseService(CourseRepository courseRepository_, UserRepository userRepository_) {
        this.courseRepository = courseRepository_;
        this.userRepository = userRepository_;
    }

    public Course addCourse(
            String courseTitle,
            String courseDescription,
            int courseDuration,
            Long instructorID)
            throws InstructorNotFoundException {
        Course course = new Course();
        course.setTitle(courseTitle);
        course.setDescription(courseDescription);
        course.setDuration(courseDuration);

        User instructor = userRepository.findById(instructorID)
                .orElseThrow(() -> new InstructorNotFoundException("Instructor Not Found"));

        course.setInstructor(instructor);
        return courseRepository.save(course);
    }

}
