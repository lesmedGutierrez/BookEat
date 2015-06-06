using Microsoft.Owin;
using Owin;

[assembly: OwinStartupAttribute(typeof(BookEat.Startup))]
namespace BookEat
{
    public partial class Startup
    {
        public void Configuration(IAppBuilder app)
        {
            ConfigureAuth(app);
        }
    }
}
