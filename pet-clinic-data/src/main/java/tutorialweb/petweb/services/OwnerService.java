package tutorialweb.petweb.services;

import tutorialweb.petweb.Model.Owner;

import java.util.Set;

public interface OwnerService {

    Owner findByLastName(String lastname);

    Owner findById(Long id);

    Owner save(Owner owner);

    Set<Owner> findall();
}
