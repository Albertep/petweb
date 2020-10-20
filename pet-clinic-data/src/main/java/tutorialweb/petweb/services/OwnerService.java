package tutorialweb.petweb.services;

import tutorialweb.petweb.Model.Owner;

public interface OwnerService extends CrudService<Owner,Long>{

    Owner findByLastName(String lastname);

}
