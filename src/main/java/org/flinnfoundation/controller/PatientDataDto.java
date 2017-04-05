package org.flinnfoundation.controller;

import lombok.Data;
import org.flinnfoundation.model.diagnosis.DiagnosisTemp;

import java.time.LocalDate;

@Data
public class PatientDataDto {

    private DiagnosisTemp diagnosis;

    private LocalDate dateOfBirth;

    private SexEnum sex;

    public enum SexEnum {
        MALE("MALE"),

        FEMALE("FEMALE");

        private String value;

        SexEnum(String value) {
            this.value = value;
        }
    }
}
