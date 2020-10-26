package tutorialweb.petweb.repositories;

import org.springframework.data.repository.CrudRepository;
import tutorialweb.petweb.model.PetType;

public interface PetTypeRepository extends CrudRepository<PetType,Long> {
}
