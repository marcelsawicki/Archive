using System;
using System.Collections.Generic;
using System.Data.Entity;
using System.Linq;
using System.Web;

namespace WebApplication2.Models
{
    public class GraczContext:DbContext
    {
        public GraczContext():base("GraczConnection")
        {
        }
        public DbSet<Gracz> Graczs { get; set; }

    }
}