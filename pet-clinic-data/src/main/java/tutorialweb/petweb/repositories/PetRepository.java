package tutorialweb.petweb.repositories;

import org.springframework.data.repository.CrudRepository;
import tutorialweb.petweb.model.Pet;

public interface PetRepository extends CrudRepository<Pet,Long> {
}
