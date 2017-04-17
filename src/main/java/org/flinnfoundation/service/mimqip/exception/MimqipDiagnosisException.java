package org.flinnfoundation.service.mimqip.exception;

public class MimqipDiagnosisException extends RuntimeException {
    public MimqipDiagnosisException() {
        super();
    }

    public MimqipDiagnosisException(String message) {
        super(message);
    }

    public MimqipDiagnosisException(String message, Throwable cause) {
        super(message, cause);
    }

    public MimqipDiagnosisException(Throwable cause) {
        super(cause);
    }

    protected MimqipDiagnosisException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
