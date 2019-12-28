using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;
using WebApplication1.Models;

namespace WebApplication1.Controllers
{
    public class PersonController : Controller
    {
        static List<PersonViewModel> persons = new List<PersonViewModel>();
        // GET: Person
        public ActionResult Index()
        {
            return View(persons);
        }

        // GET: Person/Details/5
        public ActionResult Details(int id)
        {
            return View(persons[id]);
        }

        // GET: Person/Create
        public ActionResult Create()
        {
            return View();
        }

        // POST: Person/Create
        [HttpPost]
        public ActionResult Create(PersonViewModel personViewModel)
        {
            try
            {
                // TODO: Add insert logic here
                persons.Add(personViewModel);
                return RedirectToAction("Index");
            }
            catch
            {
                return View();
            }
        }

        // GET: Person/Edit/5
        public ActionResult Edit(int id)
        {
            return View(persons[id]);
        }

        // POST: Person/Edit/5
        [HttpPost]
        public ActionResult Edit(int id, PersonViewModel personViewModel)
        {
            try
            {
                // TODO: Add update logic here
                persons[id] = personViewModel;
                return RedirectToAction("Index");
            }
            catch
            {
                return View();
            }
        }

        // GET: Person/Delete/5
        public ActionResult Delete(int id)
        {
            return View(persons[id]);
        }

        // POST: Person/Delete/5
        [HttpPost]
        public ActionResult Delete(int id, PersonViewModel personViewModel)
        {
            try
            {
                // TODO: Add delete logic here
                persons.RemoveAt(id);
                return RedirectToAction("Index");
            }
            catch
            {
                return View();
            }
        }
    }
}
