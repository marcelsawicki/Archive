using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApp1
{
    class Towar
    {

        // nazwa, cena netto, typ, ilość w magazynie, cena brutto
        public string nazwa;
        public double cenaNetto;
        public string typ;
        public int ilosc;
		//  double cenaBrutto;

		// Stworzyć własność cena brutto, która w działaniu przelicza się na cenę netto
		// (ale bez tworzenie pola do ceny netto, zakładamy jedną stawkę VAT)
		public double CenaNetto
		{
			get { return cenaNetto; }
			set { cenaNetto = value; }

		}
		public virtual double cenaBrutto
        {

			get { return cenaNetto * 1.23; }
			set { CenaNetto = value / 1.23; }
		}

        // konstruktor0
        public Towar()
        {

        }

        // konstruktor1
        public Towar(string nazwa)
        {
            this.nazwa = nazwa;
        }

        // konstruktor2 + inicjalizator konstruktora1
        public Towar(string nazwa, string typ, double cenaNetto, int ilosc):this(nazwa)  
        {
            this.typ = typ;
            this.cenaNetto = cenaNetto;
            this.ilosc = ilosc;
        }
        public override string ToString()
        {
            string komunikat;
            komunikat = "Nazwa: " + nazwa + ", Ilosc: " + ilosc + ", Cena netto: ";
            komunikat += cenaNetto + " zl, Typ: " + typ + ", Cena brutto: " + this.cenaBrutto +" zl \n";
            return komunikat;
        }

    }
}
