package org.flinnfoundation.respository;

import org.flinnfoundation.model.DiagnosisOld;
import org.flinnfoundation.model.enums.DiagnosisType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DiagnosisRepository extends CrudRepository<DiagnosisOld, Long> {

    List<DiagnosisOld> findDiagnosesByDiagnosisTypeAndStageGreaterThan(DiagnosisType diagnosisType, int stage);

    List<DiagnosisOld> findDiagnosesByDiagnosisTypeAndStageLessThan(DiagnosisType diagnosisType, int stage);

}
