package tutorialweb.petweb.services.map;

import org.springframework.stereotype.Service;
import tutorialweb.petweb.model.Speciality;
import tutorialweb.petweb.model.Vet;
import tutorialweb.petweb.services.SpecialityService;
import tutorialweb.petweb.services.VetService;

import java.util.Set;

@Service
public class VetMapService extends AbstractMapService<Vet,Long> implements VetService {
    private  final SpecialityService specialityService;

    public VetMapService(SpecialityService specialityService) {
        this.specialityService = specialityService;
    }

    @Override
    public Set<Vet> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Vet object) {
        super.delete(object);
    }

    @Override
    public Vet save(Vet object) {

        if(object.getSpecialties()!=null){
            object.getSpecialties().forEach(speciality ->{
                if(speciality.getId()==null){
                    Speciality savedSpeciality= specialityService.save(speciality);
                    speciality.setId(savedSpeciality.getId());
                }
            });
        }
        return super.save(object);
    }

    @Override
    public Vet findById(Long id) {
        return super.findById(id);
    }
}
