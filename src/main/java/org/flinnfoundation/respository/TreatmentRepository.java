package org.flinnfoundation.respository;

import org.flinnfoundation.model.Treatment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface TreatmentRepository extends CrudRepository<Treatment, Long> {

    Treatment getTreatmentByGenericName(String genericName);

    List<Treatment> getTreatmentsByGenericName(Collection<String> genericName);
}
