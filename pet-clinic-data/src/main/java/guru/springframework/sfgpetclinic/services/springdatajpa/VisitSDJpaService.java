package guru.springframework.sfgpetclinic.services.springdatajpa;

import guru.springfraework.repositories.VisitReository;
import guru.springframework.sfgpetclinic.model.Visit;
import guru.springframework.sfgpetclinic.services.VisitService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class VisitSDJpaService implements VisitService {

    private final VisitReository visitReository;


    public VisitSDJpaService(VisitReository visitReository) {
        this.visitReository = visitReository;
    }

    @Override
    public Set<Visit> findAll() {
        Set<Visit> visits = new HashSet<>();
        visitReository.findAll().forEach(visits::add);
        return visits;
    }

    @Override
    public Visit findById(Long aLong) {
        return visitReository.findById(aLong).orElse(null);
    }

    @Override
    public Visit save(Visit object) {
        return visitReository.save(object);
    }

    @Override
    public void delete(Visit object) {
        visitReository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        visitReository.deleteById(aLong);
    }
}
