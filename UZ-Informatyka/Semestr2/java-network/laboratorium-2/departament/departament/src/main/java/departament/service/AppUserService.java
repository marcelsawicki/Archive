package departament.service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import departament.model.AppUser;
import departament.repository.AppUserRepository;
import java.util.List;
import java.util.Optional;

@Service
public class AppUserService implements IAppUserService 
{
	 @PersistenceContext
	 private EntityManager em;
	  
    @Autowired
    private AppUserRepository appUserRepository;
    
	public List<AppUser> findUser(String firstname, String lastname)
	{	
	    return em.createQuery("SELECT c FROM AppUser c WHERE c.firstname LIKE ?1 AND c.lastname LIKE ?2")
	    		.setParameter(1, firstname)
	    		.setParameter(2, lastname)
	    		.getResultList();
	}
	
	public List<AppUser> findAllUsers()
	{
		return em.createQuery("SELECT c FROM AppUser c").getResultList();
	}
	
	public List<AppUser> findUsersFromDepartament(String departamentname)
	{
		// TODO
		return null;
	}
	
	public List<AppUser> findUsersWithPaymentIsHigher(float payment)
	{
		return em.createQuery("SELECT c FROM AppUser c WHERE c.payment > ?1")
				.setParameter(1, payment)
				.getResultList();
	}
}
