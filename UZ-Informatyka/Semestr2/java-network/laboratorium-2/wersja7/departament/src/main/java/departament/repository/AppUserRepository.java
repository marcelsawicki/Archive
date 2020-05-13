package departament.repository;

import org.springframework.data.repository.CrudRepository;
import java.util.List;
import java.util.Optional;

import departament.model.App_User;
import departament.model.Department;

public interface AppUserRepository extends CrudRepository<App_User, Integer> 
{
	Optional<App_User> findById(Integer id);
	App_User findByFirstNameAndLastName(String firstName, String lastName);
	Long countByDepartment(Department department);
	List<App_User> findAllByDepartment(Department departament);
	List<App_User> findByPayGreaterThan(Long payment);
}
