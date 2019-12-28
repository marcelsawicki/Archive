using System;
using System.Collections.Generic;
using System.Data.Entity;
using System.Linq;
using System.Web;

namespace WebApplication3.Models
{
    public class StudentContext : DbContext
    {
        public StudentContext() : base("MDFConnection")
        {
        }

        public DbSet<Student> Students { get; set; }
    }
}