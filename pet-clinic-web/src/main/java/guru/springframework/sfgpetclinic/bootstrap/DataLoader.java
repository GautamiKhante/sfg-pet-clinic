package guru.springframework.sfgpetclinic.bootstrap;

import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.model.Vet;
import guru.springframework.sfgpetclinic.services.OwnerService;
import guru.springframework.sfgpetclinic.services.PetService;
import guru.springframework.sfgpetclinic.services.VetService;
import guru.springframework.sfgpetclinic.services.map.OwnerServiceMap;
import guru.springframework.sfgpetclinic.services.map.PetServiceMap;
import guru.springframework.sfgpetclinic.services.map.VetServiceMap;
import org.springframework.boot.CommandLineRunner;

public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final PetService petService;
    private final VetService vetService;


    public DataLoader() {
        ownerService = new OwnerServiceMap();
        petService = new PetServiceMap();
        vetService = new VetServiceMap();
    }

    @Override
    public void run(String... args) throws Exception {
        Owner owner1 = new Owner();
        owner1.setId(1L);
        owner1.setFirstName("Michael");
        owner1.setLastName("Kors");

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner1.setId(1L);
        owner1.setFirstName("Steve");
        owner1.setLastName("Madden");

        ownerService.save(owner2);

        System.out.println("Owners Loaded....!");

        Vet vet1 = new Vet();
        vet1.setId(1L);
        vet1.setFirstName("Amy");
        vet1.setLastName("Peter");
        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setId(1L);
        vet2.setFirstName("John");
        vet2.setLastName("Cena");

        vetService.save(vet2);



    }
}
