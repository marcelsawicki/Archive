using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Web;

namespace WebApplication1.Models
{
	public class Student
	{
		[Required(ErrorMessage = "Nazwisko jest wymagane")]
		[StringLength(50, ErrorMessage = "{0} musi posiadać przynajmniej {2} znaków", MinimumLength = 3)]
		public String Nazwisko { get; set; }
		[Required] [DataType(DataType.Date)] [Display(Name = "Data urodzenia")]
		public DateTime DataUrodzenia { get; set; }
		[Range(18, 100)] public int Wiek { get; set; }
		[Range(0, 50, ErrorMessage = "Lata nauki muszą mieścić się w skali od 0 do 50.")]
		public int LataNauki { get; set; }
		[Required] [Display(Name = "Numer telefonu")]
		[RegularExpression(@"^[0-9]{3}\-[0-9]{3}\-[0-9]{3}$", ErrorMessage = "Wprowadzony numer telefonu musi mieć format XXX-XXX-XXX.")]
		public string NumerTelefonu { get; set; }
		[Display(Name = "Płeć")]
		public String Plec { get; set; }
	}
}