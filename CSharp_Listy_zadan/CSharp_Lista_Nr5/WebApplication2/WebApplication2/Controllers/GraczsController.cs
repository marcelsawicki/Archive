using System;
using System.Collections.Generic;
using System.Data;
using System.Data.Entity;
using System.Linq;
using System.Net;
using System.Web;
using System.Web.Mvc;
using WebApplication2.Models;

namespace WebApplication2.Controllers
{
    public class GraczsController : Controller
    {
        private GraczContext db = new GraczContext();

        // GET: Graczs
        public ActionResult Index()
        {
            return View(db.Graczs.ToList());
        }

        // GET: Graczs/Details/5
        public ActionResult Details(int? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            Gracz gracz = db.Graczs.Find(id);
            if (gracz == null)
            {
                return HttpNotFound();
            }
            return View(gracz);
        }

        // GET: Graczs/Create
        public ActionResult Create()
        {
            return View();
        }

        // POST: Graczs/Create
        // To protect from overposting attacks, please enable the specific properties you want to bind to, for 
        // more details see https://go.microsoft.com/fwlink/?LinkId=317598.
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Create([Bind(Include = "Id,Imie,Nazwisko")] Gracz gracz)
        {
            if (ModelState.IsValid)
            {
                db.Graczs.Add(gracz);
                db.SaveChanges();
                return RedirectToAction("Index");
            }

            return View(gracz);
        }

        // GET: Graczs/Edit/5
        public ActionResult Edit(int? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            Gracz gracz = db.Graczs.Find(id);
            if (gracz == null)
            {
                return HttpNotFound();
            }
            return View(gracz);
        }

        // POST: Graczs/Edit/5
        // To protect from overposting attacks, please enable the specific properties you want to bind to, for 
        // more details see https://go.microsoft.com/fwlink/?LinkId=317598.
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Edit([Bind(Include = "Id,Imie,Nazwisko")] Gracz gracz)
        {
            if (ModelState.IsValid)
            {
                db.Entry(gracz).State = EntityState.Modified;
                db.SaveChanges();
                return RedirectToAction("Index");
            }
            return View(gracz);
        }

        // GET: Graczs/Delete/5
        public ActionResult Delete(int? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            Gracz gracz = db.Graczs.Find(id);
            if (gracz == null)
            {
                return HttpNotFound();
            }
            return View(gracz);
        }

        // POST: Graczs/Delete/5
        [HttpPost, ActionName("Delete")]
        [ValidateAntiForgeryToken]
        public ActionResult DeleteConfirmed(int id)
        {
            Gracz gracz = db.Graczs.Find(id);
            db.Graczs.Remove(gracz);
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
    }
}
