package org.flinnfoundation.model;

import lombok.Data;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class Treatment2 {

    @Id
    private long id;

    private long groupId;

    private String name;

    private String abbreviation;

    private boolean valid;

    private String genericName;

    @Embedded
    private TreatmentDetail2 treatmentDetail;

}
