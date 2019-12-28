using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;
using System.Web.Routing;

namespace WebApplication1
{
    public class RouteConfig
    {
        public static void RegisterRoutes(RouteCollection routes)
        {
            routes.IgnoreRoute("{resource}.axd/{*pathInfo}");

            routes.MapRoute(
                 name: "MS1",
                 url: "MS1",
                 defaults: new { controller = "Home", action = "MojaStr1" }
             );

            routes.MapRoute(
                 name: "MS2",
                 url: "MS2",
                 defaults: new { controller = "Home", action = "MojaStr2" }
             );

            routes.MapRoute(
                 name: "MS3",
                 url: "MS3",
                 defaults: new { controller = "Home", action = "MojaStr3" }
             );

            routes.MapRoute(
                name: "Default",
                url: "{controller}/{action}/{id}",
                defaults: new { controller = "Home", action = "Index", id = UrlParameter.Optional }
            );

            
        }
    }
}
