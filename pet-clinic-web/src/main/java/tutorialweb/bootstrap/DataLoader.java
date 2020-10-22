package tutorialweb.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import tutorialweb.petweb.Model.Owner;
import tutorialweb.petweb.Model.PetType;
import tutorialweb.petweb.Model.Vet;
import tutorialweb.petweb.services.OwnerService;
import tutorialweb.petweb.services.PetTypeServices;
import tutorialweb.petweb.services.VetService;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerservice;
    private final VetService vetService;
    private final PetTypeServices petTypeServices;

    public DataLoader(OwnerService ownerservice, VetService vetService, PetTypeServices petTypeServices) {
        this.ownerservice = ownerservice;
        this.vetService = vetService;
        this.petTypeServices = petTypeServices;
    }

    @Override
    public void run(String... args) throws Exception {

        PetType dog= new PetType();
        dog.setName("Dog");
        PetType savedDogPetType=petTypeServices.save(dog);

        PetType cat= new PetType();
        dog.setName("Cat");
        PetType savedCatPetType=petTypeServices.save(cat);

        System.out.println("Loading Owners...");

        Owner alberte=new Owner();
        alberte.setId(1L);
        alberte.setFirstname("Berte");
        alberte.setLastname("Pazos");

        ownerservice.save(alberte);

        Owner eire=new Owner();
        eire.setId(2L);
        eire.setFirstname("Eire");
        eire.setLastname("Pazos");

        ownerservice.save(eire);

        System.out.println("Loaded Owners");

        System.out.println("Loading Vets.....");

        Vet paula= new Vet();
        paula.setId(1L);
        paula.setFirstname("Paula");
        paula.setLastname("Martinez");

        vetService.save(paula);

        Vet estela= new Vet();
        estela.setId(2L);
        estela.setFirstname("Estela");
        estela.setLastname("Martinez");

        vetService.save(estela);

        System.out.println("Loaded Vets");

    }
}
