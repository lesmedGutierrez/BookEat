using System;
using System.Collections.Generic;
using System.Data.Entity;
using System.Linq;
using System.Web;

namespace BookEat.Models
{
    public class BookingContext :DbContext
    {
        public DbSet<Booking> Bookings { get; set; }

        public Booking getBookingByID(int id)
        {
            return Bookings.Single(book => book.BookingID == id);
        }

        public List<Booking> getBookingsByUser(int id)
        {
            return Bookings.Where(books => books.UserAccountID == id).ToList();
        }
    }
}