using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;
using WebApplication1.Models;

namespace WebApplication1.Controllers
{
    public class TowarWybranyKoszykController : Controller
    {
        // GET: TowarWybranyKoszyk
        public ActionResult Index()
        {
            return View(GetKoszyk());
        }

        // GET: TowarWybranyKoszyk/Details/5
        public ActionResult Details(int id)
        {
            return View();
        }

        // GET: TowarWybranyKoszyk/Create
        public ActionResult Create()
        {
            return View();
        }

        // POST: TowarWybranyKoszyk/Create
        [HttpPost]
        public ActionResult Create(FormCollection collection)
        {
            try
            {
                // TODO: Add insert logic here

                return RedirectToAction("Index");
            }
            catch
            {
                return View();
            }
        }

        // GET: TowarWybranyKoszyk/Edit/5
        public ActionResult Edit(int id)
        {
            return View();
        }

        // POST: TowarWybranyKoszyk/Edit/5
        [HttpPost]
        public ActionResult Edit(int id, FormCollection collection)
        {
            try
            {
                // TODO: Add update logic here

                return RedirectToAction("Index");
            }
            catch
            {
                return View();
            }
        }

        // GET: TowarWybranyKoszyk/Delete/5
        public ActionResult Delete(int id)
        {
            return View();
        }

        // POST: TowarWybranyKoszyk/Delete/5
        [HttpPost]
        public ActionResult Delete(int id, FormCollection collection)
        {
            try
            {
                // TODO: Add delete logic here

                return RedirectToAction("Index");
            }
            catch
            {
                return View();
            }
        }
        
        // pobranie koszyka to wzorzec Singleton
        // tworzenie tylko wtedy, gdy jest to potrzebne i tylko raz
        public TowarWybranyKoszyk GetKoszyk()
        {
            if (Session["Koszyk"] == null)
            {
                Session["Koszyk"] = new TowarWybranyKoszyk();
            }

            return Session["Koszyk"] as TowarWybranyKoszyk;

        }

        public void UpdateKoszyk(TowarWybranyKoszyk koszyk)
        {
            Session["Koszyk"] = koszyk;
        }
    }
}
