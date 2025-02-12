package ai.recruit.testrecruit.exception;

public class ValidationException extends RuntimeException {
    public ValidationException(String errorMessage) {
        super(errorMessage);
    }
}
