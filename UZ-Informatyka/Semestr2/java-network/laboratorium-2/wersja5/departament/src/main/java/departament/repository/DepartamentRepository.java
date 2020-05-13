package departament.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import departament.model.Departament;

public interface DepartamentRepository extends CrudRepository<Departament, Integer> 
{
//	List<Departament> findAllDepartaments();
//	Departament findDepartamentManagedByUser(String firstname, String lastname);
//	Departament findDepartamentWithMaxNumberOfEmloyes();
//	Departament findDepartamentWithMaxUsersSalary();
}
