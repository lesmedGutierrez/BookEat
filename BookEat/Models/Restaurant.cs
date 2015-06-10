using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;
using System.Linq;
using System.Web;

namespace BookEat.Models
{
    [Table("Restaurant")]
    public class Restaurant
    {
        public int RestaurantID { get; set; }
        [StringLength(150)]
        public string Name { get; set; }
        public string Description { get; set; }
        public string Cuisine { get; set; }
        public string State { get; set; }
        public string Address { get; set; }
        public string PhoneNumber { get; set; }
        public string Email { get; set; }
        public int Rating { get; set; }
        public int Tables { get; set; }
    }
}