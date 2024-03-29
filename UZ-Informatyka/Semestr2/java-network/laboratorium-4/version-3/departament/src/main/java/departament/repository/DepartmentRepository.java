package departament.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import departament.model.Department;

@Repository
public interface DepartmentRepository extends CrudRepository<Department, Integer> 
{
	Optional<Department> findById(Integer id);
	Department findDepartmentByName(String deaprtamentname);
}
