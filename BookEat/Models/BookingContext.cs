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
    }
}