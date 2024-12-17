package lms.project.Exceptions;

public class CourseNotFoundException extends Exception {
    public CourseNotFoundException(String ErrorMessage) {
        super(ErrorMessage);
    }
}
