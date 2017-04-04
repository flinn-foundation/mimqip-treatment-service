package org.flinnfoundation.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class Treatment {

    @Id
    @GeneratedValue
    private long id;

    private long groupId;

    private String name;

    private String abbreviation;

    private boolean valid;

    private String genericName;

}
