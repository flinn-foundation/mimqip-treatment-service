package org.flinnfoundation.rules.generalpharmacological;

import lombok.Data;
import org.flinnfoundation.model.PatientTreatmentStatistics;
import org.flinnfoundation.rules.AbstractBaseRule;

@Data
abstract public class PharmacologicalRule extends AbstractBaseRule {

    protected PatientTreatmentStatistics treatmentStatistics;
}
