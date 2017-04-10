package org.flinnfoundation.rules.generalconsistency;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.flinnfoundation.model.Patient;
import org.flinnfoundation.rules.AbstractBaseRule;

@Data
@EqualsAndHashCode(callSuper = true)
public abstract class ConsistencyRule extends AbstractBaseRule {

    protected Patient patient;
}
