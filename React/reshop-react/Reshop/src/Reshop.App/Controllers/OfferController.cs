using Microsoft.AspNetCore.Authentication;
using Microsoft.AspNetCore.Authentication.Cookies;
using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;
using Reshop.Services;
using ReshopApp.DTO;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Security.Claims;
using System.Threading.Tasks;

namespace Reshop.Controllers
{
    [Route("api/[controller]")]
    [ApiController]
    public class OfferController : ControllerBase
    {
        private readonly IUserService _userService;
        public OfferController(IUserService userService)
        {
            _userService = userService;
        }

        [HttpGet]
        public async Task<List<ProductDto>> GetOffer([FromQuery] string login, [FromQuery] string password)
        {
            var products = new List<ProductDto>();
            products.Add(new ProductDto()
            {
                Id = 1,
                Name = "name1",
                Category = "category",
                Description = "description",
                Price = 2
            });
            products.Add(new ProductDto()
            {
                Id = 2,
                Name = "name2",
                Category = "category",
                Description = "description",
                Price = 1
            });
            return products;
        }

    }
}
