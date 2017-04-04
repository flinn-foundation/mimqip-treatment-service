package org.flinnfoundation.model;

import lombok.Data;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;

@Entity
@Data
public class Rule {

    @Id
    @GeneratedValue
    private long id;

    private String name;

    @Enumerated(EnumType.STRING)
    private RuleType type;

    private int priority;

    private boolean valid;

    @NotFound(action = NotFoundAction.IGNORE)
    @OneToOne
    private Message trueMessage;

    @NotFound(action = NotFoundAction.IGNORE)
    @OneToOne
    private Message falseMessage;

//    @Transient
//    private List<RecommendRuleCriteriaBean> criteria;
//
//    @Transient
//    private List<RecommendMessageBean> messages;
//
//    @Transient
//    private List<RecommendDiagnosisBean> diagnoses;


}
