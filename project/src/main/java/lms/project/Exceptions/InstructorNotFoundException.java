package lms.project.Exceptions;

public class InstructorNotFoundException extends RuntimeException {
    public InstructorNotFoundException(String ErrorMsg) {
        super(ErrorMsg);
    }
}
