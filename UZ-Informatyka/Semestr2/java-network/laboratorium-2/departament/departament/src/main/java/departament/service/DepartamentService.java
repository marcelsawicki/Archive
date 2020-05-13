package departament.service;

import departament.repository.AppUserRepository;
import departament.repository.DepartamentRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import departament.model.Departament;
import java.util.List;
import java.util.Optional;

@Service
public class DepartamentService implements IDepartamentService 
{
	 @PersistenceContext
	 private EntityManager em;
	  
	 @Autowired
	 private AppUserRepository DepartamentRepository;
	 
		public List<Departament> findAllDepartaments()
		{
			return em.createQuery("SELECT c FROM Departament c").getResultList();
		}
		
		public Departament findDepartamentManagedByUser(String firstname, String lastname)
		{
			// TODO
			return null;
		}
		
		public Departament findDepartamentWithMaxNumberOfEmployes()
		{
			// TODO
			return null;
		}
		
		public Departament findDepartamentWithMaxUsersSalary()
		{
			// TODO
			return null;
		}
}
