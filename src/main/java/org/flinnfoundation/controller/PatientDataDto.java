package org.flinnfoundation.controller;

import lombok.Data;
import org.flinnfoundation.model.Diagnosis;

import java.time.LocalDate;

@Data
public class PatientDataDto {

    private Diagnosis diagnosis;

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
