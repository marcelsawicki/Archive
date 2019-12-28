using System;
using System.Collections.Generic;
using System.Data;
using System.Data.Entity;
using System.Linq;
using System.Net;
using System.Web;
using System.Web.Mvc;
using WebApplication1.Models;

namespace WebApplication1.Controllers
{
    public class TowarsController : Controller
    {
        private MagazynContext db = new MagazynContext();

        // GET: Towars
        public ActionResult Index()
        {
            var towars = db.Towars.Include(t => t.Kategoria);
            return View(towars.ToList());
        }

        // GET: Towars/Details/5
        public ActionResult Details(int? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            Towar towar = db.Towars.Find(id);
            if (towar == null)
            {
                return HttpNotFound();
            }
            return View(towar);
        }

        // GET: Towars/Create
        public ActionResult Create()
        {
            ViewBag.Kategoria_Id = new SelectList(db.Kategorias, "Id", "Id");
            return View();
        }

        // POST: Towars/Create
        // To protect from overposting attacks, please enable the specific properties you want to bind to, for 
        // more details see https://go.microsoft.com/fwlink/?LinkId=317598.
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Create([Bind(Include = "Id,Nazwa,Kategoria_Id")] Towar towar)
        {
            if (ModelState.IsValid)
            {
                db.Towars.Add(towar);
                db.SaveChanges();
                return RedirectToAction("Index");
            }

            ViewBag.Kategoria_Id = new SelectList(db.Kategorias, "Id", "Id", towar.Kategoria_Id);
            return View(towar);
        }

        // GET: Towars/Edit/5
        public ActionResult Edit(int? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            Towar towar = db.Towars.Find(id);
            if (towar == null)
            {
                return HttpNotFound();
            }
            ViewBag.Kategoria_Id = new SelectList(db.Kategorias, "Id", "Id", towar.Kategoria_Id);
            return View(towar);
        }

        // POST: Towars/Edit/5
        // To protect from overposting attacks, please enable the specific properties you want to bind to, for 
        // more details see https://go.microsoft.com/fwlink/?LinkId=317598.
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Edit([Bind(Include = "Id,Nazwa,Kategoria_Id")] Towar towar)
        {
            if (ModelState.IsValid)
            {
                db.Entry(towar).State = EntityState.Modified;
                db.SaveChanges();
                return RedirectToAction("Index");
            }
            ViewBag.Kategoria_Id = new SelectList(db.Kategorias, "Id", "Id", towar.Kategoria_Id);
            return View(towar);
        }

        // GET: Towars/Delete/5
        public ActionResult Delete(int? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            Towar towar = db.Towars.Find(id);
            if (towar == null)
            {
                return HttpNotFound();
            }
            return View(towar);
        }

        // POST: Towars/Delete/5
        [HttpPost, ActionName("Delete")]
        [ValidateAntiForgeryToken]
        public ActionResult DeleteConfirmed(int id)
        {
            Towar towar = db.Towars.Find(id);
            db.Towars.Remove(towar);
            db.SaveChanges();
            return RedirectToAction("Index");
        }

        protected override void Dispose(bool disposing)
        {
            if (disposing)
            {
                db.Dispose();
            }
            base.Dispose(disposing);
        }

        public ActionResult DodajDoKoszyka(int id)
        {
            TowarWybranyKoszyk koszyk = GetKoszyk();
            bool ret = koszyk.Add(db.Towars.Find(id));
            UpdateKoszyk(koszyk);
            return RedirectToAction("Index");
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
