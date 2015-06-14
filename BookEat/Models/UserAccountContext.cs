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

        public bool exists (string email)
        {
            return getUserAccountByEmail(email) != null ? true : false;
        }

        public UserAccount getUserAccountByEmail(string email)
        {

            UserAccount myUser = UserAccounts.SingleOrDefault(user => user.Email == email);
            return myUser;

        }
    }
}