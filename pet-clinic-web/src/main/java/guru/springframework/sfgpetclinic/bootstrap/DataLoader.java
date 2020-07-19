package guru.springframework.sfgpetclinic.bootstrap;

import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.model.Pet;
import guru.springframework.sfgpetclinic.model.PetType;
import guru.springframework.sfgpetclinic.model.Vet;
import guru.springframework.sfgpetclinic.services.OwnerService;
import guru.springframework.sfgpetclinic.services.PetTypeService;
import guru.springframework.sfgpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }


    @Override
    public void run(String... args) throws Exception {

        PetType dog = new PetType();
        dog.setName("Dog");
        PetType saveDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        dog.setName("Cat");
        PetType saveCatPetType = petTypeService.save(cat);

        Owner owner1 = new Owner();
        owner1.setId(1L);
        owner1.setFirstName("Sherlock");
        owner1.setLastName("Holmes");
        owner1.setAddress("221 baker street");
        owner1.setCity("London");
        owner1.setTelephone("3454539299");

        Pet sherlocksPet = new Pet();
        sherlocksPet.setPetType(saveDogPetType);
        sherlocksPet.setBirthDate(LocalDate.now());
        sherlocksPet.setPetName("Rosco");
        sherlocksPet.setOwner(owner1);
        owner1.getPets().add(sherlocksPet);
        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setId(2L);
        owner2.setFirstName("Steve");
        owner2.setLastName("Madden");
        owner2.setAddress("221 baker street");
        owner2.setCity("London");
        owner2.setTelephone("3454539299");

        Pet stevesPet = new Pet();
        stevesPet.setPetName("Mews");
        stevesPet.setOwner(owner2);
        stevesPet.setBirthDate(LocalDate.now());
        stevesPet.setPetType(saveCatPetType);
        owner2.getPets().add(stevesPet);

        ownerService.save(owner2);

        System.out.println("Owners Loaded....!");

        Vet vet1 = new Vet();
        vet1.setId(3L);
        vet1.setFirstName("Amy");
        vet1.setLastName("Peter");
        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setId(4L);
        vet2.setFirstName("John");
        vet2.setLastName("Cena");
        vetService.save(vet2);

        System.out.println("Vets Loaded");

    }
}
