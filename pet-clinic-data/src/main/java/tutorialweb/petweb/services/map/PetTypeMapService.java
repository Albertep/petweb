package tutorialweb.petweb.services.map;

import tutorialweb.petweb.Model.Pet;
import tutorialweb.petweb.Model.PetType;
import tutorialweb.petweb.services.PetService;
import tutorialweb.petweb.services.PetTypeServices;

import java.util.Set;

public class PetTypeMapService extends AbstractMapService<PetType,Long> implements PetTypeServices {
    @Override
    public Set<PetType> findAll() {
        return super.findAll();
    }

    @Override
    public PetType findById(Long id) {
        return super.findById(id);
    }

    @Override
    public PetType save(PetType object) {
        return super.save(object);
    }

    @Override
    public void delete(PetType object) {
        super.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }
}
