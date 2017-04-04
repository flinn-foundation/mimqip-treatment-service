package org.flinnfoundation.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;

@Data
@Entity
public class TreatmentDetail {

    @Id
    @GeneratedValue
    private long id;

    private long treatmentId;

    private String key;

    @Lob
    private String value;

}
