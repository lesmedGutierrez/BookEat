using System;
using System.Collections.Generic;
using System.Data.Entity;
using System.Linq;
using System.Web;

namespace BookEat.Models
{
    public class UserAccountContext : DbContext
    {
        public DbSet<UserAccount> UserAccounts { get; set; }

        public bool isValid (string email)
        {
            return exists(email);
        }

        private bool exists(string email)
        {
            return getUserAccountByEmail(email) == null ? true : false; 

        }

        public UserAccount getUserAccountByEmail(string email)
        {
            return UserAccounts.Single(user => user.Email == email);
        }
    }
}