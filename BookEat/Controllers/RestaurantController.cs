using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;
using BookEat.Models;
using System.Net;
using System.Data.Entity;

namespace BookEat.Controllers
{
    public class RestaurantController : Controller
    {
        private RestaurantContext restaurantContext = new RestaurantContext();
        //
        // GET: /Restaurant/
        public ActionResult Index()
        {
            List<Restaurant> restaurants = restaurantContext.Restaurants.ToList();
            return View(restaurants);
        }

        //
        // GET: /Restaurant/Details/5
        public ActionResult Details(int id)
        {
            Restaurant restaurant = restaurantContext.Restaurants.Single(rest => rest.RestaurantID == id);
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
        public ActionResult Create(Restaurant newRestaurant)
        {
            try
            {
                // TODO: Add insert logic here
                restaurantContext.Restaurants.Add(newRestaurant);
                restaurantContext.SaveChanges();
                return RedirectToAction("Index");
            }
            catch
            {
                return View();
            }
        }

        //
        // GET: /Restaurant/Edit/5
        public ActionResult Edit(int id = 0)
        {
            Restaurant restaurant = restaurantContext.Restaurants.Single(rest => rest.RestaurantID == id);
            if (restaurant == null)
            {
                return HttpNotFound();
            }
            return View(restaurant);
        }

        //
        // POST: /Restaurant/Edit/5
        [HttpPost]
        public ActionResult Edit(int id, Restaurant newRestaurant)
        {
            // TODO: Add update logic here
            if (ModelState.IsValid){
                restaurantContext.Entry(newRestaurant).State = EntityState.Modified;
                restaurantContext.SaveChanges();
                return RedirectToAction("Index");
            }
            return View(newRestaurant);
        }

        //
        // GET: /Restaurant/Delete/5
        public ActionResult Delete(int id)
        {
            Restaurant restaurant = restaurantContext.Restaurants.Find(id);
            if (restaurant == null)
            {
                return HttpNotFound();
            }
            return View(restaurant);
        }

        //
        // POST: /Restaurant/Delete/5
        [HttpPost]
        public ActionResult Delete(int id, Restaurant delRestaurant)
        {
            try
            {
                // TODO: Add delete logic here
                restaurantContext.Restaurants.Remove(delRestaurant);
                restaurantContext.SaveChanges();
                return RedirectToAction("Index");
            }
            catch
            {
                return View();
            }
        }
    }
}
