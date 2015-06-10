using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;
using BookEat.Models;

namespace BookEat.Controllers
{
    public class BookingController : Controller
    {
        //
        // GET: /Booking/
        public ActionResult Index()
        {
            BookingContext bookingContext = new BookingContext();
            List<Booking> bookings = bookingContext.Bookings.ToList();
            return View(bookings);
        }

        //
        // GET: /Booking/Details/5
        public ActionResult Details(int id)
        {
            BookingContext bookingContext = new BookingContext();
            Booking booking = bookingContext.Bookings.Single(per => per.BookingID == id);
            return View(booking);
        }

        //
        // GET: /Booking/Create
        public ActionResult Create()
        {
            return View();
        }

        //
        // POST: /Booking/Create
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

        //
        // GET: /Booking/Edit/5
        public ActionResult Edit(int id)
        {
            BookingContext bookingContext = new BookingContext();
            Booking booking = bookingContext.Bookings.Single(per => per.BookingID == id);
            return View(booking);
        }

        //
        // POST: /Booking/Edit/5
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

        //
        // GET: /Booking/Delete/5
        public ActionResult Delete(int id)
        {
            BookingContext bookingContext = new BookingContext();
            Booking booking = bookingContext.Bookings.Single(per => per.BookingID == id);
            return View(booking);
        }

        //
        // POST: /Booking/Delete/5
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
    }
}
