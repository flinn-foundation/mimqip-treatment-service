package org.flinnfoundation.service;

import lombok.extern.slf4j.Slf4j;
import org.flinnfoundation.model.Treatment;
import org.flinnfoundation.model.Treatment2;
import org.flinnfoundation.model.TreatmentDetail;
import org.flinnfoundation.model.TreatmentDetail2;
import org.flinnfoundation.model.enums.AdministrationMechanism;
import org.flinnfoundation.model.enums.DrugFunction;
import org.flinnfoundation.model.enums.Unit;
import org.flinnfoundation.respository.Treatment2Repository;
import org.flinnfoundation.respository.TreatmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class RecommendationService {

    private TreatmentRepository treatmentRepository;
    private Treatment2Repository treatment2Repository;

    @Autowired
    public RecommendationService(TreatmentRepository treatmentRepository, Treatment2Repository treatment2Repository) {
        this.treatmentRepository = treatmentRepository;
        this.treatment2Repository = treatment2Repository;
    }

    public void transformData() {

        List<Treatment2> treatment2List = new ArrayList<>();
        Iterable<Treatment> treatments = treatmentRepository.findAll();

        for (Treatment treatment : treatments) {
            TreatmentDetail2 treatmentDetail2 = new TreatmentDetail2();

            Treatment2 treatment2 = new Treatment2();
            treatment2.setId(treatment.getId());
            treatment2.setName(treatment.getName());
            treatment2.setGenericName(treatment.getGenericName());
            treatment2.setGroupId(treatment.getGroupId());
            treatment2.setValid(treatment.isValid());
            treatment2.setAbbreviation(treatment.getAbbreviation());


            for (TreatmentDetail treatmentDetail : treatment.getTreatmentDetail()) {
                if (treatmentDetail.getKey().equals("AdministrationMechanism")) {
                    treatmentDetail2.setAdministrationMechanism(AdministrationMechanism.valueOf(treatmentDetail.getValue()));
                } else if(treatmentDetail.getKey().equals("AltNamePattern")) {
                    treatmentDetail2.setAltNamePattern(treatmentDetail.getValue());
                } else if(treatmentDetail.getKey().equals("AMTPercentDoseRange")) {
                    treatmentDetail2.setAmtDoseRange(Double.parseDouble(treatmentDetail.getValue()));
                } else if(treatmentDetail.getKey().equals("AMTGracePeriod")) {
                    treatmentDetail2.setAmtGracePeriod(Double.parseDouble(treatmentDetail.getValue()));
                } else if(treatmentDetail.getKey().equals("AMTPercentResponseTime")) {
                    treatmentDetail2.setAmtResponseTime(Double.parseDouble(treatmentDetail.getValue()));
                } else if(treatmentDetail.getKey().equals("DailyHighDose")) {
                    treatmentDetail2.setDailyHighDose(Double.parseDouble(treatmentDetail.getValue()));
                } else if(treatmentDetail.getKey().equals("DailyLowDose")) {
                    treatmentDetail2.setDailyLowDose(Double.parseDouble(treatmentDetail.getValue()));
                } else if(treatmentDetail.getKey().equals("DisplayName")) {
                    treatmentDetail2.setDisplayName(treatmentDetail.getValue());
                } else if(treatmentDetail.getKey().equals("DrugFunction")) {
                    treatmentDetail2.setDrugFunction(DrugFunction.valueOf(treatmentDetail.getValue()));
                } else if(treatmentDetail.getKey().equals("DurationOfAction")) {
                    treatmentDetail2.setDurationOfAction(Double.parseDouble(treatmentDetail.getValue()));
                } else if(treatmentDetail.getKey().equals("FormulationPattern")) {
                    treatmentDetail2.setFormulationPattern(treatmentDetail.getValue());
                } else if(treatmentDetail.getKey().equals("GenericNamePattern")) {
                    treatmentDetail2.setGenericNamePattern(treatmentDetail.getValue());
                } else if(treatmentDetail.getKey().equals("GuidelineChartName")) {
                    treatmentDetail2.setGuidelineChartName(treatmentDetail.getValue());
                } else if(treatmentDetail.getKey().equals("LabNamePattern")) {
                    treatmentDetail2.setLabNamePattern(treatmentDetail.getValue());
                } else if(treatmentDetail.getKey().equals("LongActingFlag")) {
                    treatmentDetail2.setLongActing(Boolean.parseBoolean(treatmentDetail.getValue()));
                } else if(treatmentDetail.getKey().equals("LongActingFrequency")) {
                    treatmentDetail2.setLongActingFrequency(Double.parseDouble(treatmentDetail.getValue()));
                } else if(treatmentDetail.getKey().equals("MaxDose")) {
                    treatmentDetail2.setMaxDose(Double.parseDouble(treatmentDetail.getValue()));
                } else if(treatmentDetail.getKey().equals("MDDDailyHighDose")) {
                    treatmentDetail2.setMddDailyHighDose(Double.parseDouble(treatmentDetail.getValue()));
                } else if(treatmentDetail.getKey().equals("MDDDailyLowDose")) {
                    treatmentDetail2.setMddDailyLowDose(Double.parseDouble(treatmentDetail.getValue()));
                } else if(treatmentDetail.getKey().equals("MDDStartDose")) {
                    treatmentDetail2.setMddStartDose(Double.parseDouble(treatmentDetail.getValue()));
                } else if(treatmentDetail.getKey().equals("ResponseTime")) {
                    treatmentDetail2.setResponseTime(Double.parseDouble(treatmentDetail.getValue()));
                } else if(treatmentDetail.getKey().equals("SerumLevelHigh")) {
                    treatmentDetail2.setSerumLevelHigh(Double.parseDouble(treatmentDetail.getValue()));
                } else if(treatmentDetail.getKey().equals("SerumLevelLow")) {
                    treatmentDetail2.setSerumLevelLow(Double.parseDouble(treatmentDetail.getValue()));
                } else if(treatmentDetail.getKey().equals("SerumLevelUnit")) {
                    treatmentDetail2.setSerumLevelUnit(treatmentDetail.getValue());
                } else if(treatmentDetail.getKey().equals("StartDose")) {
                    treatmentDetail2.setStartDose(Double.parseDouble(treatmentDetail.getValue()));
                } else if(treatmentDetail.getKey().equals("Unit")) {
                    treatmentDetail2.setUnit(Unit.valueOf(treatmentDetail.getValue()));
                } else {
                    log.error("Unknown key!: " + treatmentDetail.getKey());
                }
            }

            treatment2.setTreatmentDetail(treatmentDetail2);
            treatment2List.add(treatment2);


        }

        treatment2Repository.save(treatment2List);
    }


//    public String getRecommendation(PatientDataDto patientData) {
//
//        // get prescriptions
//
////        RequestPrescriptionBean bean = new RequestPrescriptionBean();
////        bean.setPatientid(patientreq.getPatientid());
////
////        HashMap<String, ArrayList<ResponsePrescriptionBean>> prescriptionInterim = new HashMap<String, ArrayList<ResponsePrescriptionBean>>();
////        HashMap<String, ResponsePrescriptionBean[]> prescriptions = new HashMap<String, ResponsePrescriptionBean[]>();
////        List<ResponsePrescriptionBean> prescriptionList = null;
////        ResponsePatientBean patient = null;
////        ResponseLabBean[] labs = null;
////        List<ResponseRuleBean> rules = null;
////        RecommendDiagnosisBean[] diagnoses = null;
//
////        try {
////            prescriptionList = new PrescriptionDaoImp().find(bean, "EntryDate DESC", connection);
//
//            //Iterate through prescriptions
////            Iterator<ResponsePrescriptionBean> it = prescriptionList.iterator();
////            while (it.hasNext()) {
////                ResponsePrescriptionBean rpbean = it.next();
//            for(Prescription prescription : patientData.getPrescriptions()) {
////                String key = rpbean.getTreatment()
////                        .getDetails().get("GuidelineChartName");
//                prescription.getTreatment.getGuidelineChartName();
//
//                if (prescriptionInterim.get(key) == null) {
//                    prescriptionInterim.put(key, new ArrayList<ResponsePrescriptionBean>());
//                }
//                prescriptionInterim.get(key).add(rpbean);
//            }
//
//            //Convert HashMap<String, ArrayList<ResponsePrescriptionBean>> to HashMap<String, ResponsePrescriptionBean[]>
//            if (prescriptionInterim.size() > 0) {
//                Iterator<String> iterator = prescriptionInterim.keySet().iterator();
//                while (iterator.hasNext()) {
//                    String key = iterator.next();
//                    ResponsePrescriptionBean[] values = new ResponsePrescriptionBean[prescriptionInterim.get(key).size()];
//                    prescriptions.put(key, prescriptionInterim.get(key).toArray(values));
//                }
//            }
//            patient = new PatientDaoImp().findPatientById(patientreq.getPatientid(), connection);
//            labs = new LabDaoImp().findByPatientId(patientreq.getPatientid(), connection);
////				rules = new RuleDaoImp().findAllRules(null, null, connection);
////				diagnoses = new RuleDaoImp().getAllDiagnoses(connection);
////        } catch (Exception e) {
////            LOG.error("Prescriptions/patient retrieval failed (unknown error): " + e.getMessage());
////        }
//
//        RecommendPatientInfoBean patientInfo = new RecommendPatientInfoBean(patient, prescriptions, labs, diagnoses);
//        System.out.print(patientInfo.toExpandedString());
//        // build recommendation
//        ResponseRecommendationContainerBean rcb = new ResponseRecommendationContainerBean();
//        ResponseRecommendationBean rrb = new ResponseRecommendationBean();
//
//        String[] status = {"Patient Name: " + patient.getDetails().get("firstname")[0].getValue() + " " + patient.getDetails().get("lastname")[0].getValue(),
//                "Patient Birthday: " + patient.getDetails().get("birth")[0].getValue(),
//                "Patient Diagnosis: " + patientInfo.getInfo().get("diagnosis_primary"),
//                "Patient Stage: " + patientInfo.getInfo().get("diagnosis_stage")};
//        rrb.setStatus(status);
//        String[] medications = new String[patientInfo.getPrescriptioninfo().size()];
//        int i = 0;
//        for (Iterator<String> it = patientInfo.getPrescriptioninfo().keySet().iterator(); it.hasNext(); ) {
//            String key = it.next();
//            if (patientInfo.getPrescriptioninfo().get(key) != null) {
//                medications[i] = key + ": " + patientInfo.getPrescriptioninfo().get(key).get("dose") + patientInfo.getPrescriptioninfo().get(key).get("unit");
//            } else {
//                medications[i] = "Problem with medication " + key;
//                LOG.error("Problem with medication " + key);
//            }
//            i++;
//
//        }
//        rrb.setMedications(medications);
//
//        String[][] othermessages = null;
//        String[] othersideeffects = getOthersideeffects(patientInfo, rules);
//        String[] otherreports = getOtherreports(patientInfo, rules);
//
//        int k = 0;
//        // TODO: This should really handle "other messages" more flexibly than this.  Unfortunately, not at this time.
//        if (othersideeffects != null) {
//            othermessages = new String[2][];
//            othermessages[k] = othersideeffects;
//            k++;
//        } else {
//            othermessages = new String[1][];
//        }
//        if (otherreports != null) {
//            othermessages[k] = otherreports;
//            k++;
//        }
//        //String[][] othermessages = { { "Your Colleagues' Prescriptions", "Sufficient data for calculating the percent of clinicians who prescribed the specific guideline medications for patients with the same diagnosis are not yet available" },
//        //		{ "Notes", "None at the present time" }
//        //};
//        rrb.setOthermessages(othermessages);
//
//        rrb.setMedicaltrial(getMedicaltrial(patientInfo, rules));
//        rrb.setGeneralconsistency(getGeneralConsistency(patientInfo, rules));
//        rrb.setAdditionalconsistency(getAdditionalConsistency(patientInfo, rules));
//        rrb.setGeneralmessages(getGeneralMessages(patientInfo, rules));
//        rrb.setClinicalresponse(getClinicalResponse(patientInfo, rules));
//        rrb.setTreatmentmessages(getTreatmentMessages(patientInfo, rules));
//        rrb.setSpecialmessages(getSpecialMessages(patientInfo, rules));
//        rrb.setConsistent(patientInfo.getInfo().get("consistent"));
//        if (patientInfo.getDiagnosis() != null) {
//            rrb.setGuidelinechart(patientInfo.getDiagnosis().getGuidelinechart());
//        } else {
//            rrb.setGuidelinechart(null);
//        }
//        rcb.setRecommendation(rrb);
//
//
//        return rcb;
//
//    }

}
