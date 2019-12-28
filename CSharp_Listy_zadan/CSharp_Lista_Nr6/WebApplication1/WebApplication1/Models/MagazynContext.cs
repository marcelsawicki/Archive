using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Data.Entity;

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