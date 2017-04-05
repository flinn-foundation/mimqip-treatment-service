package org.flinnfoundation.model;

import lombok.Data;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Data
@Entity
public class Treatment {

    @Id
    private long id;

    @ManyToOne
    private TreatmentGroup treatmentGroup;

    private String name;

    private String abbreviation;

    private boolean valid;

    private String genericName;

    @Embedded
    private TreatmentDetail treatmentDetail;

}
