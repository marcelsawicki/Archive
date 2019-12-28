using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace WebApplication1.Models
{
    public class PersonViewModel
    {
        public string Name { get; set; }
        public int Age { get; set; }
        public bool Manager { get; set; }
        public double Salary { get; set; }
    }
}