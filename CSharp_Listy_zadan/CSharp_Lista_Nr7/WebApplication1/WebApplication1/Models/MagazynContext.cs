using System;
using System.Collections.Generic;
using System.Data.Entity;
using System.Linq;
using System.Web;

namespace WebApplication1.Models
{
    public class MagazynContext: DbContext
    {
        public MagazynContext(): base("DefaultConnection")
        {

        }

        public DbSet<Kategoria> Kategorias { get; set; }
        public DbSet<Towar> Towars { get; set; }
    }
}