package departament.service;

import departament.model.Departament;
import java.util.List;
import java.util.Optional;


public interface IDepartamentService 
{
	List<Departament> findAllDepartaments();
	Departament findDepartamentManagedByUser(String firstname, String lastname);
	Departament findDepartamentWithMaxNumberOfEmployes();
	Departament findDepartamentWithMaxUsersSalary();

}
