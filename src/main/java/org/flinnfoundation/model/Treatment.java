package org.flinnfoundation.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@Data
public class Treatment {

    @Id
    @GeneratedValue
    private long id;

    private long groupId;

    private String name;

    private String abbreviation;

    private boolean valid;

    private String genericName;

    @OneToMany
    private List<TreatmentDetail> treatmentDetail;
}
