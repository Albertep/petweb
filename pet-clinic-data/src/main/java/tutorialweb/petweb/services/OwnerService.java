package tutorialweb.petweb.services;

import org.springframework.data.repository.CrudRepository;
import tutorialweb.petweb.Model.Owner;

import java.util.Set;

public interface OwnerService extends CrudService<Owner,Long>{

    Owner findByLastName(String lastname);

}
