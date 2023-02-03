﻿using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;

namespace Api_Damas.API
{
    [Route("api/[controller]")]
    [ApiController]
    public class SalasController : Controller
    {
        // GET: SalasController
        public ActionResult Index()
        {
            return View();
        }

        // GET: SalasController/Details/5
        public ActionResult Details(int id)
        {
            return View();
        }

        // GET: SalasController/Create
        public ActionResult Create()
        {
            return View();
        }

        // POST: SalasController/Create
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Create(IFormCollection collection)
        {
            try
            {
                return RedirectToAction(nameof(Index));
            }
            catch
            {
                return View();
            }
        }

        // GET: SalasController/Edit/5
        public ActionResult Edit(int id)
        {
            return View();
        }

        // POST: SalasController/Edit/5
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Edit(int id, IFormCollection collection)
        {
            try
            {
                return RedirectToAction(nameof(Index));
            }
            catch
            {
                return View();
            }
        }

        // GET: SalasController/Delete/5
        public ActionResult Delete(int id)
        {
            return View();
        }

        // POST: SalasController/Delete/5
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Delete(int id, IFormCollection collection)
        {
            try
            {
                return RedirectToAction(nameof(Index));
            }
            catch
            {
                return View();
            }
        }
    }
}
