using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace WebApplication1.Models
{
    public class TowarWybranyKoszyk
    {
        public List<TowarWybrany> Towary { get; set; } = new List<TowarWybrany>();

        public void Remove(int index)
        {
            // sprawdzenie, czy zakres indeksu jest poprawny
            if (index >= 0 && index < Size())
            {
                Towary.RemoveAt(index);
            }
        }

        // zwraca informacje czy operacja s
        public bool Add(Towar towar)
        {
            if (towar == null)
            {
                return false;
            }
            
            // referencje nie beda rowne trzeba porownac identyfikator
            if(Towary.FindIndex(m=> m.Towar.Id == towar.Id) <0)
            {
                Towary.Add(new TowarWybrany() { Towar = towar, ilosc = 1 });
                return true;
            }
            return false;
        }

        // delegacja metody
        public int Size()
        {
            return Towary.Count();
        }

        public double TotalCount()
        {
            double sum = 0;
            foreach (TowarWybrany towar in Towary)
            {
                sum += towar.ilosc;
            }
            return sum;
        }
    }
}