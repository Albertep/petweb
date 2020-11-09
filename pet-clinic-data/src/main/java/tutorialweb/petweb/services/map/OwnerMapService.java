package tutorialweb.petweb.services.map;

import java.util.ArrayList;
import java.util.List;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import tutorialweb.petweb.model.Owner;
import tutorialweb.petweb.model.Pet;
import tutorialweb.petweb.services.OwnerService;
import tutorialweb.petweb.services.PetService;
import tutorialweb.petweb.services.PetTypeService;

import java.util.Set;

@Service
@Profile({"default","Map"})
public class OwnerMapService extends  AbstractMapService<Owner, Long> implements OwnerService {
    private final PetTypeService petTypeService;
    private final PetService petService;

    public OwnerMapService(PetTypeService petType, PetService pet) {
        this.petTypeService = petType;
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
                            pet.setPetType(petTypeService.save(pet.getPetType()));
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
        final Owner[] returnedOwner = new Owner[1];
        map.values().forEach(owner -> {
            if(owner.getLastName()==lastname);
             returnedOwner[0] =owner;
        });
        return returnedOwner[0];
    }

     @Override
    public List<Owner> findAllByLastNameLike(String lastname) {
        List<Owner>ownerList=new ArrayList<>();
        if (lastname==""){
            return List.copyOf(map.values());
        }
         for (Owner owner : map.values()) {
             int beginIndex = 0;
             int endIndex = lastname.length();
             boolean found = false;
             boolean flag = false;
             boolean exist = true;
             if (lastname == owner.getLastName().substring(beginIndex, endIndex)) {
                 ownerList.add(owner);
                 break;
             } else {
                 while (!found && exist) {
                     if (!flag) {
                         beginIndex++;
                     } else {
                         endIndex--;
                     }

                     if (beginIndex == endIndex) {
                         endIndex--;
                         beginIndex = 0;
                     }
                     if (endIndex == 0) {
                         if (!flag) {
                             flag = true;
                             endIndex = lastname.length();
                         } else {
                             exist = false;
                         }
                     }
                     if (lastname == owner.getLastName().substring(beginIndex, endIndex)) {
                         ownerList.add(owner);
                         found = true;
                     }
                 }
             }
         }
         return ownerList;
    }

/*  @Override
   public List<Owner> findAllByLastNameLike(String lastname) {
       return List.copyOf(map.values());
   }*/

}
