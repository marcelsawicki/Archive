package departament.service;

import departament.repository.AppUserRepository;
import departament.repository.DepartmentRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import departament.model.Department;
import departament.model.App_User;
import java.util.List;
import java.util.Optional;

@Service
public class DepartmentService implements IDepartmentService 
{
	 @PersistenceContext
	 private EntityManager em;
	  
	 @Autowired
	 private DepartmentRepository DepartamentRepository;
	 
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
			Department dep = null;
			long maxUsersSalary = 0;
			for (Department department : this.findAllDepartments()) {
				long usersSalary = 0;
				for(App_User user: AppUserRepository.findAllByDepartment(department)){
					usersSalary = usersSalary + user.getId();
				}
				if(usersSalary>=maxUsersSalary){
					dep = department;
					maxUsersSalary = usersSalary;
				}
			}
			return dep;
		}
		
		public long sumYearSalary(String depName)
		{
			Department dep = DepartamentRepository.findDepartmentByName(depName);
			long usersSalary = 0;
			for(App_User user: AppUserRepository.findAllByDepartment(dep)){
				usersSalary = usersSalary + user.getPay();
			}
			return usersSalary;
		}
		
		public double getYearTax(String depName, double podatek)
		{
			Department dep = DepartamentRepository.findDepartmentByName(depName);
			double usersSalary = 0;
			for(App_User user: AppUserRepository.findAllByDepartment(dep)){
				usersSalary = usersSalary + user.getPay();
			}
			
			double obliczonyPodatek = (usersSalary*((podatek)/100));
			return obliczonyPodatek;
		}
}
