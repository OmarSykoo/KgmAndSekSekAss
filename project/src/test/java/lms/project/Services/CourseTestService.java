package lms.project.Services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import lms.project.Models.Course;
import lms.project.Models.UserCourse;

@SpringBootTest
public class CourseTestService {
    @Autowired
    private CourseService courseService;

    @Test
    void TestAddCourse() {
        Course course = courseService.addCourse("CS", "computer science course", 10, 1L);
        assertEquals("CS", course.getTitle());
    }

    @Test
    void TestGetAllCourses() {
        List<Course> courses = courseService.GetAllCourses();
        boolean foundCs = false;
        for (Course course : courses) {
            if (course.getTitle().equals("CS"))
                foundCs = true;
        }
        assertTrue(foundCs);
    }

    @Test
    void TestEnrollStudent() {
        UserCourse userCourse = courseService.EnrollToCourse(2, 2);
        assertEquals(2L, userCourse.getUser().getId());
    }
}
