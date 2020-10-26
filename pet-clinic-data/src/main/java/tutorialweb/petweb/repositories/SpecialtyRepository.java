package tutorialweb.petweb.repositories;

import org.springframework.data.repository.CrudRepository;
import tutorialweb.petweb.model.Speciality;

public interface SpecialtyRepository extends CrudRepository<Speciality,Long> {
}
