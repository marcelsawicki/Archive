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
    public class KategoriasController : Controller
    {
        private MagazynContext db = new MagazynContext();

        // GET: Kategorias
        public ActionResult Index()
        {
            var kategorias = db.Kategorias.Include(k => k.NadKategoria);
            return View(kategorias.ToList());
        }

		// GET: Kategorias
		public ActionResult Menu(int? id)
		{
			if (id == null)
			{
				return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
			}
			var kategorias = db.Kategorias.Find(id);

			if (kategorias == null)
			{
				return HttpNotFound();
			}
			return View(kategorias);
		}
		// GET: Kategorias/Details/5
		public ActionResult Details(int? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            Kategoria kategoria = db.Kategorias.Find(id);
            if (kategoria == null)
            {
                return HttpNotFound();
            }
            return View(kategoria);
        }

        // GET: Kategorias/Create
        public ActionResult Create()
        {
            ViewBag.NadKategoriaId = new SelectList(db.Kategorias, "Id", "Nazwa");
            return View();
        }

        // POST: Kategorias/Create
        // To protect from overposting attacks, please enable the specific properties you want to bind to, for 
        // more details see https://go.microsoft.com/fwlink/?LinkId=317598.
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Create([Bind(Include = "Id,Nazwa,NadKategoriaId")] Kategoria kategoria)
        {
            if (ModelState.IsValid)
            {
                db.Kategorias.Add(kategoria);
                db.SaveChanges();
                return RedirectToAction("Index");
            }

            ViewBag.NadKategoriaId = new SelectList(db.Kategorias, "Id", "Nazwa", kategoria.NadKategoriaId);
            return View(kategoria);
        }

        // GET: Kategorias/Edit/5
        public ActionResult Edit(int? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            Kategoria kategoria = db.Kategorias.Find(id);
            if (kategoria == null)
            {
                return HttpNotFound();
            }
            ViewBag.NadKategoriaId = new SelectList(db.Kategorias, "Id", "Nazwa", kategoria.NadKategoriaId);
            return View(kategoria);
        }

        // POST: Kategorias/Edit/5
        // To protect from overposting attacks, please enable the specific properties you want to bind to, for 
        // more details see https://go.microsoft.com/fwlink/?LinkId=317598.
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Edit([Bind(Include = "Id,Nazwa,NadKategoriaId")] Kategoria kategoria)
        {
            if (ModelState.IsValid)
            {
                db.Entry(kategoria).State = EntityState.Modified;
                db.SaveChanges();
                return RedirectToAction("Index");
            }
            ViewBag.NadKategoriaId = new SelectList(db.Kategorias, "Id", "Nazwa", kategoria.NadKategoriaId);
            return View(kategoria);
        }

        // GET: Kategorias/Delete/5
        public ActionResult Delete(int? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            Kategoria kategoria = db.Kategorias.Find(id);
            if (kategoria == null)
            {
                return HttpNotFound();
            }
            return View(kategoria);
        }

        // POST: Kategorias/Delete/5
        [HttpPost, ActionName("Delete")]
        [ValidateAntiForgeryToken]
        public ActionResult DeleteConfirmed(int id)
        {
            Kategoria kategoria = db.Kategorias.Find(id);
            db.Kategorias.Remove(kategoria);
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
