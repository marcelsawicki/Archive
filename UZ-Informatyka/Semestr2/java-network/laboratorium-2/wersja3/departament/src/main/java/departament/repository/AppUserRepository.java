package departament.repository;

import org.springframework.data.repository.CrudRepository;
import java.util.List;

import departament.model.AppUser;

public interface AppUserRepository extends CrudRepository<AppUser, Integer> {}
