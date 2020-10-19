package tutorialweb.petweb.services;

import tutorialweb.petweb.Model.Vet;

import java.util.Set;

public interface VetService {

    Vet findById(Long id);

    Vet save(Vet owner);

    Set<Vet> findall();
}
