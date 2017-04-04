package org.flinnfoundation.respository;

import org.flinnfoundation.model.Treatment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TreatmentGroupRepository extends CrudRepository<Treatment, Long> {

}
