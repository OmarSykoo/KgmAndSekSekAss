package lms.project.Exceptions;

public class CourseNotFoundException extends RuntimeException {
    public CourseNotFoundException(String ErrorMessage) {
        super(ErrorMessage);
    }
}
