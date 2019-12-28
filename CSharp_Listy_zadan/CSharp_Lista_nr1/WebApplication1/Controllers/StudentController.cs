using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;
using WebApplication1.Models;

namespace WebApplication1.Controllers
{
    public class StudentController : Controller
    {
        static Student student1 = new Student();

        // GET: Student
        public ActionResult Index()
        {
            return View();
        }

        public ActionResult IndeksStudent()
        {
            return View();
        }

        public ActionResult EditStudent()
        {
            return View();
        }

        public ActionResult DetaleStudent()
        {
            Student przykladowyStudent1 = new Student();
            przykladowyStudent1.Nazwisko = "Wyspiański";
            przykladowyStudent1.LataNauki = 4;
            przykladowyStudent1.Plec = "mężczyzna";
            przykladowyStudent1.Wiek = 25;
            przykladowyStudent1.NumerTelefonu = "987-654-321";
            przykladowyStudent1.DataUrodzenia = new DateTime(1984, 3, 13);

            return View(przykladowyStudent1);
        }

        // GET: ProduktyViewModel/Create
        public ActionResult Create()
        {
            return View();
        }

        // POST: ProduktyViewModel/Create
        [HttpPost]
        public ActionResult Create(Student student)
        {
            try
            {
                // TODO: Add insert logic here
                student1 = student;
                return RedirectToAction("Details");
            }
            catch
            {
                return View();
            }
        }

        // POST: Student/Details
        public ActionResult Details()
        {
            return View(student1);
        }

        // POST: Student/Edit
        public ActionResult Edit()
        {
            return View(student1);
        }

        [HttpPost]
        public ActionResult Edit(Student student)
        {
            try
            {
                student1 = student;
                return RedirectToAction("Details");
            }
            catch
            {
                return View();
            }
        }

    }
}
