using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;
using BookEat.Models;

namespace BookEat.Controllers
{
    public class RestaurantController : Controller
    {
        //
        // GET: /Restaurant/
        public ActionResult Index()
        {
            RestaurantContext restaurantContext = new RestaurantContext();
            List<Restaurant> restaurants = restaurantContext.Restaurants.ToList();
            return View(restaurants);
        }

        //
        // GET: /Restaurant/Details/5
        public ActionResult Details(int id)
        {
            RestaurantContext restaurantContext = new RestaurantContext();
            Restaurant restaurant = restaurantContext.Restaurants.Single(per => per.RestaurantID == id);
            return View(restaurant);
        }

        //
        // GET: /Restaurant/Create
        public ActionResult Create()
        {
            return View();
        }

        //
        // POST: /Restaurant/Create
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
        // GET: /Restaurant/Edit/5
        public ActionResult Edit(int id)
        {
            RestaurantContext restaurantContext = new RestaurantContext();
            Restaurant restaurant = restaurantContext.Restaurants.Single(per => per.RestaurantID == id);
            return View(restaurant);
        }

        //
        // POST: /Restaurant/Edit/5
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
        // GET: /Restaurant/Delete/5
        public ActionResult Delete(int id)
        {
            RestaurantContext restaurantContext = new RestaurantContext();
            Restaurant restaurant = restaurantContext.Restaurants.Single(per => per.RestaurantID == id);
            return View(restaurant);
        }

        //
        // POST: /Restaurant/Delete/5
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
