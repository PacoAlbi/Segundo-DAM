using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;

namespace UI_ASP.Controllers
{
    public class ListadoController : Controller
    {
        // GET: ListadoController
        public ActionResult Index()
        {
            return View();
        }

        // GET: ListadoController/Details/5
        public ActionResult Details(int id)
        {
            return View();
        }

        // GET: ListadoController/Create
        public ActionResult Create()
        {
            return View();
        }

        // POST: ListadoController/Create
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

        // GET: ListadoController/Edit/5
        public ActionResult Edit(int id)
        {
            return View();
        }

        // POST: ListadoController/Edit/5
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

        // GET: ListadoController/Delete/5
        public ActionResult Delete(int id)
        {
            return View();
        }

        // POST: ListadoController/Delete/5
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
