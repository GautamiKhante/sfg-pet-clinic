package guru.springfraework.repositories;

import guru.springframework.sfgpetclinic.model.Visit;
import org.springframework.data.repository.CrudRepository;

public interface VisitReository extends CrudRepository<Visit, Long> {
}
