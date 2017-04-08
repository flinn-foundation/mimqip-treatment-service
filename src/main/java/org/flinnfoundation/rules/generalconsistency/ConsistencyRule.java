package org.flinnfoundation.rules.generalconsistency;

import lombok.Data;
import org.flinnfoundation.model.Patient;
import org.flinnfoundation.rules.AbstractBaseRule;

@Data
abstract public class ConsistencyRule extends AbstractBaseRule {

    protected Patient patient;
}
