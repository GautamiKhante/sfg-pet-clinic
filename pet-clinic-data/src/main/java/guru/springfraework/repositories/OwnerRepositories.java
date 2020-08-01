package guru.springfraework.repositories;

import guru.springframework.sfgpetclinic.model.Owner;
import org.springframework.data.repository.CrudRepository;

public interface OwnerRepositories extends CrudRepository<Owner, Long> {
}
