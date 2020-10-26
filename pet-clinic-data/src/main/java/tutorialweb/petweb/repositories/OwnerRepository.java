package tutorialweb.petweb.repositories;

import org.springframework.data.repository.CrudRepository;
import tutorialweb.petweb.model.Owner;

public interface OwnerRepository extends CrudRepository<Owner,Long> {
    Owner findByLastName (String lastname);
}
