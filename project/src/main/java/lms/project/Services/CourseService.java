package lms.project.Services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.RequestScope;

import lms.project.Exceptions.CourseNotFoundException;
import lms.project.Exceptions.InstructorNotFoundException;
import lms.project.Exceptions.UserNotFoundException;
import lms.project.Models.Course;
import lms.project.Models.Material;
import lms.project.Models.User;
import lms.project.Models.UserCourse;
import lms.project.Repositories.CourseRepository;
import lms.project.Repositories.MaterialRepository;
import lms.project.Repositories.UserCourseRepository;
import lms.project.Repositories.UserRepository;

@Service
@RequestScope
public class CourseService {
    @Autowired
    private final CourseRepository courseRepository;
    @Autowired
    private final UserRepository userRepository;
    @Autowired
    private final UserCourseRepository userCourseRepository;
    @Autowired
    private final MaterialRepository materialRepository;
    @Autowired
    private final NotificationService notificationService;

    public CourseService(
            CourseRepository courseRepository_,
            UserRepository userRepository_,
            UserCourseRepository userCourseRepository_,
            MaterialRepository materialRepository_,
            NotificationService notificationService_) {
        this.courseRepository = courseRepository_;
        this.userRepository = userRepository_;
        this.userCourseRepository = userCourseRepository_;
        this.materialRepository = materialRepository_;
        this.notificationService = notificationService_;
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

    public List<Course> GetAllCourses() {
        return this.courseRepository.findAll();
    }

    public UserCourse EnrollToCourse(long StudentID, long CourseID)
            throws UserNotFoundException, CourseNotFoundException {
        User user = this.userRepository.findById(StudentID)
                .orElseThrow(() -> new UserNotFoundException("Student not found"));
        Course course = this.courseRepository.findById(CourseID)
                .orElseThrow(() -> new CourseNotFoundException("Course not found"));
        UserCourse userCourse = new UserCourse();
        userCourse.setCourse(course);
        userCourse.setUser(user);
        userCourse = userCourseRepository.save(userCourse);
        this.notificationService.studentEnrolled(StudentID, course);
        return userCourse;
    }

    public List<User> getStudentsByCourse(Long courseId) {
        List<UserCourse> userCourses = userCourseRepository.findByCourse_Id(courseId);

        return userCourses.stream()
                .map(UserCourse::getUser)
                .collect(Collectors.toList());
    }

    public Material AddMaterialToCourse(Long courseId, String name, String description)
            throws CourseNotFoundException {
        Material material = new Material();

        Course course = this.courseRepository.findById(courseId)
                .orElseThrow(() -> new CourseNotFoundException("Course not found"));

        material.setName(name);
        material.setDescription(description);
        material.setCourse(course);
        material = this.materialRepository.save(material);

        return material;
    }
}
