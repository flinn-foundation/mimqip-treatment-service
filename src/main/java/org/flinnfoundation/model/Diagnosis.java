package org.flinnfoundation.model;

import lombok.Data;
import org.flinnfoundation.model.enums.DiagnosisType;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Diagnosis {

    @Id
    @GeneratedValue
    private long id;

    @Enumerated(EnumType.STRING)
    private DiagnosisType diagnosisType;

    private int stage;

    @Lob
    private String notes;

    @OneToMany
    private List<Treatment> treatments;
}
