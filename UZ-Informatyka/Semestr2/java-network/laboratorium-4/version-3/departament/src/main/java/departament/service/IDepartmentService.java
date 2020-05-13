package departament.service;

import departament.model.Department;
import java.util.List;
import java.util.Optional;


public interface IDepartmentService 
{
	List<Department> findAllDepartments();
	Department findDepartmentManagedByUser(String firstname, String lastname);
	Department findDepartmentWithMaxNumberOfEmployes();
	Department findDepartmentWithMaxUsersSalary();

}
