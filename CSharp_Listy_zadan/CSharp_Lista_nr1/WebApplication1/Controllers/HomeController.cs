using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace WebApplication1.Controllers
{
    public class HomeController : Controller
    {
        public ActionResult Index()
        {
            return View();
        }

        public ActionResult About()
        {
            ViewBag.Message = "Your application description page.";

            return View();
        }

        public ActionResult Contact()
        {
            ViewBag.Message = "Your contact page.";

            return View();
        }
        public ActionResult MojaStr1()
        {
            ViewBag.Message = "Moja pierwsza strona MVC";
            ViewBag.ValueX = 123456789;
            ViewBag.ValueText = "Dzień dobry!";
            return View();
        }

  //      public ActionResult MojaStr1(int numer, string nazwisko, string imie)
  //      { ViewBag.Message = "Strona parametryczna numer=" + numer + " nazwa=" + nazwisko + " , inna=" + imie;
		//	return View("MojaStr1");
		//}
        


        public ActionResult MojaStr2()
        {
            ViewBag.Message = "Dzień dobry!";

            return View();
        }
        public ActionResult MojaStr3()
        {
            ViewBag.Message = "Witaj na stronie!";

            return View();
        }

		public ActionResult MojaStr4(int wiek, string nazwisko)
		{
			ViewBag.Message = "Dodaj tę osobę: " + nazwisko +", " +wiek.ToString();

			return View();
		}

		public ActionResult MojaStr5(int liczba1, int liczba2)
		{
			int suma = liczba1 + liczba2;
			ViewBag.Message = "Dodaj te dwie liczby: " + liczba1 + " + " +liczba2 + " = " +suma;

			return View();
		}

	}
}