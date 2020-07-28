package guru.springframework.sfgpetclinic.model;

import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import java.util.HashSet;
import java.util.Set;

public class Vet extends Person {

    @ManyToMany
    @JoinTable(name = "vet_specialities", @JoinColumns=@JoinColumn(name = "vet_id"),
            inverseJoinColumns = @JoinColumn(name = "spespeciality_id"))
    private Set<Speciality> specialities = new HashSet<>();

    public Set<Speciality> getSpecialities() {
        return specialities;
    }

    public void setSpecialities(Set<Speciality> specialities) {
        this.specialities = specialities;
    }
}
