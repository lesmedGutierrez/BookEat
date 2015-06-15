using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;
using System.Linq;
using System.Web;

namespace BookEat.Models
{
    [Table("Booking")]
    public class Booking
    {
        public int BookingID { get; set; }
        public int Guests { get; set; }
        public DateTime BookingDate { get; set; }
        public DateTime ArrivalDate { get; set; }
        public string SpecialRequests { get; set; }
        public int UserAccountID { get; set; }
        public int RestaurantID { get; set; }

    }
}