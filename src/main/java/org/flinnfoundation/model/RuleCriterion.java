package org.flinnfoundation.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class RuleCriterion {

    @Id
    @GeneratedValue
    private long id;

    private long ruleId;

    private int priority;

    @Enumerated(EnumType.STRING)
    private RuleCriterionType type;

    private String fieldName;

    private String operator;

    private String value;

    private enum RuleCriterionType {
        TEXT, NUMERIC, NUMERIC_VALUE
    }
}
