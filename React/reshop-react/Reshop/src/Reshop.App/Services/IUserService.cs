namespace Reshop.Services
{
    public interface IUserService
    {
        public bool CheckPasswordSignIn(string username, string password);
    }
}
