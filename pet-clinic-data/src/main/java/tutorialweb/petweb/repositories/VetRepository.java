package tutorialweb.petweb.repositories;

import org.springframework.data.repository.CrudRepository;
import tutorialweb.petweb.model.Vet;

public interface VetRepository extends CrudRepository<Vet,Long> {
}
