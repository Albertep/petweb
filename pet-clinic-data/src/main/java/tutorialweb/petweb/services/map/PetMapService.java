package tutorialweb.petweb.services.map;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import tutorialweb.petweb.model.Pet;
import tutorialweb.petweb.services.PetService;

import java.util.Set;

@Service
@Profile({"default","Map"})
public class PetMapService extends AbstractMapService <Pet,Long> implements PetService {
    @Override
    public Set<Pet> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Pet object) {
        super.delete(object);
    }

    @Override
    public Pet save(Pet object) {
        return super.save(object);
    }

    @Override
    public Pet findById(Long id) {
        return super.findById(id);
    }
}
