using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;
using BookEat.Models;
using System.Data.Entity;

namespace BookEat.Controllers
{
    public class BookingController : Controller
    {
        private BookingContext bookingContext = new BookingContext();
        //
        // GET: /Booking/
        public ActionResult Index()
        {
            List<Booking> bookings = bookingContext.Bookings.ToList();
            return View(bookings);
        }

        //
        // GET: /Booking/Details/5
        public ActionResult Details(int id)
        {
            Booking booking = bookingContext.getBookingByID(id);
            return View(booking);
        }

        //
        // GET: /Booking/Create
        public ActionResult Create()
        {
            return View();
        }

        public ActionResult Book(Booking newBooking)
        {
            return RedirectToAction("Index", "Home");
        }

        //
        // POST: /Booking/Create
        [HttpPost]
        public ActionResult Create(Booking newBooking)
        {
            try
            {
                /*newBooking.RestaurantID = 1;
                newBooking.UserAccountID = 1;
                newBooking.Guests = 1;
                newBooking.SpecialRequests = "Close to the windows";*/
                // TODO: Add insert logic here
                bookingContext.Bookings.Add(newBooking);
                bookingContext.SaveChanges();
                return RedirectToAction("Index", "Home");
            }
            catch
            {
                return View();
            }
        }

        //
        // GET: /Booking/Edit/5
        public ActionResult Edit(int id = 0)
        {
            Booking booking = bookingContext.getBookingByID(id);
            if (booking == null)
            {
                return HttpNotFound();
            }
            return View(booking);
        }

        //
        // POST: /Booking/Edit/5
        [HttpPost]
        public ActionResult Edit(int id, Booking newBooking)
        {
                // TODO: Add update logic here
                if (ModelState.IsValid)
                {
                    bookingContext.Entry(newBooking).State = EntityState.Modified;
                    bookingContext.SaveChanges();
                    return RedirectToAction("Index");
                }
                return View(newBooking);
        }

        //
        // GET: /Booking/Delete/5
        public ActionResult Delete(int id)
        {

            Booking booking = bookingContext.getBookingByID(id);
            if (booking == null)
            {
                return HttpNotFound();
            }
            return View(booking);
        }

        //
        // POST: /Booking/Delete/5
        [HttpPost]
        public ActionResult Delete(int id, Booking del)
        {
            try
            {
                // TODO: Add delete logic here
                Booking delBooking = bookingContext.getBookingByID(id);
                bookingContext.Bookings.Remove(delBooking);
                bookingContext.SaveChanges();
                return RedirectToAction("Index");
            }
            catch
            {
                return View();
            }
        }
    }
}
