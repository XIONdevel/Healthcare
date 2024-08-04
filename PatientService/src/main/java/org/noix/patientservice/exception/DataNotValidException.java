package org.noix.patientservice.exception;

public class DataNotValidException extends RuntimeException {

    public DataNotValidException() {
    }

    public DataNotValidException(String message) {
        super(message);
    }

    public DataNotValidException(String message, Throwable cause) {
        super(message, cause);
    }

    public DataNotValidException(Throwable cause) {
        super(cause);
    }

    public DataNotValidException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
