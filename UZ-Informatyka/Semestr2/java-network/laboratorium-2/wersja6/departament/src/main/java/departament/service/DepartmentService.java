package departament.service;

import departament.repository.AppUserRepository;
import departament.repository.DepartmentRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import departament.model.Department;
import java.util.List;
import java.util.Optional;

@Service
public class DepartmentService implements IDepartmentService 
{
	 @PersistenceContext
	 private EntityManager em;
	  
	 @Autowired
	 private AppUserRepository DepartamentRepository;
	 
	 @Autowired
	 private AppUserRepository AppUserRepository;
	 
		public List<Department> findAllDepartments()
		{
			return em.createQuery("SELECT c FROM Department c").getResultList();
		}
		
		public Department findDepartmentManagedByUser(String firstName, String lastName)
		{
			return AppUserRepository.findByFirstNameAndLastName(firstName, lastName).getDepartment();
		}
		
		public Department findDepartmentWithMaxNumberOfEmployes()
		{
			Department dep = null;
			long maxNumber = 0;
			for (Department department : this.findAllDepartments()) {
				long employeesNumber = AppUserRepository.countByDepartment(department);
				if(employeesNumber>=maxNumber){
					dep = department;
					maxNumber = employeesNumber;
				}
			}
			return dep;
		}
		
		public Department findDepartmentWithMaxUsersSalary()
		{
			// TODO
			return null;
		}
}
