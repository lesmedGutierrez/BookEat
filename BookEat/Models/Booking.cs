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
        [Required]
        [Display(Name = "Invitados")]
        public int Guests { get; set; }
        [Required]
        [Display(Name = "Fecha")]
        public DateTime BookingDate { get; set; }
        [Required]
        [Display(Name = "Hora")]
        public DateTime ArrivalDate { get; set; }
        [Required]
        [Display(Name = "Pedidos especiales")]
        public string SpecialRequests { get; set; }
        [Required]
        [Display(Name = "Cliente")]
        public int UserAccountID { get; set; }
        [Required]
        [Display(Name = "Restaurant")]
        public int RestaurantID { get; set; }

    }
}