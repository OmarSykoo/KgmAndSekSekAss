package lms.project.Controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lms.project.DTOs.RequestDto.CourseRequestDTO;
import lms.project.Models.Course;
import lms.project.Services.CourseService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/courses")
public class CourseController {

    private final CourseService courseService;

    @Autowired
    CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping("hello")
    public ResponseEntity<String> getMethodName(@RequestParam String greeting) {
        if (greeting.equals("hello"))
            return ResponseEntity.ok("Hi!");
        else
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Fuck off");
    }

    @PostMapping()
    public ResponseEntity<Course> postMethodName(@RequestBody CourseRequestDTO CourseDto) {
        Course course = this.courseService.addCourse(CourseDto.getName());
        return ResponseEntity.ok(course);
    }

}
