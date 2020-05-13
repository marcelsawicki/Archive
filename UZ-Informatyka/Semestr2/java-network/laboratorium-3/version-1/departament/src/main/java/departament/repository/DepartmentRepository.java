package departament.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import departament.model.Department;

public interface DepartmentRepository extends CrudRepository<Department, Integer> 
{
	Optional<Department> findById(Integer id);
	Department findDepartmentByName(String deaprtamentname);
}
