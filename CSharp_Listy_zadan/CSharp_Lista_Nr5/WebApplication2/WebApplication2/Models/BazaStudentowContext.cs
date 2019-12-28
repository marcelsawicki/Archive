﻿using System;
using System.Collections.Generic;
using System.Data.Entity;
using System.Linq;
using System.Web;

namespace WebApplication2.Models
{
    public class BazaStudentowContext:DbContext
    {
        public BazaStudentowContext() : base("DefaultConnection")
        {
        }

        public DbSet<Student> Students { get; set; }
    }
}