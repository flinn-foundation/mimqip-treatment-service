package org.flinnfoundation.exception;

public class MimqipEvaluationException extends RuntimeException {
    public MimqipEvaluationException() {
        super();
    }

    public MimqipEvaluationException(String message) {
        super(message);
    }

    public MimqipEvaluationException(String message, Throwable cause) {
        super(message, cause);
    }

    public MimqipEvaluationException(Throwable cause) {
        super(cause);
    }

    protected MimqipEvaluationException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
