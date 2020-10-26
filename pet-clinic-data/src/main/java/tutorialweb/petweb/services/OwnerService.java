package tutorialweb.petweb.services;

import tutorialweb.petweb.model.Owner;

public interface OwnerService extends CrudService<Owner,Long>{

    Owner findByLastName(String lastname);

}
