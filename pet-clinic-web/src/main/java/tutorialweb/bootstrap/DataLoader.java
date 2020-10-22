package tutorialweb.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import tutorialweb.petweb.Model.Owner;
import tutorialweb.petweb.Model.Vet;
import tutorialweb.petweb.services.OwnerService;
import tutorialweb.petweb.services.VetService;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerservice;
    private final VetService vetService;

    public DataLoader(OwnerService ownerservice, VetService vetService) {
        this.ownerservice = ownerservice;
        this.vetService = vetService;
    }

    @Override
    public void run(String... args) throws Exception {

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
