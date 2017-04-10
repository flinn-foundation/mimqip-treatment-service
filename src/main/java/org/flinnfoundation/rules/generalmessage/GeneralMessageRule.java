package org.flinnfoundation.rules.generalmessage;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.flinnfoundation.model.Patient;
import org.flinnfoundation.rules.AbstractBaseRule;

@Data
@EqualsAndHashCode(callSuper = true)
public abstract class GeneralMessageRule extends AbstractBaseRule {

    protected Patient patient;
}
