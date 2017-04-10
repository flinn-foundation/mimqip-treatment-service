package org.flinnfoundation.exception;

public class MimqipPatientException extends RuntimeException {
    public MimqipPatientException() {
        super();
    }

    public MimqipPatientException(String message) {
        super(message);
    }

    public MimqipPatientException(String message, Throwable cause) {
        super(message, cause);
    }

    public MimqipPatientException(Throwable cause) {
        super(cause);
    }

    protected MimqipPatientException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
