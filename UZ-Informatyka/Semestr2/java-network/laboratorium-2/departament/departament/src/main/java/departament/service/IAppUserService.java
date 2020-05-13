package departament.service;

import departament.model.AppUser;
import departament.model.Departament;
import java.util.List;
import java.util.Optional;

public interface IAppUserService 
{
	List<AppUser> findUser(String firstname, String lastname);
	List<AppUser> findAllUsers();
	List<AppUser> findUsersFromDepartament(String departamentname);
	List<AppUser> findUsersWithPaymentIsHigher(float payment);

}
