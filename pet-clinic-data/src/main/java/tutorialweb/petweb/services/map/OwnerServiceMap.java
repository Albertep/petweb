package tutorialweb.petweb.services.map;

import org.springframework.stereotype.Service;
import tutorialweb.petweb.Model.Owner;
import tutorialweb.petweb.Model.Pet;
import tutorialweb.petweb.services.OwnerService;
import tutorialweb.petweb.services.PetService;
import tutorialweb.petweb.services.PetTypeServices;

import java.util.Set;

@Service
public class OwnerServiceMap extends  AbstractMapService<Owner, Long> implements OwnerService {
    private final PetTypeServices petTypeServices;
    private final PetService petService;

    public OwnerServiceMap(PetTypeServices petType, PetService pet) {
        this.petTypeServices = petType;
        this.petService = pet;
    }

    @Override
    public Set<Owner> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Owner object) {
        super.delete(object);
    }

    @Override
    public Owner findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Owner save(Owner object) {

        if(object!= null) {
            if(object.getPets()!=null) {
                object.getPets().forEach(pet->{
                    if(pet.getPetType()!=null){
                        if(pet.getPetType().getId()==null){
                            pet.setPetType(petTypeServices.save(pet.getPetType()));
                        }
                    }else{
                        throw new RuntimeException("Pet Type is required");
                    }
                    if(pet.getId() == null){
                        Pet petsaved=petService.save(pet);
                        pet.setId(petsaved.getId());
                    }
                });

            }
            return super.save(object);
        }
        else return null;
    }

    @Override
    public Owner findByLastName(String lastname) {
        return null;
    }
}
