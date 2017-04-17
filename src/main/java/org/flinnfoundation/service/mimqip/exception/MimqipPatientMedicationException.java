package org.flinnfoundation.service.mimqip.exception;

public class MimqipPatientMedicationException extends RuntimeException {
    public MimqipPatientMedicationException() {
        super();
    }

    public MimqipPatientMedicationException(String message) {
        super(message);
    }

    public MimqipPatientMedicationException(String message, Throwable cause) {
        super(message, cause);
    }

    public MimqipPatientMedicationException(Throwable cause) {
        super(cause);
    }

    protected MimqipPatientMedicationException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
