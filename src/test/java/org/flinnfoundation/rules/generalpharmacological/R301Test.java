package org.flinnfoundation.rules.generalpharmacological;

import org.easyrules.api.RulesEngine;
import org.easyrules.core.RulesEngineBuilder;
import org.flinnfoundation.model.PatientTreatmentStatistics;
import org.flinnfoundation.model.enums.TreatmentGroupType;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class R301Test {

    private RulesEngine rulesEngine = RulesEngineBuilder.aNewRulesEngine().build();
    private R301 r301 = new R301();

    private List<String> messageTags = new ArrayList<>();

    @Mock
    private PatientTreatmentStatistics patientTreatmentStatistics;


    @Before
    public void setUp() {

        r301.setTreatmentStatistics(patientTreatmentStatistics);
        r301.setMessageTags(messageTags);

        rulesEngine.registerRule(r301);
    }

    @Test
    public void testIt() {
        when(patientTreatmentStatistics.getCountForTreatmentGroupType(TreatmentGroupType.SGA)).thenReturn(1);
        rulesEngine.fireRules();

        assertTrue(messageTags.isEmpty());
    }

    @Test
    public void testItMore() {
        when(patientTreatmentStatistics.getCountForTreatmentGroupType(TreatmentGroupType.SGA)).thenReturn(3);
        rulesEngine.fireRules();

        assertEquals(R301.MESSAGE_TAG, messageTags.get(0));
    }

}
