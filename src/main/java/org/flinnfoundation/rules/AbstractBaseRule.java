package org.flinnfoundation.rules;

import lombok.Data;

import java.util.List;

@Data
abstract public class AbstractBaseRule {
    protected List<String> messageTags;
}
