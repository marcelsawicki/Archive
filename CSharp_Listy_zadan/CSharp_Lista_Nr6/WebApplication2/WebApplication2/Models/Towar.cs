using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;
using System.Linq;
using System.Web;

namespace WebApplication2.Models
{
	public class Towar
	{
		[Key]
		public int Id { get; set; }
		public string Nazwa { get; set; }
		public int Kategoria_Id { get; set;}
		[ForeignKey("Kategoria_Id")]
		public virtual Kategoria Kategoria { get; set;  }
	}
}