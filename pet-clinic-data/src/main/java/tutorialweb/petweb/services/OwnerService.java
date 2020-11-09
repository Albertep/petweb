package tutorialweb.petweb.services;

import java.util.List;
import tutorialweb.petweb.model.Owner;

public interface OwnerService extends CrudService<Owner,Long>{

    Owner findByLastName(String lastname);

    List<Owner> findAllByLastNameLike(String lastname);
}
