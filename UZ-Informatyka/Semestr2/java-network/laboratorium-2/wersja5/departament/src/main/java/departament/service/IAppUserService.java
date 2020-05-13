package departament.service;

import departament.model.AppUser;
import java.util.List;
import java.util.Optional;

public interface IAppUserService 
{
	 List<AppUser> findUser1(String firstname);
	 Optional<AppUser> getOne();
	//List<AppUser> findUsersFromDepartament(String departamentname);
	//List<AppUser> findUsersWithPaymentIsHigher(float payment);
}
