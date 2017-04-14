package org.flinnfoundation.respository;

import org.flinnfoundation.model.Diagnosis;
import org.flinnfoundation.model.enums.DiagnosisType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DiagnosisRepository extends CrudRepository<Diagnosis, Long> {

    List<Diagnosis> findDiagnosesByDiagnosisTypeAndStageGreaterThan(DiagnosisType diagnosisType, int stage);

    List<Diagnosis> findDiagnosesByDiagnosisTypeAndStageLessThan(DiagnosisType diagnosisType, int stage);

}
