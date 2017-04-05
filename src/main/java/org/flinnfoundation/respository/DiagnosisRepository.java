package org.flinnfoundation.respository;

import org.flinnfoundation.model.Diagnosis;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DiagnosisRepository extends CrudRepository<Diagnosis, Long> {

}
