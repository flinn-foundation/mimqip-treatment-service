package org.flinnfoundation.model;

import lombok.Data;
import org.flinnfoundation.model.enums.AdministrationMechanism;
import org.flinnfoundation.model.enums.DrugFunction;
import org.flinnfoundation.model.enums.Unit;

import javax.persistence.*;

@Data
@Embeddable
public class TreatmentDetail {

    private double amtGracePeriod;

    private double amtDoseRange;

    private double amtResponseTime;

    @Enumerated(EnumType.STRING)
    private AdministrationMechanism administrationMechanism;

    private String altNamePattern;

    private double dailyHighDose;

    private double dailyLowDose;

    private String displayName;

    @Enumerated(EnumType.STRING)
    private DrugFunction drugFunction;

    private double durationOfAction;

    private String formulationPattern;

    private String genericNamePattern;

    private String guidelineChartName;

    private String labNamePattern;

    private boolean longActing;

    private double longActingFrequency;

    private double maxDose;

    private double mddDailyHighDose;

    private double mddDailyLowDose;

    private double mddStartDose;

    private double responseTime;

    private double serumLevelHigh;

    private double serumLevelLow;

    private String serumLevelUnit;

    private double startDose;

    @Enumerated(EnumType.STRING)
    private Unit unit;

}
