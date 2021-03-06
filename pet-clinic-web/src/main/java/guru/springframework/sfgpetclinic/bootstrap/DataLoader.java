package guru.springframework.sfgpetclinic.bootstrap;

import guru.springframework.sfgpetclinic.model.*;
import guru.springframework.sfgpetclinic.services.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialityService specialityService;
    private final VisitService visitService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialityService specialityService, VisitService visitService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialityService = specialityService;
        this.visitService = visitService;
    }


    @Override
    public void run(String... args) throws Exception {

        PetType dog = new PetType();
        dog.setName("Dog");
        PetType saveDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        dog.setName("Cat");
        PetType saveCatPetType = petTypeService.save(cat);

        Speciality surgery = new Speciality();
        surgery.setDescription("Surgery");
        Speciality savedSurgery = specialityService.save(surgery);

        Speciality dentistry = new Speciality();
        surgery.setDescription("Dentistry");
        Speciality savedDentistry = specialityService.save(dentistry);

        Speciality radiology = new Speciality();
        surgery.setDescription("Radiology");
        Speciality savedRadiology = specialityService.save(radiology);

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

        Visit catVisit = new Visit();
        catVisit.setPet(stevesPet);
        catVisit.setDate(LocalDate.now());
        catVisit.setDescription("Sneezy Kitty");


        System.out.println("Owners Loaded....!");

        Vet vet1 = new Vet();
        vet1.setId(3L);
        vet1.setFirstName("Amy");
        vet1.setLastName("Peter");
        vet1.getSpecialities().add(savedDentistry);
        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setId(4L);
        vet2.setFirstName("John");
        vet2.setLastName("Cena");
        vet2.getSpecialities().add(savedRadiology);
        vetService.save(vet2);

        System.out.println("Vets Loaded");

    }
}
