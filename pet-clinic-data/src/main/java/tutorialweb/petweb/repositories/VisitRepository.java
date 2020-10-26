package tutorialweb.petweb.repositories;

import org.springframework.data.repository.CrudRepository;
import tutorialweb.petweb.model.Visit;

public interface VisitRepository extends CrudRepository<Visit,Long> {
}
