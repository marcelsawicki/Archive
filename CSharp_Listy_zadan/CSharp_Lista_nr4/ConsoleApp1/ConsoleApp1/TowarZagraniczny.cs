using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApp1
{
	class TowarZagraniczny : Towar
	{
		private double cloProcent;

		public double CloProcent
		{
			get { return cloProcent; }
			set { cloProcent = value; }
		}
		public TowarZagraniczny(string _nazwa, string _typ, double _cena, int _ilosc, double clo) : base(_nazwa, _typ, _cena, _ilosc)
		{
			cloProcent = clo;
		}

		public override double cenaBrutto
		{
			get { return cenaNetto * (cloProcent + 1) * 1.23; }
			set { this.cenaNetto = value / 1.23 / (cloProcent + 1); }
		}
		public override string ToString()
		{
			return string.Format("Nazwa: {0}, Ilosc: {1}, Cena Netto: {2} zł, Typ: {3}, Cena Brutto: {4} zł, Clo: {5}", nazwa, ilosc, CenaNetto, typ, cenaBrutto, cloProcent);
		}
	}
}
