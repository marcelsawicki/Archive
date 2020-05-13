package departament.service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import departament.model.AppUser;
import departament.repository.AppUserRepository;
import java.util.List;

@Service
public class AppUserService implements IAppUserService 
{
	 @PersistenceContext
	 private EntityManager em;
	  
    @Autowired
    private AppUserRepository appUserRepository;
    
	public List<AppUser> findUser1(String firstname)
	{
	    return em.createQuery("SELECT c FROM AppUser c WHERE c.firstname LIKE ?1").setParameter(1, firstname).getResultList();

	}
	//List<AppUser> findUsersFromDepartament(String departamentname);
	//List<AppUser> findUsersWithPaymentIsHigher(float payment);
}
