namespace Reshop.Services
{
    public class UserService : IUserService
    {
        public bool CheckPasswordSignIn(string username, string password)
        {
            if(string.IsNullOrEmpty(username) || string.IsNullOrEmpty(password))
                return false;

            if (password == "admintest")
            {
                return true;
            }

            return false;
        }
    }
}
