package departament.service;

import departament.model.App_User;
import departament.model.Department;
import java.util.List;
import java.util.Optional;

public interface IAppUserService 
{
	List<App_User> findUser(String firstname, String lastname);
	List<App_User> findAllUsers();
	List<App_User> findUsersFromDepartment(String departamentname);
	List<App_User> findUsersWithPaymentIsHigher(long payment);

}
