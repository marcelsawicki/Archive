package departament.service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import departament.model.App_User;
import departament.repository.AppUserRepository;
import departament.repository.DepartmentRepository;

import java.util.List;
import java.util.Optional;

@Service
public class AppUserService implements IAppUserService 
{
	 @PersistenceContext
	 private EntityManager em;
	  
    @Autowired
    private AppUserRepository appUserRepository;
    
    @Autowired
    private DepartmentRepository departamentRepository;
    
	public List<App_User> findUser(String firstname, String lastname)
	{	
	    return em.createQuery("SELECT c FROM App_User c WHERE c.firstName LIKE ?1 AND c.lastName LIKE ?2")
	    		.setParameter(1, firstname)
	    		.setParameter(2, lastname)
	    		.getResultList();
	}
	
	public List<App_User> findAllUsers()
	{
		return em.createQuery("SELECT c FROM App_User c").getResultList();
	}
	
	public List<App_User> findUsersFromDepartment(String departamentname)
	{
		 List<App_User> users = appUserRepository.findAllByDepartment(departamentRepository.findDepartmentByName(departamentname));
		 return users;
	}
	
	public List<App_User> findUsersWithPaymentIsHigher(long payment)
	{
		return em.createQuery("SELECT c FROM App_User c WHERE c.pay > ?1")
				.setParameter(1, payment)
				.getResultList();
	}
}
