package org.flinnfoundation.rules.generalmessage;

import lombok.Data;
import org.flinnfoundation.model.Patient;
import org.flinnfoundation.rules.AbstractBaseRule;

@Data
abstract public class GeneralMessageRule extends AbstractBaseRule {

    protected Patient patient;
}
