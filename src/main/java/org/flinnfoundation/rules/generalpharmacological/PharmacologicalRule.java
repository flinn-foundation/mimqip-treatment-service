package org.flinnfoundation.rules.generalpharmacological;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.flinnfoundation.model.PatientTreatmentStatistics;
import org.flinnfoundation.rules.AbstractBaseRule;

@Data
@EqualsAndHashCode(callSuper = true)
abstract public class PharmacologicalRule extends AbstractBaseRule {

    protected PatientTreatmentStatistics treatmentStatistics;
}
