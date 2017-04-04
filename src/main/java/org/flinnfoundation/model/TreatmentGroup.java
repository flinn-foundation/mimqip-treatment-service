package org.flinnfoundation.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class TreatmentGroup {

    @Id
    @GeneratedValue
    private long id;

    private String name;

    private String abbreviation;

    private boolean valid;

}
