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
        [Required]
        [Display(Name = "Nombre")]
        public string Name { get; set; }
        [Required]
        [Display(Name = "Descripción")]
        public string Description { get; set; }
        [Required]
        [Display(Name = "Cocina")]
        public string Cuisine { get; set; }
        [Required]
        [Display(Name = "Provincia")]
        public string State { get; set; }
        [Required]
        [Display(Name = "Dirección")]
        public string Address { get; set; }
        [Required]
        [Display(Name = "Teléfono")]
        public string PhoneNumber { get; set; }
        [EmailAddress]
        [Required]
        [Display(Name = "Email")]
        public string Email { get; set; }
        public int Rating { get; set; }
        [Required]
        [Display(Name = "Número de mesas")]
        public int Tables { get; set; }
    }
}