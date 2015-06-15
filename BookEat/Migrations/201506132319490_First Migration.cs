namespace BookEat.Migrations
{
    using System;
    using System.Data.Entity.Migrations;
    
    public partial class FirstMigration : DbMigration
    {
        public override void Up()
        {
            RenameTable(name: "dbo.UserAccounts", newName: "UserAccount");
            DropColumn("dbo.UserAccount", "ConfirmPassword");
        }
        
        public override void Down()
        {
            AddColumn("dbo.UserAccount", "ConfirmPassword", c => c.String());
            RenameTable(name: "dbo.UserAccount", newName: "UserAccounts");
        }
    }
}
