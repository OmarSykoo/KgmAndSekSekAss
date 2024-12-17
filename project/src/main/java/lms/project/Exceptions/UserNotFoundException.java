package lms.project.Exceptions;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(String errorMsg) {
        super(errorMsg);
    }
}
