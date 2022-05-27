using Microsoft.AspNetCore.Cors;
using Microsoft.AspNetCore.Mvc;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

// For more information on enabling Web API for empty projects, visit https://go.microsoft.com/fwlink/?LinkID=397860

namespace TemplateAPI.Controllers
{
    [Route("api/[controller]")]
    [ApiController]
    public class TemplatesController : ControllerBase
    {
        // GET api/<TemplatesController>/5
        [HttpGet("{id}")]
        [EnableCors("ApiCorsPolicy")]
        public string Get(int id)
        {
            return @"<div>załadowany dynamicznie z WebAPI: Sukiennice przy Jerzmanowskiej zapraszają</div>";
        }
    }
}
