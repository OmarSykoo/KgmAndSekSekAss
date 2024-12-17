package lms.project.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.RequestScope;

import lms.project.Models.Course;
import lms.project.Repositories.CourseRepository;

@Service
@RequestScope
public class CourseService {
    private final CourseRepository courseRepository;

    @Autowired
    public CourseService(CourseRepository courseRepository_) {
        this.courseRepository = courseRepository_;
    }

    public Course addCourse(String CourseName) {
        Course course = new Course();
        course.setName(CourseName);
        course = this.courseRepository.save(course);
        return course;
    }
}
