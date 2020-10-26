package tutorialweb.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import tutorialweb.petweb.model.*;
import tutorialweb.petweb.services.*;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerservice;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialityService specialityService;
    private final VisitService visitService;

    public DataLoader(OwnerService ownerservice, VetService vetService, PetTypeService petTypeService, SpecialityService specialityService, VisitService visitService) {
        this.ownerservice = ownerservice;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialityService = specialityService;
        this.visitService = visitService;
    }

    @Override
    public void run(String... args) throws Exception {

        int count = petTypeService.findAll().size();

        if(count==0) {
            loadData();
        }
    }

    private void loadData() {
        PetType dog= new PetType();
        dog.setName("Dog");
        PetType savedDogPetType= petTypeService.save(dog);

        PetType cat= new PetType();
        dog.setName("Cat");
        PetType savedCatPetType= petTypeService.save(cat);

        Speciality speciality= new Speciality();
        speciality.setId(1L);
        speciality.setDescription("Mi especialidad es comer perritos muy rápido");
        specialityService.save(speciality);

        Speciality speciality2= new Speciality();
        speciality2.setId(2L);
        speciality2.setDescription("Mi especialidad es no mancharme las manos al comer patatas fritas del Mcdonalds");
        specialityService.save(speciality2);

        System.out.println("Loading Owners...");

        Owner alberte=new Owner();
        alberte.setId(1L);
        alberte.setFirstname("Berte");
        alberte.setLastname("Pazos");
        alberte.setAddress("CALLE FALSA 123");
        alberte.setCity("Ciudad Piruleta");
        alberte.setTelephone("123456789");

        Pet pet= new Pet();
        pet.setPetType(dog);
        pet.setId(1L);
        pet.setName("doggie");
        pet.setOwner(alberte);
        pet.setDate(LocalDate.now());
        alberte.getPets().add(pet);


        ownerservice.save(alberte);

        Owner eire=new Owner();
        eire.setId(2L);
        eire.setFirstname("Eire");
        eire.setLastname("Pazos");
        eire.setAddress("CALLE FALSA 123");
        eire.setCity("Ciudad Piruleta");
        eire.setTelephone("123456789");


        Pet pet2= new Pet();
        pet2.setPetType(cat);
        pet2.setId(1L);
        pet2.setName("catty");
        pet2.setOwner(eire);
        pet2.setDate(LocalDate.now());
        eire.getPets().add(pet);

        ownerservice.save(eire);

        System.out.println("Loaded Owners");

        Visit catVisit= new Visit();
        catVisit.setId(1L);
        catVisit.setPet(pet2);
        catVisit.setDate(LocalDate.now());
        catVisit.setDescription("Un buen zagal visitando a un gato");
        System.out.println("Loading Vets.....");

        visitService.save(catVisit);


        Vet paula= new Vet();
        paula.setId(1L);
        paula.setFirstname("Paula");
        paula.setLastname("Martinez");
        paula.getSpecialties().add(speciality);

        vetService.save(paula);

        Vet estela= new Vet();
        estela.setId(2L);
        estela.setFirstname("Estela");
        estela.setLastname("Martinez");
        estela.getSpecialties().add(speciality2);

        vetService.save(estela);

        System.out.println("Loaded Vets");
    }
}
